package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.ObjectRepo.ContactsPage;
import com.comcast.crm.generic.ObjectRepo.CreateContactsPage;
import com.comcast.crm.generic.ObjectRepo.CreateOrgPage;
import com.comcast.crm.generic.ObjectRepo.HomePage;
import com.comcast.crm.generic.ObjectRepo.LoginPage;
import com.comcast.crm.generic.ObjectRepo.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.fileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class createContactWithOrganization extends BaseClass {

	
	@Test
	public void CreateConWithOrg() throws IOException, Throwable {
	
		int RanValue = jlib.getRandomNumber();
		
			
		String Org_Name = elib.getDataFromExcel("TestScript", 7, 2)+RanValue;
		String Industry = elib.getDataFromExcel("TestScript", 7, 3);
		String Type = elib.getDataFromExcel("TestScript", 7, 4);
		String Phone = elib.getDataFromExcel("TestScript", 7, 5);
		String lastName=elib.getDataFromExcel("Contact", 7, 2)+RanValue;
		
		//creating organization
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrg().click();
		
		CreateOrgPage cop=new CreateOrgPage(driver);
		cop.SaveOrgWithIndustry(Org_Name, Industry, Type);
		
		//creating contact module
		Thread.sleep(2000);
		hp.getContactLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getContactPlusImg().click();
		
		CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.SaveContactsWithOrg(lastName, driver, Org_Name);
		
		hp.SignOut(driver);
		driver.quit();
		
		
	}

}









