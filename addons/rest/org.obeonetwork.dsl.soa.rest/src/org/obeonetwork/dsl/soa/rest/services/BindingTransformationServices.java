package org.obeonetwork.dsl.soa.rest.services;

import org.obeonetwork.dsl.environment.BindingRegistry;
import org.obeonetwork.dsl.interaction.CallMessage;
import org.obeonetwork.dsl.interaction.design.services.ParameterValueServices;
import org.obeonetwork.dsl.object.Workspace;


public class BindingTransformationServices {
	
	public static void executeBindingTransformation(CallMessage callMessage) {
		Workspace targetWorkspace = callMessage.getRuntimeWorkspace();
		// TODO Manage error case
		
		Workspace sourceWorkspace = callMessage.getParameterValues().stream()
		.map(pv -> ParameterValueServices.getValue(pv))
		.filter(Workspace.class::isInstance).map(Workspace.class::cast)
		.findFirst().orElse(null);
		// TODO Manage error case
		
		BindingRegistry bindingRegistry = (BindingRegistry) callMessage.getFinishingEnd().getContext().getType();
		// TODO Manage error case
		
		Binder binder = new Binder(sourceWorkspace, targetWorkspace, bindingRegistry);
		binder.transform();
	}

}
