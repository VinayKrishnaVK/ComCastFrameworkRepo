package com.comcast.crm.generic.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgPage {
	
	public CreateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="accountname")
	private WebElement OrgNameField;
	
	@FindBy(name="industry")
	private WebElement IndustryField;
	
	@FindBy(name="accounttype")
	private WebElement AccountTypeField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(id = "phone")
	private WebElement PhoneField;
	
	public WebElement getIndustryField() {
		return IndustryField;
	}

	public WebElement getAccountTypeField() {
		return AccountTypeField;
	}

	public WebElement getPhoneField() {
		return PhoneField;
	}

	public WebElement getOrgNameField() {
		return OrgNameField;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public void SaveOrgName(String OrgName) {
		OrgNameField.sendKeys(OrgName);
		SaveBtn.click();
	}
	public void SaveOrgWithIndustry(String OrgName,String Industry,String Type) {
		OrgNameField.sendKeys(OrgName);
		Select dropdownInd=new Select(IndustryField);
		dropdownInd.selectByValue(Industry);
		Select dropdownType=new Select(AccountTypeField);
		dropdownType.selectByValue(Type);
		SaveBtn.click();
	}
	public void SaveOrgWithPhone(String OrgName,String Industry,String Type, String Phone) {
		OrgNameField.sendKeys(OrgName);
		Select dropdownInd=new Select(IndustryField);
		dropdownInd.selectByValue(Industry);
		Select dropdownType=new Select(AccountTypeField);
		dropdownType.selectByValue(Type);
		PhoneField.sendKeys(Phone);
		SaveBtn.click();
	}
}

