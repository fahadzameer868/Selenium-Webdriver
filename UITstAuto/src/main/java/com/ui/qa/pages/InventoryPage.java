package com.ui.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InventoryPage{
	
	WebDriver driver;
	
	// locating page objects
	@FindBy(xpath="//span[@class='title']") WebElement page_title;
	@FindBy(xpath="//button[contains(@class,'btn_inventory')]") List<WebElement> add_to_cart_btns;
	@FindBy(xpath="//a[@class='shopping_cart_link']") WebElement main_cart_btn;
	
	// initializing web elements
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// performing actions on web elements
	public String getInventoryPageHeader() {
		return page_title.getText();
	}
	
	public void addAllItemsToCart() {
		for(WebElement btn : add_to_cart_btns) {
			btn.click();
		}
	}
	
	public CartPage clickOnCartButton() {
		main_cart_btn.click();
		return new CartPage(driver);
	}
}
