package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class ScreenshotMethod1 {

	
	@Test
	public void TakeScreenShotTest() throws IOException {
		
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			
			//create An Object to EventFiring WebDriver
			EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
			
			//use getScreenshotAs method to get file type of screenshot
			File srcFile = edriver.getScreenshotAs(OutputType.FILE);
			
			//store screenshot on local driver
			File destFile=new File("./screenshots/img01.png");
			FileUtils.copyFile(srcFile, destFile);
			
		

	}
}
