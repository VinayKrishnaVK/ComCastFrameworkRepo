package com.comcast.crm.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.google.common.io.Files;

public class ListenerImpClass implements ITestListener, ISuiteListener {

	public static ExtentReports report;
	public ExtentSparkReporter spark;
	public static ExtentTest test;
	String time;

	public void onStart(ISuite suite) {
		time = new Date().toString().replace(" ", "_").replace(":", "_");
		// TODO Auto-generated method stub
		System.out.println("report config");
		spark = new ExtentSparkReporter("./AdvancedReport/Report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Extent Report");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME");
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report backup");
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();

		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		File dest = new File("./screenshots/img10.png");
		Files.copy(filepath, dest);

		test.addScreenCaptureFromBase64String(filepath, testName + time);
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

//	public void onTestFailure(ITestResult result) {
////		System.out.println("-----Listning-----------");
////		
//		String TestName = result.getMethod().getMethodName();
////
////		System.out.println(TestName);
////		//System.out.println(BaseClass.sdriver);
//		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
//	File srcFile = edriver.getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyDirectory(srcFile, new File("./screenshots/"+TestName+".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
////		LocalDateTime d = LocalDateTime.now();
////		String dateTime = d.toString().replaceAll(" ", "_").replaceAll(":", "_");
////		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
////		File Temp = ts.getScreenshotAs(OutputType.FILE);
////		File dest=new File("./screenshots/"+TestName+""+dateTime+".png");
////		try {
////			FileHandler.copy(Temp, dest);
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}	

}