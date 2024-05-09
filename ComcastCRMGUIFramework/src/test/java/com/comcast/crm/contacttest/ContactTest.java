package com.comcast.crm.contacttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.ObjectRepo.ContactsPage;
import com.comcast.crm.generic.ObjectRepo.CreateContactsPage;
import com.comcast.crm.generic.ObjectRepo.CreateOrgPage;
import com.comcast.crm.generic.ObjectRepo.HomePage;
import com.comcast.crm.generic.ObjectRepo.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.listenerUtility.ListenerImpClass;

@Listeners(com.comcast.crm.listenerUtility.ListenerImpClass.class)
public class ContactTest extends BaseClass {
	@Test(groups = "Smoke")
	public void createConTest() throws Throwable, Throwable {
		int RanValue = jlib.getRandomNumber();

		String lastName = elib.getDataFromExcel("Contact", 1, 2)+RanValue;

		ListenerImpClass.test.log(Status.INFO, "Logged in");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getContactPlusImg().click();

		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.SaveLastName(lastName);
		Assert.fail(); //to get screenshot in report
		ListenerImpClass.test.log(Status.INFO, "Contact created");
		
		//verify
		String Headermsg = cp.getHeaderMsg().getText();
		boolean status = Headermsg.contains(lastName);
		Assert.assertTrue(status);
		
		String LastNameField = cp.getLastNameField().getText();
		SoftAssert SoftAss=new SoftAssert();
		SoftAss.assertEquals(LastNameField, lastName);

		ListenerImpClass.test.log(Status.INFO, "Logged Out");
		Thread.sleep(2000);

	}

	@Test(groups =  "Regression")
	public void createConWithOrg() throws IOException, Throwable {

		int RanValue = jlib.getRandomNumber();

		String Org_Name = elib.getDataFromExcel("TestScript", 7, 2)+RanValue;
		String Industry = elib.getDataFromExcel("TestScript", 7, 3);
		String Type = elib.getDataFromExcel("TestScript", 7, 4);
		String lastName = elib.getDataFromExcel("Contact", 7, 2)+RanValue;

		// creating organization
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrg().click();

		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.SaveOrgWithIndustry(Org_Name, Industry, Type);

		// creating contact module
		Thread.sleep(2000);
		hp.getContactLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getContactPlusImg().click();

		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.SaveContactsWithOrg(lastName, driver, Org_Name);
		
		//verify
		String Headermsg = cp.getHeaderMsg().getText();
		boolean status = Headermsg.contains(lastName);
		Assert.assertTrue(status);
		Reporter.log(Headermsg+" HeaderMsg is verfied",true);
		
		String OrgNameField = cp.getOrgNameField().getText();
		SoftAssert SoftAss=new SoftAssert();
		SoftAss.assertEquals(OrgNameField, Org_Name);
		Reporter.log(OrgNameField+" OrgName is verified",true);
		
		Thread.sleep(2000);

	}

	@Test(groups =  "Regression")
	public void createConWithDate() throws Throwable {
		int RanValue = jlib.getRandomNumber();

		// get test script data from excel
		ExcelUtility elib = new ExcelUtility();
		String lastName = elib.getDataFromExcel("Contact", 4, 2)+RanValue;

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getContactPlusImg().click();

		// current date
		String startDate = jlib.getStartDateYYYYMMDD();

		// end date(after 30days)
		String endDate = jlib.getEndDateYYYYMMDD(30);

		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.SaveContactWithDate(lastName, startDate, endDate);

		Thread.sleep(2000);
	}
}
