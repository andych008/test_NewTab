package com.youyuan.yyhl.test.function;


import android.test.AndroidTestCase;
import android.util.Log;

import com.youyuan.yyhl.util.CpuInfo;

public class FunctionTest extends AndroidTestCase {

	private static final String LOG_TAG = "FunctionTest";

	public void testFindViews() throws Exception {
		String str = CpuInfo.getCpuName();
		assertNotNull(str);
		Log.i(LOG_TAG, "CpuInfo: "+str);
		int idx = str.indexOf("ARM");
		assertTrue("��ARM��ͷ������Ϊ�ǶԵ�", idx==0);

	}
}
