/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;


// End of user code

/**
 * @author Obeo
 * 
 */
public interface BindingPropertiesEditionPart {

	/**
	 * @return the technology
	 * 
	 */
	public Enumerator getTechnology();

	/**
	 * Init the technology
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTechnology(Object input, Enumerator current);

	/**
	 * Defines a new technology
	 * @param newValue the new technology to set
	 * 
	 */
	public void setTechnology(Enumerator newValue);


	/**
	 * @return the description
	 * 
	 */
	public String getDescription();

	/**
	 * Defines a new description
	 * @param newValue the new description to set
	 * 
	 */
	public void setDescription(String newValue);





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
