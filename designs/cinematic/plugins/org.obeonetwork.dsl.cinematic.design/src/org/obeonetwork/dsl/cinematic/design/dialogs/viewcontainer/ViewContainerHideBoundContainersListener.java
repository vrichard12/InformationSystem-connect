package org.obeonetwork.dsl.cinematic.design.dialogs.viewcontainer;

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 *  
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a> 
 */
public class ViewContainerHideBoundContainersListener extends SelectionAdapter {

	private ViewContainerTreeContentProvider containerTreeContentProvider;
	private CheckboxTreeViewer checkboxTreeViewer;
	
	public ViewContainerHideBoundContainersListener(CheckboxTreeViewer checkboxTreeViewer, ViewContainerTreeContentProvider containerTreeContentProvider) {
		this.checkboxTreeViewer = checkboxTreeViewer;
		this.containerTreeContentProvider = containerTreeContentProvider;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {		
		containerTreeContentProvider.switchHideContainersBoundToOtherViewStates();
		checkboxTreeViewer.refresh();
	}

}
