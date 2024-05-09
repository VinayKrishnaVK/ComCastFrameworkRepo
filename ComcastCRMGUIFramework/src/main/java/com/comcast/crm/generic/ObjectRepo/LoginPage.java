package com.comcast.crm.generic.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage {
	WebDriver driver; 
	WebDriverUtility wlib=new WebDriverUtility();
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getUname() {
		return uname;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	@FindBy(name="user_name")
	private WebElement uname;
	
	@FindBy(name="user_password")
	private WebElement pass;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	public void Login(String url,String Username,String Pass) {
		driver.get(url);
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
		uname.sendKeys(Username);
		pass.sendKeys(Pass);
		loginBtn.click();
	}
}
