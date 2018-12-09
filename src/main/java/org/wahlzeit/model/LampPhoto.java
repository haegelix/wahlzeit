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

	/**
	 * My fields
	 */
	protected String power;
	protected String powerconsumption;
	protected String lamptype;
	
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
