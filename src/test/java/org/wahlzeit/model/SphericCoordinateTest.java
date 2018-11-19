package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SphericCoordinateTest {
	/**
	 * Test if constructor checks for invalid values on init.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCoordinateInvalidValues() {
		new CartesianCoordinate(Double.NaN, 1, 2);
	}
}
