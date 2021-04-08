package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//new comment added
public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	@FindBy(name="txtUserName") WebElement uname;
	@FindBy(name="txtPassword") WebElement pass;
	@FindBy(name="Submit") WebElement submit;
	@FindBy(name="clear") WebElement clear;
	
	public void loginHRM(String username,String password) throws InterruptedException {
		uname.sendKeys(username);
		Thread.sleep(2000);
		pass.sendKeys(password);
		Thread.sleep(2000);
		submit.click();
		
	}
}
