package com.sdet.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyInfoPage {

	WebDriver driver;
	
	public MyInfoPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	@FindBy(xpath="//table[@id='emgcontact_list']/tbody/tr//*[contains(text(),'Rajesh')]/../../td[1]")
	WebElement delRecord;
	
	@FindBy(xpath="//input[@id='delContactsBtn']")
	WebElement delContBtn;
	
	@FindBy(css="#menu_pim_viewMyDetails")
	WebElement infoItm;
	
	@FindBy(xpath="//a[contains(text(),'Emergency Contacts')]")
	WebElement emgContItm;
	
	@FindBy(xpath="//input[@id='btnAddContact']")
	WebElement addContBtn;
	
	@FindBy(css="#emgcontacts_name")
	WebElement emgContName;
	
	@FindBy(css="#emgcontacts_homePhone")
	WebElement emgHomeCell;
	
	@FindBy(css="#emgcontacts_relationship")
	WebElement emgContRelation;
	
	@FindBy(xpath="//input[@id='btnSaveEContact']")
	WebElement saveContBtn;
	
	@FindBy(css="#welcome")
	WebElement profileLink;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logoutLink;
	
	public void clickInfoMenuItm() {
		
		infoItm.click();
	}
	
	public void clickEmgContacts() {
		
		Actions actions = new Actions(driver);
		actions.click(emgContItm).build().perform();
		
	}
	
    public void clickAddBtn() {
		
    	addContBtn.click();
		
	}
	
	public void setEmgContactName(String name) {
		
		emgContName.sendKeys(name);
		
	}
	
   public void setRelationShip(String relShip) {
		
	   emgContRelation.sendKeys(relShip);
		
	}
	
   public void setHomeContact(String contact) {
		
	   emgHomeCell.sendKeys(contact);
		
	}
	
	
   public void clickEmgSaveBtn() {
		
	   saveContBtn.click();
		
	}
	
	public void clickLogout() throws InterruptedException {
		
		Actions actions = new Actions(driver);
		actions.click(profileLink).build().perform();
		Thread.sleep(2000);
		logoutLink.click();
		
		
	}
	
	public void delRecordFromTable() {
		
		delRecord.click();
		delContBtn.click();
		
	}
	
}
