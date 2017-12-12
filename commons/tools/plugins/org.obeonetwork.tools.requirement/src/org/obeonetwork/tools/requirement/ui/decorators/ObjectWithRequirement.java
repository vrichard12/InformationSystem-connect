/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.requirement.ui.decorators;

import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.core.util.RequirementService;

/**
 * An example showing how to control when an element is decorated. This example
 * decorates only elements that are instances of IResource and whose attribute
 * is 'Read-only'.
 * 
 * @see ILightweightLabelDecorator
 */
public class ObjectWithRequirement implements ILightweightLabelDecorator {
	public static final String DECORATOR_ID = "org.obeonetwork.tools.requirement.ui.decorators.ObjectWithRequirement";
	
	private int quadrant = IDecoration.BOTTOM_RIGHT;

	/** The icon image location in the project folder */
	private static final String ICON_PATH_DIRECT_NO_CHILDREN = "icons/ObjectWithRequirementDecorator_yellow.png"; //NON-NLS-1
	private static final String ICON_PATH_DIRECT_AND_CHILDREN = "icons/ObjectWithRequirementDecorator_orange.png"; //NON-NLS-1
	private static final String ICON_PATH_ONLY_CHILDREN = "icons/ObjectWithRequirementDecorator_grey.png"; //NON-NLS-1
	
	private static final URL ICON_URL_DIRECT_NO_CHILDREN = FileLocator.find(Platform.getBundle("org.obeonetwork.tools.requirement"), new Path(ICON_PATH_DIRECT_NO_CHILDREN), null); //NON-NLS-1
	private static final URL ICON_URL_DIRECT_AND_CHILDREN = FileLocator.find(Platform.getBundle("org.obeonetwork.tools.requirement"), new Path(ICON_PATH_DIRECT_AND_CHILDREN), null); //NON-NLS-1
	private static final URL ICON_URL_ONLY_CHILDREN = FileLocator.find(Platform.getBundle("org.obeonetwork.tools.requirement"), new Path(ICON_PATH_ONLY_CHILDREN), null); //NON-NLS-1
	
	private static final ImageDescriptor DESCRIPTOR_DIRECT_NO_CHILDREN = ImageDescriptor.createFromURL(ICON_URL_DIRECT_NO_CHILDREN);
	private static final ImageDescriptor DESCRIPTOR_DIRECT_AND_CHILDREN = ImageDescriptor.createFromURL(ICON_URL_DIRECT_AND_CHILDREN);
	private static final ImageDescriptor DESCRIPTOR_ONLY_CHILDREN = ImageDescriptor.createFromURL(ICON_URL_ONLY_CHILDREN);

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang.Object, org.eclipse.jface.viewers.IDecoration)
	 */
	public void decorate(Object element, IDecoration decoration) {
		ImageDescriptor descriptor = null;
		if (element instanceof IFile) {
			if (!(element instanceof IProject)) {
				// Decorate resource
				Resource resource = getResourceFromFile((IFile)element);
				descriptor = getDescriptor(resource);				
			}
		} else if (element instanceof EObject) { // CDOResource are also EObject so they will be handled here
			descriptor = getDescriptor((EObject)element);
		}
		
		// Add decoration if a descriptor has been found
		if (descriptor != null) {
			decoration.addOverlay(descriptor, quadrant);
		}
	}
	
	public static boolean isDecoratorEnabled() {
		return PlatformUI.getWorkbench().getDecoratorManager().getEnabled(ObjectWithRequirement.DECORATOR_ID);
	}
	
	/**
	 * Returns the full image path for the decorator
	 * This method is intended to be called by the Requirements VSM's decoration  
	 * @param element
	 * @return
	 */
	public static String getImagePathForDecorator(EObject element) {
		String pluginPrefix = "/" + RequirementLinkerPlugin.PLUGIN_ID + "/";
		
		boolean direct = RequirementService.hasLinkedRequirement(element);
		boolean child = RequirementService.hasDescendantWithLinkedRequirement(element);
		if (direct && child) {
			return pluginPrefix + ICON_PATH_DIRECT_AND_CHILDREN;
		} else if (direct && !child) {
			return pluginPrefix + ICON_PATH_DIRECT_NO_CHILDREN;
		} else if (!direct && child) {
			return pluginPrefix + ICON_PATH_ONLY_CHILDREN;
		}
		return null;
	}
	
	/**
	 * Returns the right ImageDescriptor depending on the element
	 * @param element
	 * @return an ImageDescriptor to be used as decorator or null if no decoration should occur
	 */
	private ImageDescriptor getDescriptor(EObject element) {
		boolean direct = RequirementService.hasLinkedRequirement(element);
		boolean child = RequirementService.hasDescendantWithLinkedRequirement(element);
		if (direct && child) {
			return DESCRIPTOR_DIRECT_AND_CHILDREN;
		} else if (direct && !child) {
			return DESCRIPTOR_DIRECT_NO_CHILDREN;
		} else if (!direct && child) {
			return DESCRIPTOR_ONLY_CHILDREN;
		}
		return null;
	}
	
	/**
	 * Returns the right ImageDescriptor depending for a resource by lloking at its children
	 * @param resource
	 * @return
	 */
	private ImageDescriptor getDescriptor(Resource resource) {
		if (resource != null) {
			boolean child = RequirementService.hasLinkedRequirementOrDescendantWithLinkedRequirement(resource.getContents());
			if (child) {
				return DESCRIPTOR_ONLY_CHILDREN; 
			}
		}
		return null;
	}
	
	/**
	 * Retrieves a resource corresponding to a workspace file
	 * @param file
	 * @return
	 */
	private Resource getResourceFromFile(IFile file) {
		URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		
		IProject project = file.getProject();
		Option<ModelingProject> optionModelingProject = ModelingProject.asModelingProject(project);
		if (optionModelingProject.some()) {
			ModelingProject modelingProject = optionModelingProject.get();
			Session session = modelingProject.getSession();
			if (session != null) {
				for (Resource resource : session.getSemanticResources()) {
					if (fileURI.equals(resource.getURI())) {
						return resource;
					}
				}
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
	}
}