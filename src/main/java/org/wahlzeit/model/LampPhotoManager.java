package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

import com.google.appengine.api.images.Image;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;

public class LampPhotoManager extends PhotoManager {

	private static final Logger log = Logger.getLogger(LampPhotoManager.class.getName());
	


	/**
	 * @methodtype command
	 *
	 * Load all persisted photos. Executed when Wahlzeit is restarted.
	 */
	public void loadPhotos() {
		Collection<LampPhoto> existingPhotos = ObjectifyService.run(new Work<Collection<LampPhoto>>() {
			@Override
			public Collection<LampPhoto> run() {
				Collection<LampPhoto> existingPhotos = new ArrayList<LampPhoto>();
				readObjects(existingPhotos, LampPhoto.class);
				return existingPhotos;
			}
		});

		for (LampPhoto photo : existingPhotos) {
			if (!doHasPhoto(photo.getId())) {
				log.config(LogBuilder.createSystemMessage().
						addParameter("Load LampPhoto with ID", photo.getIdAsString()).toString());
				loadScaledImages(photo);
				doAddPhoto(photo);
			} else {
				log.config(LogBuilder.createSystemMessage().
						addParameter("Already loaded LampPhoto", photo.getIdAsString()).toString());
			}
		}

		log.info(LogBuilder.createSystemMessage().addMessage("All lamp-photos loaded.").toString());
	}
}
