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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.ObjectRepo.CreateOrgPage;
import com.comcast.crm.generic.ObjectRepo.HomePage;
import com.comcast.crm.generic.ObjectRepo.LoginPage;
import com.comcast.crm.generic.ObjectRepo.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.fileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void CreateOrgTest() throws Throwable, Throwable {
		//WebDriver driver;

		int RanValue = jlib.getRandomNumber();

		String Org_name = elib.getDataFromExcel("TestScript", 1, 2)+RanValue;

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrg().click();

		CreateOrgPage cp = new CreateOrgPage(driver);
		cp.SaveOrgName(Org_name);

		Thread.sleep(2000);

	}
}
