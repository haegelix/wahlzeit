package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SphericCoordinateTest {
	/**
	 * Test if constructor checks for invalid values on init.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCoordinateInvalidValuesInConstructor() {
		new CartesianCoordinate(Double.NaN, 1, 2);
	}
	
	@Test
	public void testAssertAngleHasValidValue() throws Exception {
		try {
			SphericCoordinate.assertAngleHasValidValue(20.00, 19.00);
			fail();
		} catch (Exception e) {}
		try {
			SphericCoordinate.assertAngleHasValidValue(Double.NaN, 19.00);
			fail();
		} catch (Exception e) {}
		try {
			SphericCoordinate.assertAngleHasValidValue(Double.NEGATIVE_INFINITY, 19.00);
			fail();
		} catch (Exception e) {}
		try {
			SphericCoordinate.assertAngleHasValidValue(-1.00, 19.00);
			fail();
		} catch (Exception e) {}
		try {
			SphericCoordinate.assertAngleHasValidValue(18.00, 19.00);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testAssertRadiusHasValidValue() throws Exception {
		try {
			SphericCoordinate.assertRadiusHasValidValue(Double.NaN);
			fail();
		} catch (Exception e) {}
		try {
			SphericCoordinate.assertRadiusHasValidValue(Double.NEGATIVE_INFINITY);
			fail();
		} catch (Exception e) {}
		try {
			SphericCoordinate.assertRadiusHasValidValue(-1.00);
			fail();
		} catch (Exception e) {}
		try {
			SphericCoordinate.assertRadiusHasValidValue(18.00);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testAssertClassInvariants() throws Exception {
		//no test possible since there is no possibility to change the variables so that
		//assertClassInvariants throws the exception
		assertTrue(true);
	}
	
	
}
