package org.wahlzeit.model;

public class LampPhoto extends Photo {
	
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
