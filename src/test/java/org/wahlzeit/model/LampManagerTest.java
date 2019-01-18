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

import static org.junit.Assert.*;
import org.wahlzeit.model.LampManager;

import org.junit.Test;

public class LampManagerTest {

	@Test
	public void testInit() throws Exception {
		new LampManager();
	}
	
	@Test
	public void testAssertIsValidLampTypeName() {
		try {
			LampManager.assertIsValidLampTypeName(null);
			fail();
		} catch (NullPointerException e) { }
		try {
			LampManager.assertIsValidLampTypeName("");
			fail();
		} catch (IllegalArgumentException e) { }
	}
	
	/*
	 * Testet auch LampManager#getLampType(String)
	 */
	@Test
	public void testCreateLamp() throws Exception {
		LampManager lm = new LampManager();
		Lamp l = lm.createLamp("testType");
		
		assertTrue(l.lampType == lm.getLampType("testType"));
	}
	
	@Test
	public void testName() throws Exception {
		LampManager lm = new LampManager();
		
		assertTrue(lm.getNewLampId() == lm.getNewLampId()-1);
	}
	

}
