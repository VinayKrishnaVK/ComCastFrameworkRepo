package ExtentReport;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AdvancedExtentReport {
	ExtentReports report;
	@BeforeSuite
	public void BSConfig() {
		//spark config
				ExtentSparkReporter spark=new ExtentSparkReporter("./AdvancedReport/Report.html");
				spark.config().setDocumentTitle("CRM Extent Report");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				
				report=new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", "Windows-11");
				report.setSystemInfo("BROWSER", "CHROME");
				
	}
	@AfterSuite
	public void ASConfig() {
		report.flush();
	}
	@Test
	public void CreateContactTest() {
		
		ExtentTest test = report.createTest("CreateContactTest");
		test.log(Status.INFO, "Launch Browser");
		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "Navigate to Contact Page");
		test.log(Status.INFO, "Create Contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is Created");
		}
		else {
		test.log(Status.FAIL, "Contact is not Created");
		}
	
		test.log(Status.INFO, "LogOut");
	}

	@Test
	public void CreateOrgTest() {
		
		ExtentTest test = report.createTest("CreateOrgTest");
		test.log(Status.INFO, "Launch Browser");
		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "Navigate to Contact Page");
		test.log(Status.INFO, "Create Contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is Created");
		}
		else {
		test.log(Status.FAIL, "Contact is not Created");
		}
	
		test.log(Status.INFO, "LogOut");
	}
	@Test
	public void CreateProductTest() {
		
		ExtentTest test = report.createTest("CreateProductTest");
		test.log(Status.INFO, "Launch Browser");
		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "Navigate to Contact Page");
		test.log(Status.INFO, "Create Contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is Created");
		}
		else {
		test.log(Status.FAIL, "Contact is not Created");
		}
	
		test.log(Status.INFO, "LogOut");
	}
}
