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

public class SphericCoordinate implements Coordinate{
	private double phi, theta, radius;
	
	public SphericCoordinate(double phi, double theta, double radius) {
		checkAngle(phi, 2*Math.PI);
		checkAngle(theta, Math.PI);
		checkRadius(radius);
		
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
	}
	
	public void checkAngle(double val, double max) {
		if(val == Double.NaN)
			throw new IllegalArgumentException("Given angle ("+ val +") must not ne NaN ");
		if(val > max)
			throw new IllegalArgumentException("Given angle ("+ val +") must not exceed " +max);
		if(val < 0)
			throw new IllegalArgumentException("Given angle ("+ val +") must not be less than " +max);
	}
	
	public void checkRadius(double val) {
		if(val == Double.NaN)
			throw new IllegalArgumentException("Given radius ("+ val +") must not ne NaN ");
		if(val < 0)
			throw new IllegalArgumentException("Given radius ("+ val +") must not be less than 0");
	}

	/**
	 * @methodtype get
	 * @return
	 */
	public double getPhi() {
		return phi;
	}

	/**
	 * @methodtype get
	 * @return
	 */
	public double getTheta() {
		return theta;
	}

	/**
	 * @methodtype get
	 * @return
	 */
	public double getRadius() {
		return radius;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double x = radius * Math.sin(this.theta)*Math.cos(this.phi);
		double y = radius * Math.sin(this.theta)*Math.sin(this.phi);
		double z = radius * Math.cos(this.theta);
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public double getCartesianDistance(Coordinate coord) {
		return this.asCartesianCoordinate().getCartesianDistance(coord);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getCentralAngle(Coordinate coord) {
		SphericCoordinate c = coord.asSphericCoordinate();
		// Koordinatenumrechnung
		double phiNeu1 = this.getTheta() - 90;
		double phiNeu2 = c.getTheta() - 90;
		double lambda1 = this.getPhi();
		double lambda2 = c.getPhi();
		return Math.acos(Math.sin(phiNeu1)*Math.sin(phiNeu2)+Math.cos(phiNeu1)*Math.cos(phiNeu2)*Math.cos(lambda1-lambda2));
	}

	@Override
	public boolean isEqual(Coordinate coord) {
		SphericCoordinate c = coord.asSphericCoordinate();
		
		/*
		 *  If radius is 0 in this object and in coord, then they are equal, even if the angles theta and phi differ.
		 */
		if(doubleUtil.doubleEquals(c.getRadius(), 0) && doubleUtil.doubleEquals(this.radius, 0))
			return true;
		
		if(!doubleUtil.doubleEquals(c.getPhi(), this.phi))
			return false;
		if(!doubleUtil.doubleEquals(c.getTheta(), this.theta))
			return false;
		if(!doubleUtil.doubleEquals(c.getRadius(), this.radius))
			return false;
		return true;
	}

	
	/**
	 * Forwards all .equals(Objects) operations to isEqual(Coordinate).
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		return isEqual((Coordinate) arg0);
	}
}
