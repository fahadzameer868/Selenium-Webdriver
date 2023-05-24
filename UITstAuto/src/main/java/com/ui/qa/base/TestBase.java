package com.ui.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.ui.qa.listener.EventListener;
import com.ui.qa.util.ParamsUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver decorator;
	public static Properties prop;
	public static WebDriver driver;
	public static EventListener eventlistener;
	public static Logger log;
	
	public TestBase() {
		prop = new Properties();
		log = LogManager.getLogger();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ui\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initialization() {
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			decorator = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("FF")){
			WebDriverManager.firefoxdriver().setup();
			decorator = new FirefoxDriver();
		}
		//setting up the firing events
		
		eventlistener = new EventListener();
		driver = new EventFiringDecorator<WebDriver>(eventlistener).decorate(decorator);
		
		//setting up the browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ParamsUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ParamsUtil.IMPLICIT_WAIT));
		driver.get(prop.getProperty("base_url"));
	}

}
