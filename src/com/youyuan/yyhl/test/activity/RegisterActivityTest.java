package com.youyuan.yyhl.test.activity;

import org.athrun.android.framework.AthrunTestCase;
import org.athrun.android.framework.Test;
import org.athrun.android.framework.ViewOperation;
import org.athrun.android.framework.utils.SleepUtils;
import org.athrun.android.framework.viewelement.AbsListViewElement;
import org.athrun.android.framework.viewelement.CheckableElement;
import org.athrun.android.framework.viewelement.TextViewElement;
import org.athrun.android.framework.viewelement.ViewElement;
import org.athrun.android.framework.viewelement.ViewGroupElement;

import android.util.Log;
import android.widget.ListView;

public class RegisterActivityTest extends AthrunTestCase {

	private static final String LOG_TAG = "RegisterActivityTest";
	
	public RegisterActivityTest() throws Exception {
		super("com.youyuan.yyhl", "com.youyuan.yyhl.activity.RegisterActivity");
		AthrunTestCase.setMaxTimeToFindView(10000);
	}

//	@Test
//	public void testFindViews() throws Exception {
//		findElementById("WomanBtn").doClick();
//		assertEquals(true, waitForText("ע��ɹ�", 10000));
//
//	}
//	

	
	

	@Test
	public void testSelectAge() throws Exception {
		
		//�õ������б�Spinner, It is a ViewGroupElement.
		ViewGroupElement ageSpinner = findElementById("Age", ViewGroupElement.class);
		
		//ageSpinner.getChildCount()ʼ�յ���1����Ҫ����
		Log.i(LOG_TAG, "RegisterActivityTest:getChildCount: "+ageSpinner.getChildCount());
		
		//Ĭ��ѡ�е���"22��"
		//Spinner���ӿؼ�Ӧ������CheckedTextView
		assertEquals("22��", ageSpinner.getChildByIndex(0, TextViewElement.class).getText());
		
		
		//���һ�������б�
		ageSpinner.doClick();

		//����ok�ģ���Ϊֱ�ӿ��Կ����б�������"23��"��item
		//assertEquals(true, waitForText("23��", 2000));

		
		////���������Ļ�ڵ�item�������Ҳ�����
		//TextViewElement d = findElementByText("23��");
		//assertNotNull("d is not null", d);

		//��ǰ��ͼ��ǰֻ��һ��listView�����Կ�����findListElementByIndex(0)�ҵ���
		AbsListViewElement listView = findListElementByIndex(0);
		assertNotNull("listView is not null", listView);
		
		
		//�õ�"22��23��24��25��26��27��28��29��",����ǰҳ�ɼ�������
		//listView.fetchText();
		
		
		//�õ��б������65
		//listView.getAdapter().getCount();

		
		//�õ�8���������е�65
		//ListView v = (ListView)listView.getView();
		//v.getChildCount();


		
		//�õ������֣�Ҳ�ǵ�ǰ������ʾ����Ŀ
		Log.i(LOG_TAG, "RegisterActivityTest:getChildCount1: "+listView.getChildCount());
		//��������view��ס���ͻ�õ�0��������getChildCount()
		Log.i(LOG_TAG, "RegisterActivityTest:getDirectChildCount1: "+listView.getDirectChildCount());		


		//�����2��item�����index=1��item��"17��"��
		listView.getChildByIndex(1).doClick();
		
		//Spinner��ǰѡ�е���"17��"
		assertEquals(true, waitForText("17��", 2000));
		//Spinner���ӿؼ�Ӧ������CheckedTextView
		assertEquals("17��", ageSpinner.getChildByIndex(0, TextViewElement.class).getText());
		
		
		//�õ�ѡ��֮ǰ��ֵ����֪��ԭ��Ҫ��Դ������ôʵ�ֵġ�
		Log.i(LOG_TAG, "RegisterActivityTest:fetchText: "+ageSpinner.fetchText());
		

		SleepUtils.sleep(5000);


	}
	
}
