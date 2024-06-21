package org.obeonetwork.dsl.soa.rest.handlers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.obeonetwork.dsl.interaction.CallMessage;
import org.obeonetwork.dsl.soa.rest.services.RestServices;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

public class RestCallMessageExectutionHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		Object selection = EventHelper.uwrapSingleSelection(event, Object.class);
		CallMessage callMessage = RestSelectionHelper.unwrapCallMessage(selection);

		Session session = new EObjectQuery(callMessage).getSession();
		TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
		
		ted.getCommandStack().execute(new RecordingCommand(ted) {
			
			@Override
			protected void doExecute() {
				try {
					RestServices.executeRestOperation(callMessage);
				} catch (URISyntaxException | IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		return null;
	}

}