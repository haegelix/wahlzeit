package org.wahlzeit.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleUtilTest {
	@Test
	public void testDoubleEquals() throws Exception {
		double d = 1.00;
		double d_true = d + DoubleUtil.DELTA / 2;
		double d_false = d + DoubleUtil.DELTA * 2;

		assertTrue(DoubleUtil.doubleEquals(d, d_true));
		assertFalse(DoubleUtil.doubleEquals(d, d_false));
	}
	
	@Test
	public void testDoubleEqualsWithIndividualDelta() throws Exception {
		double DELTA = 0.1;
		double d = 1.00;
		double d_true = d + DELTA / 2;
		double d_false = d + DELTA * 2;
		
		assertTrue(DoubleUtil.doubleEquals(d, d_true, DELTA));
		assertFalse(DoubleUtil.doubleEquals(d, d_false, DELTA));
	}
	
	@Test
	public void testCheckDoubleIsNaN() throws Exception {
		assertTrue(DoubleUtil.checkDoubleIsNaN(Double.NaN));
	}
	
	@Test
	public void testCheckDoubleIsNegOrPosInfinity() throws Exception {
		assertTrue(DoubleUtil.checkDoubleIsNegOrPosInfinity(Double.POSITIVE_INFINITY));
		assertTrue(DoubleUtil.checkDoubleIsNegOrPosInfinity(Double.NEGATIVE_INFINITY));
	}
}
