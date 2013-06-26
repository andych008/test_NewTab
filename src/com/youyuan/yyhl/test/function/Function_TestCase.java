package com.youyuan.yyhl.test.function;

import android.util.Log;

import com.youyuan.yyhl.util.CpuInfo;

import junit.framework.TestCase;

public class Function_TestCase extends TestCase {

	public Function_TestCase(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	private static final String LOG_TAG = "FunctionTest";

	public void testFindViews() throws Exception {
		String str = CpuInfo.getCpuName();
		assertNotNull(str);
		Log.i(LOG_TAG, "CpuInfo1: "+str);
		int idx = str.indexOf("ARM");
		assertTrue("��ARM��ͷ������Ϊ�ǶԵ�", idx==0);

	}
	
}
