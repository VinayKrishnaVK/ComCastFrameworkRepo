 package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.ObjectRepo.ContactsPage;
import com.comcast.crm.generic.ObjectRepo.CreateContactsPage;
import com.comcast.crm.generic.ObjectRepo.HomePage;
import com.comcast.crm.generic.ObjectRepo.LoginPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.fileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateContactTest extends BaseClass {

	@Test
	public void CreateConTest() throws Throwable, Throwable{
		int RanValue = jlib.getRandomNumber();
		
		String lastName=elib.getDataFromExcel("Contact", 1, 2)+RanValue;
		
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getContactPlusImg().click();
			
		CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.SaveLastName(lastName);
		
		Thread.sleep(2000);
		
	}

}
