package org.obeonetwork.dsl.object.design.handlers;

import static org.obeonetwork.dsl.object.design.IObjectViewpointConstants.OBJECT_WORKSPACE_DIAGRAM_ID;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.swt.widgets.Display;
import org.obeonetwork.dsl.object.ObjectFactory;
import org.obeonetwork.dsl.object.Workspace;
import org.obeonetwork.utils.common.SessionUtils;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;
import org.obeonetwork.utils.common.ui.services.SiriusUIUtils;

public class CreateNewWorkspaceHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IFile file = EventHelper.uwrapSingleSelection(event, IFile.class);
		Session session = SessionUtils.getSessionFromSemanticIFile(file);
		Resource resource = SessionUtils.getSemanticResource(session, file);
		
		String workspaceName = "Workspace" + 
				(resource.getContents().stream()
				.filter(Workspace.class::isInstance)
				.count() + 1);
		
		final InputDialog promptName = new InputDialog(Display.getDefault().getActiveShell(),
				"New Workspace",
				"Name:",
				workspaceName,
				null);
		if(promptName.open() != Window.OK) {
			return null;
		}
		workspaceName = promptName.getValue();
		
		Workspace workspace = ObjectFactory.eINSTANCE.createWorkspace();
		workspace.setName(workspaceName);
		
		session.getTransactionalEditingDomain().getCommandStack().execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
			@Override
			protected void doExecute() {
				resource.getContents().add(workspace);
			}
		});
		
		DRepresentation dRepresentation = SiriusUIUtils.createRepresentation(session, workspace, OBJECT_WORKSPACE_DIAGRAM_ID, new NullProgressMonitor());
		DialectUIManager.INSTANCE.openEditor(session, dRepresentation, new NullProgressMonitor());
		
		return null;
	}
	
}