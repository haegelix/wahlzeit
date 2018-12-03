package org.wahlzeit.utils;

public class AssertUtil {
	
	public static boolean checkIsNull(Object o) {
		return o == null;
	}

	public static void assertNotNull(Object o) {
		if(checkIsNull(o))
			throw new IllegalArgumentException("Given object must not be null!");
	}
}
