package com.orangehrm.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginNFW {
	
	@Test
	public void loginApp() {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1/orangehrm-2.6/login.php");
		
		
		driver.quit();
		
	}
}
