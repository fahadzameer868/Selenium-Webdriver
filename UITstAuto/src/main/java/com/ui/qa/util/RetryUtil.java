package com.ui.qa.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryUtil implements IRetryAnalyzer{
	
	private int counter = 0;
	private int maxretry = 3;

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(counter < maxretry) {
			counter++;
			return true;
		}
		return false;
	}
	
}
