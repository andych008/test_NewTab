package com.youyuan.yyhl.test.function;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllFunctionTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllFunctionTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(Function_TestCase.class);
		suite.addTestSuite(FunctionTest.class);
		//$JUnit-END$
		return suite;
	}

}
