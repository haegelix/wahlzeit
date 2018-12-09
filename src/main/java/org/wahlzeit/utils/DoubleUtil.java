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
		return Double.isNaN(a);
	}
	
	public static boolean checkDoubleIsNegOrPosInfinity(double a) {
		return Double.isInfinite(a);
	}
	
	/**
	 * @methodtype assert
	 * @param in
	 */
	public static void checkDouble(double in) throws IllegalArgumentException{
		if(checkDoubleIsNegOrPosInfinity(in))
			throw new IllegalArgumentException("The value must not be infinite!");
		if(checkDoubleIsNaN(in))
			throw new IllegalArgumentException("The value must not be NaN!");
	}
}
