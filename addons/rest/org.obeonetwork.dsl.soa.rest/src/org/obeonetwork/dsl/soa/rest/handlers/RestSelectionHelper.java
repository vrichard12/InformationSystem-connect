package org.obeonetwork.dsl.soa.rest.handlers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDiagramElementEditPart;
import org.obeonetwork.dsl.interaction.CallMessage;

public class RestSelectionHelper {

	public static CallMessage unwrapCallMessage(Object selection) {
		CallMessage callMessage = null;
		if(selection instanceof IDiagramElementEditPart) {
			DDiagramElement diagramElement = ((IDiagramElementEditPart) selection).resolveDiagramElement();
			callMessage = (CallMessage) diagramElement.getTarget();
		} else if(selection instanceof EObject) {
			callMessage = (CallMessage) selection;
		}
		
		return callMessage;
	}

}
