
package com.StepDefinitions;

import com.Utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public static void setUp() {
		HelperClass.setUpDriver();
	}
	
	@After
	public static void tearDown(Scenario scenario) {
		HelperClass.TearDown();
	}

}
