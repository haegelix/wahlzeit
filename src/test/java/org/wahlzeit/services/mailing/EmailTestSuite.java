package org.wahlzeit.services.mailing;

import org.wahlzeit.services.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	EmailServiceTest.class, 
	EmailAddressTest.class 
})
public class EmailTestSuite {

}
