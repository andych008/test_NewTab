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
//		assertEquals(true, waitForText("注册成功", 10000));
//
//	}
//	

	
	

	@Test
	public void testSelectAge() throws Exception {
		
		//得到下拉列表Spinner, It is a ViewGroupElement.
		ViewGroupElement ageSpinner = findElementById("Age", ViewGroupElement.class);
		
		//ageSpinner.getChildCount()始终等于1，不要被误导
		Log.i(LOG_TAG, "RegisterActivityTest:getChildCount: "+ageSpinner.getChildCount());
		
		//默认选中的是"22岁"
		//Spinner的子控件应该是是CheckedTextView
		assertEquals("22岁", ageSpinner.getChildByIndex(0, TextViewElement.class).getText());
		
		
		//点击一个下拉列表
		ageSpinner.doClick();

		//这是ok的，因为直接可以看到列表内容有"23岁"的item
		//assertEquals(true, waitForText("23岁", 2000));

		
		////如果不在屏幕内的item，将会找不到。
		//TextViewElement d = findElementByText("23岁");
		//assertNotNull("d is not null", d);

		//当前视图当前只有一个listView，所以可以用findListElementByIndex(0)找到。
		AbsListViewElement listView = findListElementByIndex(0);
		assertNotNull("listView is not null", listView);
		
		
		//得到"22岁23岁24岁25岁26岁27岁28岁29岁",即当前页可见的内容
		//listView.fetchText();
		
		
		//得到列表的总数65
		//listView.getAdapter().getCount();

		
		//得到8，不是所有的65
		//ListView v = (ListView)listView.getView();
		//v.getChildCount();


		
		//得到的数字，也是当前屏可显示的数目
		Log.i(LOG_TAG, "RegisterActivityTest:getChildCount1: "+listView.getChildCount());
		//如果被别的view挡住，就会得到0，不等于getChildCount()
		Log.i(LOG_TAG, "RegisterActivityTest:getDirectChildCount1: "+listView.getDirectChildCount());		


		//点击第2个item（这里，index=1的item是"17岁"）
		listView.getChildByIndex(1).doClick();
		
		//Spinner当前选中的是"17岁"
		assertEquals(true, waitForText("17岁", 2000));
		//Spinner的子控件应该是是CheckedTextView
		assertEquals("17岁", ageSpinner.getChildByIndex(0, TextViewElement.class).getText());
		
		
		//得到选中之前的值，不知道原因，要看源码是怎么实现的。
		Log.i(LOG_TAG, "RegisterActivityTest:fetchText: "+ageSpinner.fetchText());
		

		SleepUtils.sleep(5000);


	}
	
}
