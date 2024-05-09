package screenshots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenshotMethod2 {

	@Test
	public void TakeSSTest() throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File Temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/img02.png");
		FileHandler.copy(Temp, dest);
		
	}
}

