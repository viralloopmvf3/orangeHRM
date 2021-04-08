package com.orangehrm.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.orangehrm.pages.BaseClass;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends BaseClass{
	
	@Test
	public void loginApp() throws Exception {
		logger=report.createTest("Login To HRM");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting application");
		loginPage.loginHRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		logger.pass("Login done successful");
		
	}
	
}
