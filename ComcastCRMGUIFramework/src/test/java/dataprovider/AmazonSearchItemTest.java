package dataprovider;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class AmazonSearchItemTest {
	ExcelUtility elib=new ExcelUtility();
	static int j=1;
	@Test(dataProvider = "getData")
	public void SearchItemTest(String BrandName,String ModelName) throws IOException, Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(BrandName,Keys.ENTER);
		
		String x = "//span[text()='"+ModelName+"']/../../../..//span[@class='a-price-whole']";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
		elib.setDataIntoExcel("Product", j, 2, price);
		j++;
		
		driver.quit();
	}
	
	
	@DataProvider
	public Object[][] getData() throws Throwable{
	
		int rowCount = elib.getRowCount("Product");
		
		Object[][] obj=new Object[rowCount][2];
		
		for(int i=0;i<rowCount;i++) {
			obj[i][0]=elib.getDataFromExcel("Product", i+1, 0);
			obj[i][1]=elib.getDataFromExcel("Product", i+1, 1);
		}
		
		return obj;
	}
	

	
	
	//data's are hard coded, AT wont prefer Hard Coded Data
//	@DataProvider
//	public Object[][] getData(){
//		Object[][] obj=new Object[3][2];
//		obj[0][0]="iphone";
//		obj[0][1]="Apple iPhone 15 (128 GB) - Black";
//		
//		obj[1][0]="iphone";
//		obj[1][1]="Apple iPhone 13 (128GB) - Starlight";
//		
//		obj[2][0]="iphone";
//		obj[2][1]="Apple iPhone 13 (128GB) - Green";
//		
//		return obj;
//		
//	}
}
