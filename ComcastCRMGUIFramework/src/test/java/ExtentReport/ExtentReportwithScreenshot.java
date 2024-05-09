package ExtentReport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportwithScreenshot {

	ExtentSparkReporter spark
	ExtentReports report;
	@BeforeSuite
	public void BSConfig() {
		//spark config
				spark=new ExtentSparkReporter("./AdvancedReport/Report.html");
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
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("CreateContactTest");
		test.log(Status.INFO, "Launch Browser");
		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "Navigate to Contact Page");
		test.log(Status.INFO, "Create Contact");
		if ("HDC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is Created");
		}
		else {
		test.addScreenCaptureFromBase64String(filepath);
		}
	
		test.log(Status.INFO, "LogOut");
	}
}
