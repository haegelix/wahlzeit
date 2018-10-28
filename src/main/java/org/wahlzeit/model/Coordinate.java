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

package org.wahlzeit.model;

public class Coordinate {
	private double x, y, z;
	
	public Coordinate(double x, double y, double z) {
		checkInput(x);
		checkInput(y);
		checkInput(z);
				
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	private void checkInput(double in) {
		boolean err = false;
		if(Double.isInfinite(in))
			err = true;
		if(Double.isNaN(in))
			err = true;
		
		if(err)
			throw new IllegalArgumentException("The value is not allowed here!");
	}
			
	
	/*
	 * Getters-Section
	 */

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
	
	/**
	 * Calculates the disance beetween the actual object and another Coordinate-Object.
	 * Uses the formula sqrt((x1-x2)^2 + (y1-y2)^2 + (z1-z2)^2)
	 * @param c
	 * @return
	 */
	public double getDistance(Coordinate c) {
		return Math.sqrt(Math.pow(c.getX()-x, 2) + Math.pow(c.getY()-y, 2) + Math.pow(c.getZ()-z, 2));
	}
	
	/**
	 * Determines if the actual objects and another Coordinate-Objects describe the same place.
	 * @param c
	 * @return
	 */
	public boolean isEqual(Coordinate c) {
		if(c.getX() != x)
			return false;
		if(c.getY() != y)
			return false;
		if(c.getZ() != z)
			return false;
		
		return true;
	}

	
	/*
	 * Forwards all .equals(Objects) operations to isEqual(Coordinate).
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		return isEqual((Coordinate) arg0);
	}
}