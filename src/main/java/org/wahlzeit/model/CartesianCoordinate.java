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

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.AssertUtil;
import org.wahlzeit.utils.DoubleUtil;

public class CartesianCoordinate extends AbstractCoordinate {
	private double x, y, z;
	
	private static final Logger log = Logger.getLogger(CartesianCoordinate.class.getName());
	
	/**
	 * Creates new Object of type {@link CartesianCoordinate}
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param z Z-Coordinate
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException {
		DoubleUtil.checkDouble(x);
		DoubleUtil.checkDouble(y);
		DoubleUtil.checkDouble(z);
				
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	protected void assertClassInvariants() throws IllegalStateException {
		try {
			DoubleUtil.checkDouble(x);
			DoubleUtil.checkDouble(y);
			DoubleUtil.checkDouble(z);
		} catch (IllegalArgumentException e) {
			IllegalStateException x = new IllegalStateException(e.getMessage());
			x.setStackTrace(e.getStackTrace());
			log.config(LogBuilder.createSystemMessage().addException(x.getMessage(), x).toString());
			throw x;
		}
	}
	
	/**
	 * @methodtype get
	 * @return
	 */
	public double getX() throws IllegalStateException{
		assertClassInvariants();
		
		return x;
	}

	/**
	 * @methodtype get
	 * @return
	 */
	public double getY() throws IllegalStateException {
		assertClassInvariants();
		
		return y;
	}

	/**
	 * @methodtype get
	 * @return
	 */
	public double getZ() throws IllegalStateException {
		assertClassInvariants();
		
		return z;
	}
	
	/**
	 * Calculates the disance beetween the actual object and another Coordinate-Object.
	 * Uses the formula sqrt((x1-x2)^2 + (y1-y2)^2 + (z1-z2)^2)
	 * @param c
	 * @return
	 */
	private double getDistance(CartesianCoordinate c) throws IllegalStateException {
		assertClassInvariants();
		
		return Math.sqrt(Math.pow(c.getX()-x, 2) + Math.pow(c.getY()-y, 2) + Math.pow(c.getZ()-z, 2));
	}
	
	/**
	 * Forwards all .equals(Objects) operations to isEqual(Coordinate).
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) throws IllegalStateException {
		assertClassInvariants();
		
		return isEqual((CartesianCoordinate) arg0);
	}


	@Override
	public CartesianCoordinate asCartesianCoordinate() throws IllegalStateException {
		assertClassInvariants();
		
		return this;
	}


	@Override
	public double getCartesianDistance(Coordinate coord) throws IllegalStateException, IllegalArgumentException{
		AssertUtil.assertNotNull(coord);
		assertClassInvariants();
		
		return getDistance(coord.asCartesianCoordinate());
	}


	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalStateException {
		assertClassInvariants();
		
		double radius = Math.sqrt(x*x + y*y + z*z);
		double theta = Math.acos(z/radius);
		double phi = Math.atan2(y, x);
		return new SphericCoordinate(phi, theta, radius);
	}


	@Override
	public double getCentralAngle(Coordinate coord) throws IllegalStateException, IllegalArgumentException {
		AssertUtil.assertNotNull(coord);
		assertClassInvariants();
		
		CartesianCoordinate c = coord.asCartesianCoordinate();
		double res;
		res = c.getX()*this.x + c.getY()*this.y + c.getZ()*this.z;
		res = res / Math.sqrt(c.getX()*c.getX() + c.getY()*c.getY() + c.getZ()*c.getZ());
		res = res / Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
		return Math.acos(res);
	}


	@Override
	public boolean isEqual(Coordinate coord) throws IllegalStateException, IllegalArgumentException {
		AssertUtil.assertNotNull(coord);
		
		assertClassInvariants();
		
		CartesianCoordinate c = coord.asCartesianCoordinate();
		if(DoubleUtil.doubleEquals(c.getX(), this.x))
			return false;
		if(DoubleUtil.doubleEquals(c.getY(), this.y))
			return false;
		if(DoubleUtil.doubleEquals(c.getZ(), this.z))
			return false;
		
		return true;
	}
}