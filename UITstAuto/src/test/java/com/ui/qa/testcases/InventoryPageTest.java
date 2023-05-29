package com.ui.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ui.qa.base.TestBase;
import com.ui.qa.pages.InventoryPage;
import com.ui.qa.pages.LoginPage;

public class InventoryPageTest extends TestBase{
	
	private InventoryPage inventorypage;
	private SoftAssert softassert;
	
	public InventoryPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		LoginPage loginpage = new LoginPage(driver);
		inventorypage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void addProductsToCart() {
		String hp_text = inventorypage.getInventoryPageHeader();
		softassert = new SoftAssert();
		softassert.assertEquals(hp_text, "Products");
		inventorypage.addAllItemsToCart();
		inventorypage.clickOnCartButton();
		softassert.assertAll();
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
