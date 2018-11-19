package org.wahlzeit.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class doubleUtilTest {
	@Test
	public void testDoubleEquals() throws Exception {
		double d = 1.00;
		double d_true = d + doubleUtil.DELTA / 2;
		double d_false = d + doubleUtil.DELTA * 2;

		assertTrue(doubleUtil.doubleEquals(d, d_true));
		assertFalse(doubleUtil.doubleEquals(d, d_false));
	}
	
	@Test
	public void testDoubleEqualsWithIndividualDelta() throws Exception {
		double DELTA = 0.1;
		double d = 1.00;
		double d_true = d + DELTA / 2;
		double d_false = d + DELTA * 2;
		
		assertTrue(doubleUtil.doubleEquals(d, d_true));
		assertFalse(doubleUtil.doubleEquals(d, d_false));
	}
}
