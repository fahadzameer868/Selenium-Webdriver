package com.ui.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ui.qa.base.TestBase;
import com.ui.qa.pages.HomePage;
import com.ui.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	private HomePage homepage;
	private SoftAssert softassert;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		LoginPage loginpage = new LoginPage(driver);
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateHomePageHeader() {
		String hp_text = homepage.validateHomePageHeader();
		softassert = new SoftAssert();
		softassert.assertEquals(hp_text, "Swag Labs");
		softassert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
