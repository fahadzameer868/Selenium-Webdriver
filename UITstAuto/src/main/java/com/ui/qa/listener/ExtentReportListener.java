package com.ui.qa.listener;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportListener implements IReporter{
	
	private ExtentReports extent;
	private ExtentSparkReporter spark;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"\\test-output\\extent-report.html");
		extent.attachReporter(spark);
		
		for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
 
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getPassedTests(),Status.PASS);
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
            }
        }
 
        extent.flush();
		
	}
	

	private void buildTestNodes(IResultMap tests, Status status) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				String testname = result.getMethod().getMethodName();
				test = extent.createTest(testname);

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase()
							+ "ed");
				}
				
				if (status == Status.FAIL) {
					test.fail(MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Fahad.Zameer\\eclipse-workspace\\UITstAuto\\test-output\\screenshots\\"+testname+".png").build());
				}
			}
		}
	}
}