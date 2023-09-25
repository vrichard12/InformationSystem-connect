package org.obeonetwork.dsl.soa.rest.services;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.io.IOException;
import java.util.Map;

import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.services.ObeoDSMObjectService;
import org.obeonetwork.dsl.interaction.CallMessage;
import org.obeonetwork.dsl.interaction.ParameterValue;
import org.obeonetwork.dsl.interaction.Participant;
import org.obeonetwork.dsl.interaction.design.services.ParameterValueServices;
import org.obeonetwork.dsl.object.PrimitiveTypeValue;
import org.obeonetwork.dsl.object.Workspace;
import org.obeonetwork.dsl.object.edit.util.PrimitiveTypeValueService;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.Parameter;
import org.obeonetwork.dsl.soa.ParameterPassingMode;
import org.obeonetwork.dsl.soa.SecurityScheme;
import org.obeonetwork.dsl.soa.SecuritySchemeType;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.Verb;
import org.obeonetwork.dsl.soa.rest.transfo.JsonToObjectBuilder;
import org.obeonetwork.dsl.technicalid.Identifiable;
import org.obeonetwork.utils.common.EObjectUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class RestServices {

	public static void executeRestOperation(CallMessage callMessage) {
		
		Operation operation = (Operation) callMessage.getAction();
		
		if(operation.getVerb() != Verb.GET) {
			throw new UnsupportedOperationException(operation.getName() + " is a " + operation.getVerb().getLiteral());
		}
		
		String baseUrl = getBaseUrl(operation);
		baseUrl = injectPathParameters(baseUrl, callMessage);
		String queryParameters = getQueryParameters(callMessage);
		
		GetRequest httpRequest = Unirest.get(baseUrl + queryParameters);
		
		operation.getOutput().stream()
		.filter(p -> p.getStatusCode() != null)
		.flatMap(p -> p.getMediaType().stream())
		.forEach(mediaType -> httpRequest.header("accept", mediaType.getIdentifier()));
		
		addAuthentication(httpRequest, callMessage);
		
		HttpResponse<String> response = httpRequest.asString();
		
		ObjectMapper jsonObjectMapper = new ObjectMapper();
		JsonNode jsonResponse = null;
		try {
			jsonResponse = jsonObjectMapper.readTree(response.getBody());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(String.format("[INFO] Return status code = %d. For GET %s", response.getStatus(), baseUrl + queryParameters));
		
		Workspace workspace = callMessage.getRuntimeWorkspace();
		
		Type returnType = operation.getOutput().stream()
		.filter(p -> p.getStatusCode() != null && p.getStatusCode().matches("[0-9]+"))
		.filter(p -> Integer.parseInt(p.getStatusCode()) == response.getStatus())
		.map(p -> p.getType())
		.findFirst().orElse(null);

		if(returnType == null) {
			System.out.println(String.format("[WARNING] Return status code doesn't match any output parameter. Status code = %d.", response.getStatus()));
		} else if(!(returnType instanceof StructuredType)) {
			System.out.println(String.format("[WARNING] Return type of type %s not handled.", returnType.getClass().getName()));
		}
		
		new JsonToObjectBuilder(jsonResponse, (StructuredType) returnType, workspace).build();
		
	}

	private static void addAuthentication(GetRequest httpRequest, CallMessage callMessage) {
		Operation soaOperation = (Operation) callMessage.getAction();
		Component soaComponent = EObjectUtils.getContainer(soaOperation, Component.class);
		
		Participant interactionParticipant = callMessage.getFinishingEnd().getContext();
				
		String security = ObeoDSMObjectService.getAnnotationValue(interactionParticipant, "SECURITY");
		
		SecuritySchemeType securitySchemeType = getSecuritySchemeType(security);
		String securitySchemeName = getSecuritySchemeName(security);
		
		SecurityScheme securityScheme = soaComponent.getSecuritySchemes().stream()
		.filter(ss -> ss.getType() == securitySchemeType)
		.filter(ss -> securitySchemeName == null || securitySchemeName.equals(ss.getName()))
		.findFirst().orElse(null);
		
		String securitySchemeKey = securityScheme.getKey();
		
		switch(securitySchemeType) {
		case API_KEY:
			String securityToken = ObeoDSMObjectService.getAnnotationValue(interactionParticipant, "SECURITY-TOKEN");
			httpRequest.header(securitySchemeKey, "Bearer " + securityToken);
			break;
		case HTTP:
			// TODO
			break;
		case OAUTH2:
			// TODO
			break;
		case OPEN_ID_CONNECT:
			// TODO
			break;
		}
		
	}

	private static String getSecuritySchemeName(String security) {
		String securitySchemeName = null;
		if(security.matches(".*\\[[^\\]]*\\]")) {
			securitySchemeName = security.substring(security.indexOf("[") + 1, security.indexOf("]"));
		}
		
		return securitySchemeName;
	}

	private static SecuritySchemeType getSecuritySchemeType(String security) {
		// API-KEY[sec0]
		
		String securityTypeName = (security.contains("["))? 
				security.substring(0, security.indexOf("[")) : 
				security;
		
		return SecuritySchemeType.valueOf(securityTypeName);
	}

	/**
	 * @param soaOperation
	 * @return Example: "https://api.themoviedb.org/3/movie/popular"
	 */
	private static String getBaseUrl(Operation soaOperation) {
		Service soaService = EObjectUtils.getContainer(soaOperation, Service.class);
		Component soaComponent = EObjectUtils.getContainer(soaService, Component.class);
		
		String serverUrl = soaComponent.getServers().get(0).getURL(); // TODO Parameterize the choice of the server
		
		return serverUrl + soaComponent.getURI() + soaService.getURI() + soaOperation.getURI();
	}
	
	private static String injectPathParameters(String baseUrl, CallMessage callMessage) {
		String injectedBaseUrl = baseUrl;
		
		Operation operation = (Operation) callMessage.getAction();
		
		Map<String, Parameter> pathParameters = operation.getInput().stream()
		.filter(p -> p.getRestData().getPassingMode() == ParameterPassingMode.PATH)
		.collect(toMap(p -> p.getName(), p -> p));

		for(ParameterValue parameterValue : callMessage.getParameterValues().stream()
		.filter(parameterValue -> pathParameters.keySet().contains(parameterValue.getName()))
		.collect(toList())) {
			injectedBaseUrl = injectedBaseUrl.replaceAll("\\{" + pathParameters.get(parameterValue.getName()).getRestData().getRestId() + "\\}", toQueryValueString(parameterValue));
		}

		return injectedBaseUrl;
	}


	/**
	 * @param callMessage
	 * @return Example: "?language=en-US&page=1"
	 */
	private static String getQueryParameters(CallMessage callMessage) {
		Operation operation = (Operation) callMessage.getAction();
		
		Map<String, Parameter> queryParameters = operation.getInput().stream()
		.filter(p -> p.getRestData().getPassingMode() == ParameterPassingMode.QUERY)
		.collect(toMap(p -> p.getName(), p -> p));
		
		String queryParametersString = callMessage.getParameterValues().stream()
		.filter(parameterValue -> queryParameters.keySet().contains(parameterValue.getName()))
		.map(parameterValue -> queryParameters.get(parameterValue.getName()).getRestData().getRestId() + "=" + toQueryValueString(parameterValue))
		.collect(joining("&"));
		
		if(!queryParametersString.isEmpty()) {
			queryParametersString = "?" + queryParametersString;
		}
		return queryParametersString;
	}

	private static String toQueryValueString(ParameterValue parameter) {
		Identifiable value = ParameterValueServices.getValue(parameter);
		if(!(value instanceof PrimitiveTypeValue)) {
			System.out.println(String.format("[ERROR] Parameter type not handled for parameter %s of type %s.", parameter.getName(), value.eClass().getName()));
			return null;
		}
		
		return PrimitiveTypeValueService.getPrimitiveTypeDataAsString((PrimitiveTypeValue) value);
	}

}
