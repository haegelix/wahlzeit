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

import org.wahlzeit.utils.doubleUtil;

public class CartesianCoordinate implements Coordinate {
	private double x, y, z;
	
	public CartesianCoordinate(double x, double y, double z) {
		checkInput(x);
		checkInput(y);
		checkInput(z);
				
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	/**
	 * @methodtype assert
	 * @param in
	 */
	private void checkInput(double in) {
		boolean err = false;
		if(Double.isInfinite(in))
			err = true;
		if(Double.isNaN(in))
			err = true;
		
		if(err)
			throw new IllegalArgumentException("The value is not allowed here!");
	}
	
	/**
	 * @methodtype get
	 * @return
	 */
	public double getX() {
		return x;
	}

	/**
	 * @methodtype get
	 * @return
	 */
	public double getY() {
		return y;
	}

	/**
	 * @methodtype get
	 * @return
	 */
	public double getZ() {
		return z;
	}
	
	/**
	 * Calculates the disance beetween the actual object and another Coordinate-Object.
	 * Uses the formula sqrt((x1-x2)^2 + (y1-y2)^2 + (z1-z2)^2)
	 * @param c
	 * @return
	 */
	private double getDistance(CartesianCoordinate c) {
		return Math.sqrt(Math.pow(c.getX()-x, 2) + Math.pow(c.getY()-y, 2) + Math.pow(c.getZ()-z, 2));
	}
	
	/**
	 * Forwards all .equals(Objects) operations to isEqual(Coordinate).
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		return isEqual((CartesianCoordinate) arg0);
	}


	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}


	@Override
	public double getCartesianDistance(Coordinate coord) {
		return getDistance(coord.asCartesianCoordinate());
	}


	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(x*x + y*y + z*z);
		double theta = Math.acos(z/radius);
		double phi = Math.atan2(y, x);
		return new SphericCoordinate(phi, theta, radius);
	}


	@Override
	public double getCentralAngle(Coordinate coord) {
		CartesianCoordinate c = coord.asCartesianCoordinate();
		double res;
		res = c.getX()*this.x + c.getY()*this.y + c.getZ()*this.z;
		res = res / Math.sqrt(c.getX()*c.getX() + c.getY()*c.getY() + c.getZ()*c.getZ());
		res = res / Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
		return Math.acos(res);
		//return this.asSphericCoordinate().getCentralAngle(coord);
	}


	@Override
	public boolean isEqual(Coordinate coord) {
		CartesianCoordinate c = coord.asCartesianCoordinate();
		if(doubleUtil.doubleEquals(c.getX(), this.x))
			return false;
		if(doubleUtil.doubleEquals(c.getY(), this.y))
			return false;
		if(doubleUtil.doubleEquals(c.getZ(), this.z))
			return false;
		
		return true;
	}
}