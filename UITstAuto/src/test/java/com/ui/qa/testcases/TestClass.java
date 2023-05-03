package com.ui.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.ui.qa.base.TestBase;

public class TestClass extends TestBase {
	
	@BeforeMethod
	public void bMethod() {
		
	}
	
	@Test
	public void test1() throws InterruptedException{
		for(int i=0; i<20; i++) {
			log.info("message "+i);
			Thread.sleep(100);
		}
	}
	
	@AfterMethod
	public void aMethod() {
		System.out.println("After Method Execution");
		ExtentReports report = new ExtentReports();
		
	}
	

}
