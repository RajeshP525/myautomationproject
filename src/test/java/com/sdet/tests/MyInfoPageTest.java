package com.sdet.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sdet.page.objects.HomePage;
import com.sdet.page.objects.MyInfoPage;
import com.sdet.utilities.BrowserObject;
import com.sdet.utilities.DriverBinariesObject;

public class MyInfoPageTest {
	
	WebDriver driver;
	BrowserObject bo;
	DriverBinariesObject driverExeObject;
	HomePage hp;
	MyInfoPage mi;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(@Optional("chrome") String browser) {
		
		driverExeObject = new DriverBinariesObject();
		driverExeObject.browserBinariesSetUp(browser);	
		bo = new BrowserObject();
		driver = bo.createObject(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		hp = PageFactory.initElements(driver, HomePage.class);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	
	@Parameters({"user","pwd"})
	@Test(priority=0)
	public void loginCredCheck(@Optional("Admin") String user, @Optional("admin123") String pwd) {
		
		hp.setUserName(user);
		hp.setPassword(pwd);
		hp.clickLogin();
		Assert.assertEquals("OrangeHRM", driver.getTitle(),"login not successfull.");
		
	}
	
	
	@Parameters({"name","relShip","cellNo"})
	@Test(priority=1)
	public void createEmergencyContact(@Optional("Rajesh") String name, @Optional("Brother") String relShip, @Optional("9999999990") String cellNo) throws InterruptedException {
		mi = PageFactory.initElements(driver, MyInfoPage.class);
		Thread.sleep(5000);
		mi.clickInfoMenuItm();
		Thread.sleep(2000);
		mi.clickEmgContacts();
		Thread.sleep(2000);
		mi.clickAddBtn();
		Thread.sleep(2000);
		mi.setEmgContactName(name);
		mi.setRelationShip(relShip);
		mi.setHomeContact(cellNo);
		mi.clickEmgSaveBtn();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=2)
	public void delEmergencyContact() {
		
		mi.delRecordFromTable();
		
	}
	
	@Test(priority=3)
	public void logout() throws InterruptedException {
		
		mi.clickLogout();
	}
	

}

