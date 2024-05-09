package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.ObjectRepo.HomePage;
import com.comcast.crm.generic.ObjectRepo.LoginPage;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.fileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class BaseClass {

	public static WebDriver driver;
	public DatabaseUtility dblib=new DatabaseUtility();
	public fileUtility flib=new fileUtility();
	public static JavaUtility jlib=new JavaUtility();
	public static ExcelUtility elib=new ExcelUtility();
	
	@BeforeSuite
	public void ConfigBS() throws Throwable {
		System.out.println("===Connect to DB===");
		dblib.getDbConnection();
	}
	
	@BeforeClass
	public void ConfigBC() throws Throwable {
		System.out.println("===Launch Browser===");
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		
		if(BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new InternetExplorerDriver();
		}
		else {
			driver=new ChromeDriver();
		}
	}
	@BeforeMethod
	public void ConfigBM() throws Throwable {
		System.out.println("===Login===");
		LoginPage lp=new LoginPage(driver);
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		lp.Login(URL,USERNAME, PASSWORD);
		
	}
	
	@AfterMethod
	public void ConfigAM() {
		System.out.println("===Logout===");
		HomePage hp=new HomePage(driver);
		hp.SignOut();
	}
	@AfterClass
	public void ConfigAC() throws InterruptedException {
		System.out.println("===Close Browser===");
		Thread.sleep(2000);
		driver.quit();
	}
	@AfterSuite
	public void ConfigAS() throws SQLException {
		System.out.println("===Close DB===");
		dblib.closeDbConnection();
	}
}
