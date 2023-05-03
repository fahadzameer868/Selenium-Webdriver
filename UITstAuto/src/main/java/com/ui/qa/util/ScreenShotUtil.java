package com.ui.qa.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class ScreenShotUtil {
	
	public static void takeScreenShot(WebDriver driver, String filepath) throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(filepath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

}
