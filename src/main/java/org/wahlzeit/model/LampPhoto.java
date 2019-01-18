/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
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

public class LampPhoto extends Photo {
	
	private static final Logger log = Logger.getLogger(LampPhoto.class.getName());
	
	/**
	 * 
	 */
	public static final String POWER = "power";
	public static final String POWERCONSUMPTION = "powerconsumption";
	public static final String LAMPTYPE = "lamptype";
	
	public static final String LAMP = "lamp";

	/**
	 * My fields
	 */
	protected String power;
	protected String powerconsumption;
	protected String lamptype;
	protected Lamp lamp;
	
	public LampPhoto(String power, String poweconsumption, String lamptype) {
		this.power = power;
		this.powerconsumption = poweconsumption;
		this.lamptype = lamptype;
	}
	
	protected static void checkPower(String power) {
		if(power == null) 
			throw new IllegalStateException("power shall not be null");
		
	}
	
	protected static void checkPowerconsumption(String powerconsumption) {
		if(powerconsumption == null) 
			throw new IllegalArgumentException("powerconsumption shall not be null");
		if(!powerconsumption.endsWith("W"))
			throw new IllegalArgumentException("powerconsumption shall be in unit WATT");
	}
	
	protected static void checkLamptype(String lamptype) {
		if(lamptype == null) 
			throw new IllegalArgumentException("lamptype shall not be null");
	}

	protected void checkClassInvariants() throws IllegalStateException {
		try {
			checkPower(this.power);
			checkPowerconsumption(this.powerconsumption);
			checkLamptype(this.lamptype);
		} catch (IllegalArgumentException e) {
			IllegalStateException x = new IllegalStateException(e.getMessage());
			x.setStackTrace(e.getStackTrace());
			log.config(LogBuilder.createSystemMessage().addException(x.getMessage(), x).toString());
			throw x;
		}
	}
	
	/**
	 * @methodtype init
	 */
	public LampPhoto(PhotoId id) {
		super(id);
	}

	
	/**
	 * @methodtype init
	 */
	public LampPhoto() {
		super();
	}
	
	
	/**
	 * @methodtype get
	 */
	public String getPower() {
		return power;
	}

	/**
	 * @methodtype set
	 */
	public void setPower(String power) {
		checkClassInvariants();
		
		this.power = power;
		incWriteCount();
	}

	/**
	 * @methodtype get
	 */
	public String getPowerconsumption() {
		return powerconsumption;
	}
	
	/**
	 * @methodtype set
	 */
	public void setPowerconsumption(String powerconsumption) {
		this.powerconsumption = powerconsumption;
		incWriteCount();
	}

	/**
	 * @methodtype get
	 */
	public String getLamptype() {
		return lamptype;
	}

	/**
	 * @methodtype set
	 */
	public void setLamptype(String lamptype) {
		this.lamptype = lamptype;
		incWriteCount();
	}

	
}
