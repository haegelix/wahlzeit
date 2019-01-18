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

import java.util.HashMap;

import org.wahlzeit.services.ObjectManager;

public class LampManager extends ObjectManager {

	private HashMap<Integer,Lamp> lamps = new HashMap<>();
	
	private HashMap<String, LampType> lamptype = new HashMap<>();
	
	private int lastLampId = 0;
	
	public LampManager() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Lamp createLamp(String typeName) {
		assertIsValidLampTypeName(typeName);
		LampType ft = getLampType(typeName);
		Lamp result = ft.createInstance();
		lamps.put(getNewLampId(), result);
		return result;
	}

	/**
	 * 
	 * @methodtype assert
	 * @param typeName
	 */
	protected static void assertIsValidLampTypeName(String typeName) throws NullPointerException, IllegalArgumentException {
		if(typeName == null) {
			throw new NullPointerException("Value <null> is not allowed for variable <typename>.");
		} else if(typeName.equals("")) {
			throw new IllegalArgumentException("Value <\"\"> is not allowed for variable <typename>.");
		} 
	}

	/**
	 * Returns an existing lampType if one is found for the typeName.
	 * If none is found a new one will be created.
	 * @param typeName
	 * @return
	 */
	protected LampType getLampType(String typeName) {
		LampType result = lamptype.get(typeName);
		if(result == null) {
			result = new LampType(this);
			lamptype.put(typeName, result);
		}
		return result;
	}
	
	/**
	 * Gives a new lamp-id.
	 * @return
	 */
	protected Integer getNewLampId() {
		lastLampId++;
		return lastLampId;
	}
	
	
	
	

}
