package com.youyuan.yyhl.test.activity;

import org.athrun.android.framework.AthrunTestCase;
import org.athrun.android.framework.Test;
import org.athrun.android.framework.viewelement.TextViewElement;
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

	private void doLogin(TextViewElement editUser, TextViewElement editPw) throws Exception {
		
		editUser.inputText("101639608");
		editPw.inputText("409144");
		
		findElementById("LoginBtn").doClick();
		assertEquals(true, waitForText("��¼�ɹ�", 10000));
		Thread.sleep(5000);//����ӣ���Ȼ�˳��������һ��testCase�������⣬��֪��Ϊʲô

	}
	
	@Test
	public void testGetCurrentActivityName() throws Exception {
		String curActivityName = null;
		
		//-----------1. ��¼------------------
		TextViewElement editUser = findElementById("UserName",
				TextViewElement.class);
		
		TextViewElement editPw = findElementById("Password",
				TextViewElement.class);
		
		editUser.clearText();
		editPw.clearText();
		doLogin(editUser, editPw);


        
//        //-----------2. ��ǰ����Ե��tab------------------
//		assertEquals(true, getDevice().waitForActivity("MainActivity"));//���дYuanFenActivity����һ��Ͳ���ͨ��
//		
//		curActivityName = getCurrentActivityName();
//		Log.i(LOG_TAG, "��ǰact: "+curActivityName);
//		assertEquals(true, curActivityName.equals("com.youyuan.yyhl.activity.YuanFenActivity"));
//		
//		
		//-----------3. ��ǰ��������tab------------------
		findElementByText("����").doClick();
//		curActivityName = getCurrentActivityName();
//		Log.i(LOG_TAG, "��ǰact: "+curActivityName);
//		assertEquals(true, curActivityName.equals("com.youyuan.yyhl.activity.SpaceActivity"));
//		
		//-----------4. ���"�л��û�"------------------
		Thread.sleep(10000);//�ȴ��������
		WebViewElement webview = findWebElementById("webkit", WebViewElement.class);
		Log.i(LOG_TAG, "��ǰtest0: "+webview.getWebUrl());		

		//webview.waitForWebElement(By.className("btn_red logout"));//Ĭ��20s
		assertTrue(webview.waitForWebElement(By.cssSelector("DIV.btn_gray.logout")));//Ĭ��20s

		//click web element
//		WebElement webEle =  webview.getWebElement(By.textContent("�л��û�"),0);
//		WebElement webEle =  webview.getWebElement(By.xpath("/html/body/div[@id=\"container\"]/div[@class=\"btn_red logout\"]"),0);
//		WebElement webEle =  webview.getWebElement(By.cssSelector("DIV.btn_gray.logout"),0);
//		Log.i(LOG_TAG, "��ǰtest1: "+webEle.getText());		
//        webview.clickOnWebElement(webEle);    		
//		
//        //-----------5. �ص���¼ҳ------------------
//        assertEquals(true, getDevice().waitForActivity("LoginActivity"));
		
	}
}
