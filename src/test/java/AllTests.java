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
	CoordinateTest.class, 
	FlagReasonTest.class, 
	GenderTest.class, 
	GuestTest.class,
	LocationTest.class, 
	PhotoFilterTest.class, 
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
	StringUtilTest.class,
	VersionTest.class
})

public class AllTests {

}
