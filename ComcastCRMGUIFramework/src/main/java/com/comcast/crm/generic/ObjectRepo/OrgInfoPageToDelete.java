package com.comcast.crm.generic.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPageToDelete {

	public OrgInfoPageToDelete(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement OrgLink1;

	public WebElement getOrgLink1() {
		return OrgLink1;
	}
	
	
}
