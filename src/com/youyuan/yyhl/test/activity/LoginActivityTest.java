package com.youyuan.yyhl.test.activity;

import org.athrun.android.framework.AthrunDevice;
import org.athrun.android.framework.AthrunTestCase;
import org.athrun.android.framework.Test;
import org.athrun.android.framework.ViewOperation;
import org.athrun.android.framework.viewelement.AbsListViewElement;
import org.athrun.android.framework.viewelement.CheckableElement;
import org.athrun.android.framework.viewelement.SlideableElement;
import org.athrun.android.framework.viewelement.TextViewElement;
import org.athrun.android.framework.viewelement.ViewElement;
import org.athrun.android.framework.viewelement.ViewGroupElement;

import android.util.Log;





public class LoginActivityTest extends AthrunTestCase {

	private static final String LOG_TAG = "LoginActivityTest";
	
	public LoginActivityTest() throws Exception {
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
	public void testLogin() throws Exception {
		TextViewElement editUser = findElementById("UserName",
				TextViewElement.class);
		
		TextViewElement editPw = findElementById("Password",
				TextViewElement.class);
		
		editUser.clearText();
		editPw.clearText();
		doLogin(editUser, editPw);
//		getDevice().goBackToActivity("LoginActivity");

	}
	
	@Test
	public void testSwitch() throws Exception {
		findElementById("RegisBtn").doClick();
		assertEquals(true, getDevice().waitForActivity("RegisterActivity"));

		//�ص�֮ǰ��ָ��ҳ��
		//getDevice().goBackToActivity("LoginActivity");
		
		findElementById("EnterLoginBtn").doClick();
		assertEquals(true, getDevice().waitForActivity("LoginActivity"));

	}
	
	@Test
	public void testRememberPasswd() throws Exception {
		
		CheckableElement checkBox = findElementById("SavePassword", CheckableElement.class);

		boolean b = checkBox.isChecked();
		
		if(b) {
			
			TextViewElement editUser = findElementById("UserName",
					TextViewElement.class);
			
			TextViewElement editPw = findElementById("Password",
					TextViewElement.class);
			
			Log.i(LOG_TAG, "��ǰisChecked: "+editUser.getText());
			
			boolean empty = editUser.getText().contentEquals("");
			if(!empty) {
				empty = editPw.getText().contentEquals("");
			}
			
			if(!empty) {
				checkBox.doClick();
				assertFalse(checkBox.isChecked());
				
				findElementById("LoginBtn").doClick();
				assertEquals(true, waitForText("��¼�ɹ�", 10000));
				Thread.sleep(5000);//����ӣ���Ȼ�˳��������һ��testCase�������⣬��֪��Ϊʲô
			} else {
				findElementById("LoginBtn").doClick();
				assertEquals(true, waitForText("�û��������벻��Ϊ�գ�", 10000));
				//101639608   409144
				
				doLogin(editUser, editPw);

			}

		
		} 

		

	}

	@Test
	public void testForget() throws Exception {
		findElementById("FindPasswordTxt").doClick();
		
		waitForText("���Ͷ���", 10000);

	}

}
