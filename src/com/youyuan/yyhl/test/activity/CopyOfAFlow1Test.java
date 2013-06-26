package com.youyuan.yyhl.test.activity;

import org.athrun.android.framework.AthrunTestCase;
import org.athrun.android.framework.Test;
import org.athrun.android.framework.viewelement.ViewElement;
import org.athrun.android.framework.webview.By;
import org.athrun.android.framework.webview.WebElement;
import org.athrun.android.framework.webview.WebViewElement;


import android.util.Log;

public class CopyOfAFlow1Test extends AthrunTestCase {

	private static final int TIMEOUT_PAGE_NET = 15000;
	private static final int TIMEOUT_API = 10000;
	private static final String LOG_TAG = "CopyOfAFlow1Test";
	
	public CopyOfAFlow1Test() throws Exception {
		super("com.youyuan.yyhl", "com.youyuan.yyhl.activity.LoginActivity");
		AthrunTestCase.setMaxTimeToFindView(TIMEOUT_PAGE_NET);
	}

	@Test
	public void testLogin_UserInfo_SayHello_NextPerson() throws Exception {
		String curActivityName = null;

		//-----------1. 登录------------------
		findElementById("LoginBtn").doClick();
		assertEquals(true, waitForText("登录成功", TIMEOUT_API));

		//-----------2. 当前处于缘份tab------------------
		assertEquals(true, getDevice().waitForActivity("MainActivity"));//如果写YuanFenActivity，这一句就不会通过
		
		curActivityName = getCurrentActivityName();
		Log.i(LOG_TAG, "当前act: "+curActivityName);
		assertEquals(true, curActivityName.equals("com.youyuan.yyhl.activity.YuanFenActivity"));
		
		
		//-----------3. 点击一个头像------------------
		WebViewElement webview = findWebElementById("webkit", WebViewElement.class);
		
		Thread.sleep(5000);//等待网络加载-瀑布流
//		webview.waitForWebElement(By.id("user_head"));//默认20s

		//click web element
		WebElement webEle =  webview.getWebElement(By.className("user_head"),0);
        webview.clickOnWebElement(webEle);        
		
        
        //-----------4. test------------------
        
        Thread.sleep(10000);//等待网络加载-对方空间
        webview.waitForWebElement(By.id("nick_name"));//默认20s
       
//		webEle =  webview.getWebElement(By.id("nick_name"), 0);
        webEle =  webview.getWebElement(By.xpath("/html/body/div[@class=\"title_line\"]"), 4);
		String str0 = webEle.getText();
		Log.i(LOG_TAG, "当前str0: "+str0);
        

        
	}
}
