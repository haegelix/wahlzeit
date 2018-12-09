package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LampPhotoTest {
	LampPhoto p;

	@Before
	public void init() {
		p = new LampPhoto("20W", "10W", "Halogen");
	}


	@Test
	public void testId() throws Exception {
		LampPhoto p = new LampPhoto();
		LampPhoto l = new LampPhoto();
		LampPhoto f = new LampPhoto(new PhotoId(12345));

		assertNotEquals(p.getId(),l.getId());
		assertTrue(f.getId().isEqual(new PhotoId(12345)));
	}

	@Test
	public void testSettersAndGetters() throws Exception {
		p.setPower("30W");
		p.setPowerconsumption("40W");
		p.setLamptype("LED");
		
		assertEquals(p.getPower(), "30W");
		assertEquals(p.getPowerconsumption(), "40W");
		assertEquals(p.getLamptype(), "LED");
	}
}
