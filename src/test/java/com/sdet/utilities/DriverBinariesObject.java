package com.sdet.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverBinariesObject {
	
	
	public void browserBinariesSetUp(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		}else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
		}

		
	}
	
}
