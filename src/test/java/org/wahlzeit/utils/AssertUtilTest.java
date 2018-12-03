package org.wahlzeit.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssertUtilTest {
	
	@Test
	public void testCheckIsNull() throws Exception {
		assertTrue(AssertUtil.checkIsNull(null));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAssertNotNull() throws Exception {
		AssertUtil.assertNotNull(null);
	}
}
