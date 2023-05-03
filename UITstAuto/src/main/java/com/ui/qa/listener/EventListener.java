package com.ui.qa.listener;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class EventListener implements WebDriverListener{
	
	private Logger log = LogManager.getLogger();

	public void afterClick(WebElement element) {
		// TODO Auto-generated method stub
		log.info("Click On: "+ element);
		System.out.println("Click On: "+ element);
	}

	public void afterAnyNavigationCall(Navigation navigation, Method method, Object[] args, Object result) {
		// TODO Auto-generated method stub
		log.info("Navigate to: "+ navigation);
		System.out.println("Navigate to: "+ navigation);
	}

}
