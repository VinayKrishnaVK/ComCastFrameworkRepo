package com.comcast.crm.generic.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactsPage {

	public CreateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastnameField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement OrgPlusBtn;
	
	@FindBy(id = "search_txt")
	private WebElement SearchTextField;

	@FindBy(name="search")
	private WebElement SearchBtn;
	
	@FindBy(name="support_start_date")
	private WebElement StartDateField;
	
	@FindBy(xpath = "//input[@id='jscal_field_support_end_date']")
	private WebElement EndDateField;
	public WebElement getLastnameField() {
		return lastnameField;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrgPlusBtn() {
		return OrgPlusBtn;
	}

	public WebElement getSearchTextField() {
		return SearchTextField;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebDriverUtility getWlib() {
		return wlib;
	}

	public void SaveLastName(String lastname) {
		lastnameField.sendKeys(lastname);
		SaveBtn.click();
	}
	WebDriverUtility wlib=new WebDriverUtility();
	
	public void SaveContactsWithOrg(String lastname,WebDriver driver, String Org_name) {
		lastnameField.sendKeys(lastname);
		OrgPlusBtn.click();
		wlib.switchTabURL(driver, "Accounts&action");
		SearchTextField.sendKeys(Org_name);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+Org_name+"']")).click();
		wlib.switchTabURL(driver, "Contacts&action");
		SaveBtn.click();
	}
	
	public void SaveContactWithDate(String lastname,String startDate,String enddate) {
		lastnameField.sendKeys(lastname);
		StartDateField.sendKeys(startDate);
		EndDateField.clear();
		EndDateField.sendKeys(enddate);
		SaveBtn.click();
	}

}
