package com.ui.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	@FindBy(xpath="//span[@class='title']") WebElement page_title;
	@FindBy(xpath="//button[@id='checkout' and @name='checkout']") WebElement checkout_btn;	

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions on Webelements

	public String getCartPageHeaderText() {
		return page_title.getText();
	}
	
	public void clickOnCheckoutBtn() {
		checkout_btn.click();
	}

}
