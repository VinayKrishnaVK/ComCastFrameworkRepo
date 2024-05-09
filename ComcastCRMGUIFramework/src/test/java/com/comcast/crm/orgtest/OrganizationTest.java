package com.comcast.crm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.ObjectRepo.CreateOrgPage;
import com.comcast.crm.generic.ObjectRepo.HomePage;
import com.comcast.crm.generic.ObjectRepo.OrgInfoPageToDelete;
import com.comcast.crm.generic.ObjectRepo.OrganizationsPage;

import CreateOrgUsingPOM.OrgPage;

@Listeners(com.comcast.crm.listenerUtility.ListenerImpClass.class)
public class OrganizationTest extends BaseClass {

	@Test(groups =  "Smoke")
	public void createOrgTest() throws Throwable, Throwable {
		//WebDriver driver;

		int RanValue = jlib.getRandomNumber();

		String Org_name = elib.getDataFromExcel("TestScript", 1, 2)+RanValue;

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		Assert.fail();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrg().click();

		CreateOrgPage cp = new CreateOrgPage(driver);
		cp.SaveOrgName(Org_name);

		Thread.sleep(2000);

	}
	
	@Test(groups =  "Regression")
	public void createOrgWithIndTest() throws Throwable, Throwable {
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

	
	@Test(groups =  "Regression")
	public void createOrgWithPhoneTest() throws Throwable, Throwable {
		int RanValue = jlib.getRandomNumber();

		String Org_name=elib.getDataFromExcel("TestScript", 7, 2)+RanValue;	
		String Industry=elib.getDataFromExcel("TestScript", 7, 3);	
		String Type=elib.getDataFromExcel("TestScript", 7, 4);
		String Phone=elib.getDataFromExcel("TestScript", 7, 5);
		
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrg().click();
			
		CreateOrgPage cp=new CreateOrgPage(driver);
		cp.SaveOrgWithPhone(Org_name, Industry, Type, Phone);
	
		Thread.sleep(2000);

	}

	
	@Test(groups =  "Regression")
	public void deleteTest() throws Throwable {
		int RanValue = jlib.getRandomNumber();
		
		String Org_name=elib.getDataFromExcel("TestScript", 10, 2)+RanValue;	
		
		
		//HomePage-click on organizations
		HomePage HP=new HomePage(driver);
		HP.getOrgLink().click();
		
		//OrgPage-click on plus
		OrgPage OP=new OrgPage(driver);
		OP.getPlusBtn().click();
		
		
		//CreateNewOrgPage-send orgName & save
		CreateOrgPage CP=new CreateOrgPage(driver);
		CP.SaveOrgName(Org_name);
		
		//OrgInfoPage-go back to Organizations page
		Thread.sleep(2000);
		OrgInfoPageToDelete OIP=new OrgInfoPageToDelete(driver);
		OIP.getOrgLink1().click();
		
		//OrgPage-Send OrgName to Search For & Select Organization Name in IN & click search now
		OP.SearchNow(Org_name);
		
		//OrgPage-CheckBox OrgName and Delete
		OP.Delete(driver, Org_name);
		Thread.sleep(2000);
	}
	
	
}
