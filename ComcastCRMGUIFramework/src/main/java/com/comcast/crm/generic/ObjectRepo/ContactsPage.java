package com.comcast.crm.generic.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement ContactPlusImg;

	public WebElement getContactPlusImg() {
		return ContactPlusImg;
	}
	@FindBy(className = "dvHeaderText")
	private WebElement HeaderMsg;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement LastNameField;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement OrgNameField;

	public WebElement getOrgNameField() {
		return OrgNameField;
	}

	public WebElement getHeaderMsg() {
		return HeaderMsg;
	}

	public WebElement getLastNameField() {
		return LastNameField;
	}


}
