/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

public class LampType {

	protected LampManager manager;
	private LampType parent;
	
	
	public LampType(LampManager manager) {
		this.manager = manager;
	}

	/**
	 * Creates a new Lamp-TypeObject.
	 * @return
	 */
	public Lamp createInstance() {
		return new Lamp(this);
	}
	
	/**
	 * Determines if this object is a subtype of any other LampType.
	 * @return true or false
	 */
	public boolean isSubtype() {
		return !(parent == null);
	}
	
	/**
	 * Determines if this object is a subtype of a specific LampType.
	 * @param parent The value so search for in the childs anchestors.
	 * @return true or false
	 */
	public boolean isSubtypeOf(LampType parent) {
		for(LampType l = this.parent; l != null; l=l.parent) {
			if(l == parent)
				return true;
		}
		return false;
	}
	
	/*
	 * SETTERS SECTION
	 */
	
	public void setParent(LampType parent) {
		this.parent = parent;
	}
	
	/*
	 * GETTERS SECTION
	 */
	
	public LampType getParent() {
		return parent;
	}
	
	public LampManager getLampManager() {
		return manager;
	}
	
}
