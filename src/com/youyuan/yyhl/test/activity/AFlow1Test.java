package com.youyuan.yyhl.test.activity;

import org.athrun.android.framework.AthrunTestCase;
import org.athrun.android.framework.Test;
import org.athrun.android.framework.viewelement.ViewElement;
import org.athrun.android.framework.webview.By;
import org.athrun.android.framework.webview.WebElement;
import org.athrun.android.framework.webview.WebViewElement;


import android.util.Log;

public class AFlow1Test extends AthrunTestCase {

	private static final int TIMEOUT_PAGE_NET = 15000;
	private static final int TIMEOUT_API = 10000;
	private static final String LOG_TAG = "AFlow1Test";
	
	public AFlow1Test() throws Exception {
		super("com.youyuan.yyhl", "com.youyuan.yyhl.activity.LoginActivity");
		AthrunTestCase.setMaxTimeToFindView(TIMEOUT_PAGE_NET);
	}

	@Test
	public void testLogin_UserInfo_SayHello_NextPerson() throws Exception {
		String curActivityName = null;

		//-----------1. ��¼------------------
		findElementById("LoginBtn").doClick();
		assertEquals(true, waitForText("��¼�ɹ�", TIMEOUT_API));

		//-----------2. ��ǰ����Ե��tab------------------
		assertEquals(true, getDevice().waitForActivity("MainActivity"));//���дYuanFenActivity����һ��Ͳ���ͨ��
		
		curActivityName = getCurrentActivityName();
		Log.i(LOG_TAG, "��ǰact: "+curActivityName);
		assertEquals(true, curActivityName.equals("com.youyuan.yyhl.activity.YuanFenActivity"));
		
		
		//-----------3. ���һ��ͷ��------------------
		WebViewElement webview = findWebElementById("webkit", WebViewElement.class);
		
		Thread.sleep(5000);//�ȴ��������-�ٲ���
//		webview.waitForWebElement(By.id("user_head"));//Ĭ��20s

		//click web element
		WebElement webEle =  webview.getWebElement(By.className("user_head"),0);
        webview.clickOnWebElement(webEle);        
		
        
        //-----------4. ����к�------------------
        
        Thread.sleep(10000);//�ȴ��������-�Է��ռ�
        webview.waitForWebElement(By.id("nick_name"));//Ĭ��20s
        
        findElementById("sayHelloBtn").doClick();

//		nextPeopelBtn  sayHelloBtn   toast_layout_root
        boolean r = waitForText("���к��ɹ���", TIMEOUT_API);
        if(!r)
        	r = waitForText("���к�ʧ�ܣ�", TIMEOUT_API);
        if(!r)
        	r = waitForText("���Ѿ�����к��ˣ�", TIMEOUT_API);        
        assertEquals(true, r);
        
        Thread.sleep(5000);//�ȴ��������
        
        //-----------5. ��һλ(�޷���֤)------------------
		webEle =  webview.getWebElement(By.id("nick_name"), 0);
		String str0 = webEle.getText();
		Log.i(LOG_TAG, "��ǰstr0: "+str0);
		ViewElement next = findElementById("nextPeopelBtn");
		next.doClick();
        assertFalse(next.isEnabled());
        Thread.sleep(5000);//�ȴ��������-��һλ
        assertTrue(next.isEnabled());
//        webview = findWebElementById("webkit", WebViewElement.class);//���¼���html
//        webEle =  webview.getWebElement(By.id("nick_name"), 0);
//
//        String str1 = webEle.getText();
//        Log.i(LOG_TAG, "��ǰstr1: "+str1);
//        assertTrue(webEle.getText(), !webEle.getText().equals(str0));
        
        
	}
}
