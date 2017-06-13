/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.graal.parts;

// Start of user code for imports



// End of user code

/**
 * 
 * 
 */
public interface PersistencePropertiesEditionPart {

	/**
	 * @return the estimatedVolumetry
	 * 
	 */
	public String getEstimatedVolumetry();

	/**
	 * Defines a new estimatedVolumetry
	 * @param newValue the new estimatedVolumetry to set
	 * 
	 */
	public void setEstimatedVolumetry(String newValue);


	/**
	 * @return the historized
	 * 
	 */
	public Boolean getHistorized();

	/**
	 * Defines a new historized
	 * @param newValue the new historized to set
	 * 
	 */
	public void setHistorized(Boolean newValue);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
