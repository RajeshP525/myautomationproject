package com.sdet.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		
		this.driver = driver;
	}
	
	@FindBy(css = "img[src$=\"logo.png\"]")
	WebElement logo;
	
	@FindBy(css = "#txtUsername")
	WebElement userName;
	
	@FindBys({
		
		@FindBy(id = "divPassword"),
		@FindBy(id = "txtPassword")
		
	})
	WebElement userPwd;
	
	@FindBy(css = "#btnLogin")
	WebElement loginBtn;
	
	public void setUserName(String str){
		userName.sendKeys(str);
		
	}
	
	public void setPassword(String str){
		userPwd.sendKeys(str);
		
	}
	
	public void clickLogin(){
		
		loginBtn.click();
		
	}
	
	public String getLogoPath() {
		
		return logo.getAttribute("src");
	}
	
	public boolean logoPropertyCheck() {
		
		return logo.isDisplayed();
	}
}
