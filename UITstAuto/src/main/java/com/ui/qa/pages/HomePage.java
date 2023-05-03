package com.ui.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage{
	
	// locating page objects
	@FindBy(xpath="//div[text()='Swag Labs']") WebElement hp_header;
	
	// initializing web elements
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// performing actions on web elements
	public String validateHomePageHeader() {
		return hp_header.getText();
	}
	

}
