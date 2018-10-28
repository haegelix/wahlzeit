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

public class Location {
	public Coordinate coordinate;

	public Location(Coordinate coordinate) {
		if(coordinate == null)
			throw new IllegalArgumentException("Coordinate is not defined! Cannot init Location!");
		else
			this.coordinate = coordinate;
	}
	
	/*
	 * Forwards all .equals(Objects) operations to isEqual(Coordinate).
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		if(coordinate == null)
			throw new IllegalStateException("Coordinate is not defined! Cannot compare!");
		if(arg0 == null)
			throw new IllegalArgumentException("Coordinate is not defined! Cannot init Location!");
		return coordinate.isEqual(((Location)arg0).coordinate);
	}
}
