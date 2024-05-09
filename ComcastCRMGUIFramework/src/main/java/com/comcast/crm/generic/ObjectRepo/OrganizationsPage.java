package com.comcast.crm.generic.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//creation
public class OrganizationsPage {
	//initialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Identification
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement CreateOrg;

	//encapsulation
	public WebElement getCreateOrg() {
		return CreateOrg;
	}

	
}
