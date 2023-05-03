package com.ui.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage{
	
	WebDriver driver;

	// locating page objects
	@FindBy(xpath="//div[@class='login_logo']") WebElement pageheader;
	@FindBy(xpath="//div[@class='login_logo1']") WebElement pageheader1;
	@FindBy(xpath="//input[@name='user-name']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@name='login-button']") WebElement submitbutton;
	
	// initializing web elements
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// performing actions on web elements
	public String validateLoginPageHeader() {
		return pageheader.getText();
	}
	
	public void testExplicitWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(pageheader1));
	}
	
	public HomePage login(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		submitbutton.click();
		return new HomePage(driver);
	}

}
