package com.sdet.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
//import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sdet.page.objects.HomePage;
import com.sdet.utilities.BrowserObject;
import com.sdet.utilities.DriverBinariesObject;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest {
	
	WebDriver driver;
	BrowserObject bo;
	DriverBinariesObject driverExeObject;
	HomePage hp;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(@Optional("chrome") String browser) throws InterruptedException {
		
		driverExeObject = new DriverBinariesObject();
		driverExeObject.browserBinariesSetUp(browser);	
		bo = new BrowserObject();
		driver = bo.createObject(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		hp = PageFactory.initElements(driver, HomePage.class);
		Thread.sleep(5000);
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority=0)
	public void logoVerification() {
		
		Assert.assertTrue(hp.logoPropertyCheck(), "Logo is not displayed");
		String logoPath = hp.getLogoPath();
		Assert.assertTrue(logoPath.contains("logo.png"));		
	}
	

}
