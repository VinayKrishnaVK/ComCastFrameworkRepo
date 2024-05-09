package com.comcast.crm.generic.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement OrgLink;

	public WebElement getOrgLink() {
		return OrgLink;
	}
	@FindBy(linkText = "Contacts")
	private WebElement ContactLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement SignOutBtn;
	
	public WebElement getContactLink() {
		return ContactLink;
	}

	@FindBy(linkText = "Sign Out")
	private WebElement Sign;
	
	public WebElement getSign() {
		return Sign;
	}

	public WebElement getSignOutBtn() {
		return SignOutBtn;
	}
	
	public void SignOut() {
		Actions act=new Actions(driver);
		act.moveToElement(SignOutBtn).perform();
		Sign.click();
		
	}
	
	
}
