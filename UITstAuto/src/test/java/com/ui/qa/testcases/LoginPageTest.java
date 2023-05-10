package com.ui.qa.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ui.qa.base.TestBase;
import com.ui.qa.pages.LoginPage;
import com.ui.qa.util.ExcelDataReaderUtil;


public class LoginPageTest extends TestBase{
	
	private LoginPage loginpage;

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("Setting Up Browser");
		initialization();
		loginpage = new LoginPage(driver);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		Object[][] data = ExcelDataReaderUtil.readExcelData(prop.getProperty("file_path"), prop.getProperty("sheet_name"));
		return data;
	}
	
	@Test(dataProvider="getData", priority=1)
	public void loginTest(String username, String password) {
		//loginpage.testExplicitWait();
		System.out.println(System.getProperty("user.dir"));
		String title = loginpage.validateLoginPageHeader();
		Assert.assertEquals(title,"Swag Labs");
		loginpage.login(username, password);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
