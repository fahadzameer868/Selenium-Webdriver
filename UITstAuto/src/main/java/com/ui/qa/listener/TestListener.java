package com.ui.qa.listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ui.qa.base.TestBase;
import com.ui.qa.util.ScreenShotUtil;

public class TestListener extends TestBase implements ITestListener{

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			String testname = result.getMethod().getMethodName();
			ScreenShotUtil.takeScreenShot(driver, "C:\\Users\\Fahad.Zameer\\eclipse-workspace\\UITstAuto\\test-output\\screenshots\\"+testname+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
