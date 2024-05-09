package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import com.comcast.crm.generic.ObjectRepo.CreateOrgPage;
import com.comcast.crm.generic.ObjectRepo.HomePage;
import com.comcast.crm.generic.ObjectRepo.LoginPage;
import com.comcast.crm.generic.ObjectRepo.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.fileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrgWithIndustryTest extends BaseClass {

	@Test
	public void CreateOrgWithIndTest() throws Throwable, Throwable {
		int RanValue = jlib.getRandomNumber();
		
		//get test script data from excel
		String Org_name=elib.getDataFromExcel("TestScript", 4, 2)+RanValue;	
		String Industry=elib.getDataFromExcel("TestScript", 4, 3);	
		String Type=elib.getDataFromExcel("TestScript", 4, 4);
	
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrg().click();
		
		CreateOrgPage cp=new CreateOrgPage(driver);
		cp.SaveOrgWithIndustry(Org_name, Industry, Type);

		Thread.sleep(2000);
	}

}
