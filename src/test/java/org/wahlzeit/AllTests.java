package org.wahlzeit;
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

import org.wahlzeit.handlers.*;
import org.wahlzeit.model.*;
import org.wahlzeit.model.persistence.*;
import org.wahlzeit.services.*;
import org.wahlzeit.services.mailing.*;
import org.wahlzeit.testEnvironmentProvider.*;
import org.wahlzeit.utils.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)	
@SuiteClasses({ 
	// org.wahlzeit.handlers.*
	TellFriendTest.class,
	
	// org.wahlzeit.model.*;
	AccessRightsTest.class, 
	CartesianCoordinateTest.class, 
	FlagReasonTest.class, 
	GenderTest.class, 
	GuestTest.class,
	LampPhotoTest.class,
	LampPhotoFactoryTest.class,
	LampPhotoManagerTest.class,
	LocationTest.class, 
	PhotoFilterTest.class,
	SphericCoordinateTest.class,
	TagsTest.class, 
	UserStatusTest.class, 
	ValueTest.class,

	// org.wahlzeit.model.persistence.*
	//AbstractAdapterTest.class, // abstract... also keine tests!
	DatastoreAdapterTest.class,
	
	// org.wahlzeit.services.*
	// EmailAddressTest.class, // enthalten in der EmailTestSuite
	LogBuilderTest.class,
	
	// org.wahlzeit.services.mailing.*
	EmailTestSuite.class,
	// EmailServiceTest.class, // enthalten in der EmailTestSuite
	
	
	// org.wahlzeit.testEnvironmentProvider.*
	// LocalDatastoreServiceTestConfigProvider.class,
	// RegisteredOfyEnvironmentProvider.class,
	// SysConfigProvider.class,
	// UserServiceProvider.class,
	// UserSessionProvider.class,
	// WebFormHandlerProvider.class,
	
	// org.wahlzeit.utils.*
	DoubleUtilTest.class,
	AssertUtilTest.class,
	StringUtilTest.class,
	VersionTest.class
})

public class AllTests {

}
