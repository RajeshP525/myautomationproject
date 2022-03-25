package com.sdet.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserObject {
	
	WebDriver driver;
	
	
	public WebDriver createObject(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("ie")) {
			driver =  new InternetExplorerDriver();
		}
		
		return driver;
		
	}

}
