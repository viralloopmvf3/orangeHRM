package com.orangehrm.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String captureScreenshot(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	String screenshotPath = System.getProperty("user.dir")+"/Screenshots/HRM_"+getCurrentDateTime()+".png";	
		FileHandler.copy(src, new File(screenshotPath));
		
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
	}
	public void handleFrames() {
		
	}
	
	public void handleAlerts() {
		
	}
	
	public void handleWindows() {
		
	}
}
