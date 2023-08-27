package org.obeonetwork.dsl.object.design.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.navigator.CommonNavigator;
import org.obeonetwork.dsl.object.Workspace;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

public class DeleteWorkspaceHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		List<Workspace> workspaces = EventHelper.uwrapMultipleSelection(event, Workspace.class);

		// Access to the resource file from the selection
		Resource resource = workspaces.get(0).eResource();
		String resourceURIPlatformString = resource.getURI().toPlatformString(true);
		IFile resourceFile = (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(resourceURIPlatformString);

		// Delete the selected Workspaces
		Session session = SessionManager.INSTANCE.getSession(workspaces.get(0));
		session.getTransactionalEditingDomain().getCommandStack().execute(new RecordingCommand(session.getTransactionalEditingDomain()) {

			@Override
			protected void doExecute() {
				workspaces.forEach(EcoreUtil::delete);
			}
		});

		// The active part is the Model Explorer
		CommonNavigator modelExplorer = (CommonNavigator) HandlerUtil.getActivePart(event);

		// Set the new selection to the resource file
		modelExplorer.selectReveal(new StructuredSelection(resourceFile));

		// Try to refresh the model explorer
		IHandlerService handlerService = PlatformUI.getWorkbench().getService(IHandlerService.class);
		try {
			handlerService.executeCommand("org.eclipse.ui.file.refresh", null);
		} catch (ExecutionException | NotDefinedException | NotEnabledException | NotHandledException e) {
			e.printStackTrace();
		}

		return null;
	}

}
