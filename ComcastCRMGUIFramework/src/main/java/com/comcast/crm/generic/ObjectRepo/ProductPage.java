package com.comcast.crm.generic.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {

	@FindBy(xpath = "//img[@alt=\"Create Product...\"]")
	private WebElement ProdPlusBtn;
	
	@FindBy(xpath = "//img[@alt='Open Calendar...']")
	private WebElement CalenderBtn;

	public WebElement getCalenderBtn() {
		return CalenderBtn;
	}

	public WebElement getProdPlusBtn() {
		return ProdPlusBtn;
	}
}
