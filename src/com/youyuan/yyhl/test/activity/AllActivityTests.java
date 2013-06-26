package com.youyuan.yyhl.test.activity;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllActivityTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllActivityTests.class.getName());
		//$JUnit-BEGIN$
//		suite.addTestSuite(RegisterActivityTest.class);
		suite.addTestSuite(LoginActivityTest.class);
		suite.addTestSuite(MainActivityTest.class);

		//$JUnit-END$
		return suite;
	}

}
