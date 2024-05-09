package CreateOrgUsingPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class OrgPage {

	public OrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement PlusBtn;

	@FindBy(name="search_text")
	private WebElement SearchFor;
	
	@FindBy(name="search_field")
	private WebElement SearchIn;
	
	@FindBy(name="submit")
	private WebElement SubmitBtn;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement DeleteBtn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
	private WebElement HomeBtn;
	
	
	public WebElement getSearchFor() {
		return SearchFor;
	}


	public WebElement getSearchIn() {
		return SearchIn;
	}


	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}


	public WebElement getPlusBtn() {
		return PlusBtn;
	}
	public WebElement getDeleteBtn() {
		return DeleteBtn;
	}
	public void SearchNow(String name) {
		SearchFor.sendKeys(name);
		Select sel=new Select(SearchIn);
		sel.selectByVisibleText("Organization Name");
		SubmitBtn.click();
	}
	
	public void Delete(WebDriver driver,String name) throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='"+name+"']/./../..//input[@type='checkbox']")).click();
		DeleteBtn.click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		HomeBtn.click();
	}
	



	
	
	
	
}
