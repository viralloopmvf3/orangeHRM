package com.orangehrm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	
	public ConfigDataProvider() {
		File src = new File("./Config/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to load properties file "+e.getMessage());
		}
		
	}
	
	public String getDataFromConfig(String key) {
		return pro.getProperty(key);
	}
	public String getBrowser() {
		return pro.getProperty("browser");
	}
	public String getUrL() {
		return pro.getProperty("url");
	}

}
