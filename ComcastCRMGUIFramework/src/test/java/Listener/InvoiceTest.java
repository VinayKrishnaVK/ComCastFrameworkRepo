package Listener;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

@Listeners(com.comcast.crm.listenerUtility.ListenerImpClass.class)
public class InvoiceTest extends BaseClass{

	@Test
	public void createInvoiceTest() {
		System.out.println("===execute CreateInvoiceTest===");
		String ActTitle = driver.getTitle();
		System.out.println(ActTitle);
		Assert.fail();
		Assert.assertEquals(ActTitle, "virat");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
		
	}
	@Test
	public void createInvoiceWithPhoneTest() {
		System.out.println("===execute CreateInvoiceWithPhoneTest===");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
		
	
	}
}
