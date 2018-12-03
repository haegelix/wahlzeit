/*
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

import org.junit.Test;

public class LocationTest {

	/*
	 * Test if Location throws Illegal Argument Exception if coordinate is initialised with value null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLocationNoCoordinateDefinedOnInit() {
		new Location(null);
	}

	/*
	 * Test if Location throws IllegalStateException if coordinate has value null when .equals is run.
	 */
	@Test(expected = IllegalStateException.class)
	public void testLocationNoCoordinateDefinedOnEquals() {
		Location l = new Location(new CartesianCoordinate(3,2,1));
		Location lc = new Location(new CartesianCoordinate(3,2,1));
		l.coordinate = null;
		l.equals(lc);
	}

	/*
	 * Test if Location throws IllegalArgumentException if coordinate has value null when .equals is run.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLocationNoCoordinateDefinedOnEqualsParameter() {
		Location l = new Location(new CartesianCoordinate(3,2,1));
		l.equals(null);
	}

	/*
	 * Test .equals with values for coordinates.
	 */
	/*
	@Test
	public void testLocationEquals() {
		Location l = new Location(new CartesianCoordinate(3,2,1));
		Location lc1 = new Location(new CartesianCoordinate(3,2,1));
		Location lc2 = new Location(new CartesianCoordinate(3,3,3));
		
		assertTrue(l.equals(lc1));
		assertFalse(l.equals(lc2));
	}*/
	
}
