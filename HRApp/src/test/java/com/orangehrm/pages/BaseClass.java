package com.orangehrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.orangehrm.utility.BrowserFactory;
import com.orangehrm.utility.ConfigDataProvider;
import com.orangehrm.utility.ExcelDataProvider;
import com.orangehrm.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting up reports and test started",true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/HRM-"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting Done -- Test can be started",true);
	}
	
	@BeforeClass
	public void setUp() {
		Reporter.log("Trying to start browser and getting application ready",true);
		driver = BrowserFactory.startApplication(config.getBrowser(), config.getUrL(), driver);
		
		Reporter.log("Browser and application is up and running",true);
	}
	@AfterClass
	public void tearDown() {
		BrowserFactory.tearDown(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		Reporter.log("Test is about to end",true);
		if(result.getStatus()==ITestResult.FAILURE) {
			//Helper.captureScreenshot(driver);
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		Reporter.log("Test completed >>>> Reports generated",true);
	}

}
