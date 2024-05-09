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

	@FindBy(name = "search_text")
	private WebElement SearchField;
	
	
	
	public WebElement getSearchField() {
		return SearchField;
	}

	public WebElement getProdPlusBtn() {
		return ProdPlusBtn;
	}
}
