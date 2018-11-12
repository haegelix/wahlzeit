package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

public class LampPhotoFactory extends PhotoFactory {

	private static final Logger log = Logger.getLogger(LampPhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static PhotoFactory instance = null;


	/**
	 * Public singleton access method.
	 */
	public static synchronized PhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting LampPhotoFactory").toString());
			setInstance(new LampPhotoFactory());
		}

		return instance;
	}

	/**
	 * @methodtype factory
	 */
	public Photo createPhoto() {
		return new LampPhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 */
	public Photo createPhoto(PhotoId id) {
		return new LampPhoto(id);
	}
}
