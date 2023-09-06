package org.obeonetwork.dsl.soa.rest.services;

import org.obeonetwork.dsl.environment.services.ObeoDSMObjectService;
import org.obeonetwork.dsl.interaction.CallMessage;
import org.obeonetwork.dsl.interaction.Participant;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.SecurityScheme;
import org.obeonetwork.dsl.soa.SecuritySchemeType;
import org.obeonetwork.dsl.soa.Service;
import org.obeonetwork.dsl.soa.Verb;
import org.obeonetwork.utils.common.EObjectUtils;

import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class RestServices {

	public static void executeRestOperation(CallMessage callMessage) {
//		HttpResponse<String> response = Unirest.request(operation.getVerb().getLiteral(), baseUrl + queryParameters)
//		  .header("accept", "application/json")
//		  .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkMWUxZGE5MTg4MmViYmQxMGZjMDdmNzM5MWU2MzZlNSIsInN1YiI6IjY0YjRmMGZmMTIxOTdlMDExY2FhN2JjZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.UJV3Q-G9U26YqQiXg3D1_BC9ncSZ-kuXtCZCI5P_yCA")
//		  .asString();
		
		Operation operation = (Operation) callMessage.getAction();
		
		if(operation.getVerb() != Verb.GET) {
			throw new UnsupportedOperationException(operation.getName() + " is a " + operation.getVerb().getLiteral());
		}
		
		String baseUrl = getBaseUrl(operation);
		String queryParameters = getQueryParameters(callMessage);
		
		GetRequest httpRequest = Unirest.get(baseUrl + queryParameters);
		
		operation.getOutput().stream()
		.filter(p -> p.getStatusCode() != null && p.getStatusCode().startsWith("2"))
		.flatMap(p -> p.getMediaType().stream())
		.forEach(mediaType -> httpRequest.header("accept", mediaType.getIdentifier()));
		
		addAuthentication(httpRequest, callMessage);
		
		HttpResponse<String> response = httpRequest.asString();
		
		System.out.println(response.getBody());
		
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

	/**
	 * @param callMessage
	 * @return Example: "?language=en-US&page=1"
	 */
	private static String getQueryParameters(CallMessage callMessage) {
		// TODO Auto-generated method stub
		return "";
	}

}
