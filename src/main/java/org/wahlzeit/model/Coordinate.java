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

public interface Coordinate {
	
	/**
	 * Converts this Coordinate into CartesianCoordinate
	 * @return
	 */
	public CartesianCoordinate asCartesianCoordinate() throws IllegalStateException;
	
	/**
	 * Computes cartesian Distance between this object and coord
	 * @param coord
	 * @return
	 */
	public double getCartesianDistance(Coordinate coord) throws IllegalStateException, IllegalArgumentException;
	
	/**
	 * Converts this Coordinate into SphericCoordinate
	 * @return
	 */
	public SphericCoordinate asSphericCoordinate() throws IllegalStateException;
	
	/**
	 * Computes the central angel between this object and coord.
	 * @param coord
	 * @return
	 */
	public double getCentralAngle(Coordinate coord) throws IllegalStateException, IllegalArgumentException;
	
	/**
	 * Determines if the acrtual object and coord describe the same place.
	 * @param coord
	 * @return
	 */
	public boolean isEqual(Coordinate coord) throws IllegalArgumentException;
	
	public boolean equals(Object arg0) throws IllegalArgumentException;
}