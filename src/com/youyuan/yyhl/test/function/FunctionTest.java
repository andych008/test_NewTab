package com.youyuan.yyhl.test.function;


import android.test.AndroidTestCase;
import android.util.Log;

import com.youyuan.yyhl.util.CpuInfo;
import com.youyuan.yyhl.util.LocalFileOperator;

public class FunctionTest extends AndroidTestCase {

	private static final String LOG_TAG = "FunctionTest";

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		
	}
	
	public void testCpuInfo() throws Exception {
		
		String str = CpuInfo.getCpuName();
		
		assertNotNull(str);
		
		Log.i(LOG_TAG, "FunctionTest:CpuInfo: "+str);
		
		int idx = str.indexOf("ARM");
		assertTrue("以ARM开头，就认为是对的", idx==0);

	}
	
	public void testLocalFileOperator_getAppFileDirPath() throws Exception {
		
		String str = LocalFileOperator.getInstance().getAppFileDirPath();

		Log.i(LOG_TAG, "FunctionTest:getAppFileDirPath: "+str);
		
		assertEquals("/data/data/com.youyuan.yyhl/app_extra/", str);

	}
	
//	//writeToStorageFile
//	public void testLocalFileOperator_writeToStorageFile() throws Exception {
//		
//		String str = LocalFileOperator.getInstance().wirteToInStorage("/sdcard/");
//
//		Log.i(LOG_TAG, "FunctionTest:getAppFileDirPath: "+str);
//		
//		assertEquals("/data/data/com.youyuan.yyhl/app_extra/", str);
//
//	}	

	public void testLocalFileOperator_isExternalStorageAvailable() throws Exception {
		
		assertTrue(LocalFileOperator.getInstance().isExternalStorageAvailable());


	}
	
}
