package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;
import org.wahlzeit.utils.DoubleUtil;

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

public class CartesianCoordinateTest {
	
	/**
	 * Test if constructor checks for invalid values on init.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCoordinateInvalidValues() {
		new CartesianCoordinate(Double.NaN, 1, 2);
	}
	
	/**
	 * Test if .equals and .isEqual return the same value.
	 */
	@Test
	public void testCoordinateEqualsIsEqualToIsEqual() {
		Random r = new Random();
		double x1 = r.nextDouble()*r.nextInt(100);
		double y1 = r.nextDouble()*r.nextInt(100);
		double z1 = r.nextDouble()*r.nextInt(100);
		CartesianCoordinate c1 = new CartesianCoordinate(x1, y1, z1);
		double x2 = r.nextDouble()*r.nextInt(100);
		double y2 = r.nextDouble()*r.nextInt(100);
		double z2 = r.nextDouble()*r.nextInt(100);
		CartesianCoordinate c2 = new CartesianCoordinate(x2, y2, z2);
		
		assertEquals(c1.equals(c2),c1.isEqual(c2));
	}
	
	
	
	/**
	 * Test if .getCartesianDistance calculates correct value.
	 */
	@Test
	public void testCoordinateGetDistance() {
		CartesianCoordinate c1 = new CartesianCoordinate(1, 1, 1);
		CartesianCoordinate c2 = new CartesianCoordinate(2, 2, 2);
		
		assertEquals(c1.getCartesianDistance(c2), Math.sqrt(3), DoubleUtil.DELTA);
	}
	
	
}
