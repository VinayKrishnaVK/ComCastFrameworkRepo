package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchTabURL(WebDriver driver, String partialURL) {
		Set<String> windowId = driver.getWindowHandles();
		for (String Wid : windowId) {
			driver.switchTo().window(Wid);
			String CurrectURL = driver.getCurrentUrl();
			if (CurrectURL.contains(partialURL)) {
				System.out.println("===Window switched===");
				break;
			}
		}

	}

	public void switchTabTitle(WebDriver driver, String partialTitle) {
		Set<String> windowId = driver.getWindowHandles();
		for (String Wid : windowId) {
			driver.switchTo().window(Wid);
			String CurrectURL = driver.getTitle();
			if (CurrectURL.contains(partialTitle)) {
				System.out.println("===Window switched===");
				break;
			}
		}
	}
	public void switchtoFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchtoFrame(WebDriver driver,String nameID) {
		driver.switchTo().frame(nameID);
	}
	public void switchtoFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchtoAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchtoAlertCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();;
	}
	public void select(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void select(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void mousemoveOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public static void takeScreenShot(WebDriver driver,String path)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/"+path+".png");
		try {
			FileHandler.copy(Temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
