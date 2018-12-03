package org.wahlzeit.utils;

public final class DoubleUtil {
	public static final double DELTA = 0.000000001;
	
	public static boolean doubleEquals(double a, double b) {
		return doubleEquals(a, b, DELTA);
	}
	
	public static boolean doubleEquals(double a, double b, double delta) {
		if(a + delta > b && a - delta < b)
			return true;
		return false;
	}
	
	public static boolean checkDoubleIsNaN(double a) {
		return a == Double.NaN;
	}
	
	public static boolean checkDoubleIsNegOrPosInfinity(double a) {
		return a == Double.POSITIVE_INFINITY || a == Double.NEGATIVE_INFINITY;
	}
}
