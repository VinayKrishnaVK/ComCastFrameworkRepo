package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.ObjectRepo.CreateOrgPage;
import com.comcast.crm.generic.ObjectRepo.HomePage;
import com.comcast.crm.generic.ObjectRepo.LoginPage;
import com.comcast.crm.generic.ObjectRepo.OrgInfoPageToDelete;

import CreateOrgUsingPOM.OrgPage;

public class DeleteOrg1Test extends BaseClass {

	@Test
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
