package com.youyuan.yyhl.test.activity;

import org.athrun.android.framework.AthrunTestCase;
import org.athrun.android.framework.Test;

public class RegisterActivityTest extends AthrunTestCase {

	public RegisterActivityTest() throws Exception {
		super("com.youyuan.yyhl", "com.youyuan.yyhl.activity.RegisterActivity");
		AthrunTestCase.setMaxTimeToFindView(10000);
	}

	@Test
	public void testFindViews() throws Exception {
		findElementById("WomanBtn").doClick();
		assertEquals(true, waitForText("×¢²á³É¹¦", 10000));

	}
}
