package com.ui.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InventoryPage{
	
	// locating page objects
	@FindBy(xpath="//div[text()='Swag Labs']") WebElement hp_header;
	@FindBy(xpath="//button[contains(@class,'btn_inventory')]") List<WebElement> add_to_cart_btns;
	
	// initializing web elements
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// performing actions on web elements
	public String validateInventoryPageHeader() {
		return hp_header.getText();
	}
	
	public void addAllItemsToCart() {
		for(WebElement btn : add_to_cart_btns) {
			btn.click();
		}
	}
}
