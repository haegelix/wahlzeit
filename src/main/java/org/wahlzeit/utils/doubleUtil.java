package org.wahlzeit.utils;

public final class doubleUtil {
	public static final double DELTA = 0.000000001;
	
	public static boolean doubleEquals(double a, double b) {
		return doubleEquals(a, b, DELTA);
	}
	
	public static boolean doubleEquals(double a, double b, double delta) {
		if(a + delta > b && a - delta < b)
			return true;
		return false;
	}
}
