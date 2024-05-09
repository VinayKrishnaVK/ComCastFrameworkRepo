package CreateOrgUsingPOM;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateOrgTest {
	
	
	@Test
	public void OrgTest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		
		//random
		Random value=new Random();
		int RanValue = value.nextInt(2000);
		
		//utilization
		LoginPage lp=new LoginPage(driver);
		lp.loginBtn("admin", "admin");
		
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrg().click();
		
		NewOrgPage np=new NewOrgPage(driver);
		String OrganisationName = "facebook"+RanValue;
		np.SavePage("facebook"+RanValue);
		
		Thread.sleep(2000);
		OrgInfoPage ip=new OrgInfoPage(driver);
		String info = ip.getInfo().getText();
		if(info.contains(OrganisationName)) {
			System.out.println("====verified===");
		}
		else {
			System.out.println("=======not verified=====");
		}
		
		hp.SignOut(driver);
	}
	
}
