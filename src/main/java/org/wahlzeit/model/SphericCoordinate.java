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

import org.wahlzeit.utils.DoubleUtil;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.AssertUtil;

/**
 * Describes {@link AbstractCoordinate} as {@link SphericCoordinate}.
 */
public class SphericCoordinate extends AbstractCoordinate {
	private double phi, theta, radius;
	
	private static final Logger log = Logger.getLogger(SphericCoordinate.class.getName());
	
	/**
	 * Creates new Object of type {@link SphericCoordinate}.
	 * @param phi Longitude
	 * @param theta Latitude
	 * @param radius Radius
	 * @methodtype constructor
	 */
	public SphericCoordinate(double phi, double theta, double radius) throws IllegalArgumentException {
		assertAngleHasValidValue(phi, 2*Math.PI);
		assertAngleHasValidValue(theta, Math.PI);
		assertRadiusHasValidValue(radius);
		
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
	}
	
	/**
	 * Checks if val holds a valid value for the variable angle.
	 * @param val Value to be asserted as possible.
	 * @param max Holds the maximum value the variable val may contain.
	 * @throws IllegalArgumentException Will be thrown if assertation fails.
	 * @methodtype assert
	 */
	protected static void assertAngleHasValidValue(double val, double max) throws IllegalArgumentException {
		if(DoubleUtil.checkDoubleIsNaN(val))
			throw new IllegalArgumentException("Angle must not be NaN");
		if(DoubleUtil.checkDoubleIsNegOrPosInfinity(val))
			throw new IllegalArgumentException("Angle must not be infinite");
		if(val >= max)
			throw new IllegalArgumentException("Angle ("+ val +") must not exceed " +max);
		if(val < 0)
			throw new IllegalArgumentException("Angle ("+ val +") must not be less than 0");
	}
	
	/**
	 * Checks if val holds a valid value for the variable radius.
	 * @param val Value to be asserted as possible.
	 * @throws IllegalArgumentException Will be thrown if assertation fails.
	 * @methodtype assert
	 */
	protected static void assertRadiusHasValidValue(double val) throws IllegalArgumentException {
		if(DoubleUtil.checkDoubleIsNaN(val))
			throw new IllegalArgumentException("Radius must not be NaN ");
		if(DoubleUtil.checkDoubleIsNegOrPosInfinity(val))
			throw new IllegalArgumentException("Radius must not be infinite");
		if(val < 0)
			throw new IllegalArgumentException("Radius ("+ val +") must not be less than 0");
	}
	
	/**
	 * If state is not as specified one of the assert-methods will throw an {@link IllegalStateException}
	 * that will be transformed into a IllegalStateException.
	 * @throws IllegalStateException
	 * @methodtype assert
	 */
	protected void assertClassInvariants() throws IllegalStateException {
		try {
			assertAngleHasValidValue(phi, 2*Math.PI);
			assertAngleHasValidValue(theta, Math.PI);
			assertRadiusHasValidValue(radius);
		} catch (Exception e) {
			IllegalStateException x = new IllegalStateException(e.getMessage());
			x.setStackTrace(e.getStackTrace());
			log.config(LogBuilder.createSystemMessage().addException(x.getMessage(), x).toString());
			throw x;
		}
	}

	/**
	 * Returns the value of the variable phi.
	 * @methodtype get
	 * @return
	 */
	public double getPhi() throws IllegalStateException {
		assertClassInvariants();
		
		return phi;
	}

	/**
	 * Returns the value of the variable theta.
	 * @methodtype get
	 * @return
	 */
	public double getTheta() throws IllegalStateException {
		assertClassInvariants();
		
		return theta;
	}

	/**
	 * Returns the value of the variable radius.
	 * @methodtype get
	 * @return
	 */
	public double getRadius() throws IllegalStateException {
		assertClassInvariants();
		
		return radius;
	}

	/**
	 * See description in superclass.
	 * @methodtype get
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() throws IllegalStateException {
		assertClassInvariants();
		
		double x = radius * Math.sin(this.theta)*Math.cos(this.phi);
		double y = radius * Math.sin(this.theta)*Math.sin(this.phi);
		double z = radius * Math.cos(this.theta);
		return new CartesianCoordinate(x, y, z);
	}

	/**
	 * See description in superclass.
	 * @methodtype get
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalStateException {
		assertClassInvariants();
		
		return this;
	}

	/**
	 * See description in superclass.
	 * @methodtype get
	 */
	@Override
	public double getCentralAngle(Coordinate coord) throws IllegalStateException, IllegalArgumentException{
		// Preconditions:
		AssertUtil.assertNotNull(coord);
		
		// Class invariants:
		assertClassInvariants();
		
		SphericCoordinate c = coord.asSphericCoordinate();
		// Koordinatenumrechnung
		double phiNeu1 = this.getTheta() - 90;
		double phiNeu2 = c.getTheta() - 90;
		double lambda1 = this.getPhi();
		double lambda2 = c.getPhi();
		return Math.acos(Math.sin(phiNeu1)*Math.sin(phiNeu2)+Math.cos(phiNeu1)*Math.cos(phiNeu2)*Math.cos(lambda1-lambda2));
	}

	/**
	 * See description in superclass.
	 * @methodtype assert
	 */
	@Override
	public boolean isEqual(Coordinate coord) throws IllegalStateException, IllegalArgumentException {
		// Preconditions:
		AssertUtil.assertNotNull(coord);
		
		// Class invariants:
		assertClassInvariants();
		
		SphericCoordinate c = coord.asSphericCoordinate();
		
		/*
		 *  If radius is 0 in this object and in coord, then they are equal, even if the angles theta and phi differ.
		 */
		if(DoubleUtil.doubleEquals(c.getRadius(), 0) && DoubleUtil.doubleEquals(this.radius, 0))
			return true;
		
		if(!DoubleUtil.doubleEquals(c.getPhi(), this.phi))
			return false;
		if(!DoubleUtil.doubleEquals(c.getTheta(), this.theta))
			return false;
		if(!DoubleUtil.doubleEquals(c.getRadius(), this.radius))
			return false;
		return true;
		
		// Postconditions: none
	}

	
	/**
	 * Forwards all .equals(Objects) operations to isEqual(Coordinate).
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) throws IllegalArgumentException {
		return isEqual((Coordinate) arg0);
	}
}
