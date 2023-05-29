package com.ui.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ui.qa.base.TestBase;
import com.ui.qa.pages.CartPage;
import com.ui.qa.pages.InventoryPage;
import com.ui.qa.pages.LoginPage;

public class CartPageTest extends TestBase{
	
	private CartPage cartpage;
	SoftAssert softassert;
	
	public CartPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		LoginPage loginpage = new LoginPage(driver);
		InventoryPage inventorypage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		cartpage = inventorypage.clickOnCartButton();
	}
	
	@Test
	public void cartCheckout() {
		softassert = new SoftAssert();
		String title = cartpage.getCartPageHeaderText();
		softassert.assertEquals(title, "Your Carrt");
		log.info("verify page title, Expected value: Your Cart && Actual Value: "+ title);
		cartpage.clickOnCheckoutBtn();
		softassert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
