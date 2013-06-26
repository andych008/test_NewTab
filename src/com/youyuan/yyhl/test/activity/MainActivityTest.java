package com.youyuan.yyhl.test.activity;

import org.athrun.android.framework.AthrunTestCase;
import org.athrun.android.framework.Test;
import org.athrun.android.framework.webview.By;
import org.athrun.android.framework.webview.WebElement;
import org.athrun.android.framework.webview.WebViewElement;

import android.util.Log;

public class MainActivityTest extends AthrunTestCase {
	
	private static final String LOG_TAG = "MainActivityTest";
	
	public MainActivityTest() throws Exception {
		super("com.youyuan.yyhl", "com.youyuan.yyhl.activity.LoginActivity");
		AthrunTestCase.setMaxTimeToFindView(10000);
	}

	@Test
	public void testGetCurrentActivityName() throws Exception {
		String curActivityName = null;
		
		//-----------1. 登录------------------
		findElementById("LoginBtn").doClick();
		assertEquals(true, waitForText("登录成功", 10000));

        
//        //-----------2. 当前处于缘份tab------------------
//		assertEquals(true, getDevice().waitForActivity("MainActivity"));//如果写YuanFenActivity，这一句就不会通过
//		
//		curActivityName = getCurrentActivityName();
//		Log.i(LOG_TAG, "当前act: "+curActivityName);
//		assertEquals(true, curActivityName.equals("com.youyuan.yyhl.activity.YuanFenActivity"));
//		
//		
		//-----------3. 当前处于资料tab------------------
		findElementByText("资料").doClick();
//		curActivityName = getCurrentActivityName();
//		Log.i(LOG_TAG, "当前act: "+curActivityName);
//		assertEquals(true, curActivityName.equals("com.youyuan.yyhl.activity.SpaceActivity"));
//		
		//-----------4. 点击"切换用户"------------------
		Thread.sleep(10000);//等待网络加载
		WebViewElement webview = findWebElementById("webkit", WebViewElement.class);
		Log.i(LOG_TAG, "当前test0: "+webview.getWebUrl());		

		//webview.waitForWebElement(By.className("btn_red logout"));//默认20s
		assertTrue(webview.waitForWebElement(By.cssSelector("DIV.btn_gray.logout")));//默认20s

		//click web element
//		WebElement webEle =  webview.getWebElement(By.textContent("切换用户"),0);
//		WebElement webEle =  webview.getWebElement(By.xpath("/html/body/div[@id=\"container\"]/div[@class=\"btn_red logout\"]"),0);
//		WebElement webEle =  webview.getWebElement(By.cssSelector("DIV.btn_gray.logout"),0);
//		Log.i(LOG_TAG, "当前test1: "+webEle.getText());		
//        webview.clickOnWebElement(webEle);    		
//		
//        //-----------5. 回到登录页------------------
//        assertEquals(true, getDevice().waitForActivity("LoginActivity"));
		
	}
}
