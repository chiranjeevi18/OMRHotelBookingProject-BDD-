package com.amazon.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BaseClass;

public class ProductSearchPage extends BaseClass{
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	public ProductSearchPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchBox() {
		return searchBox;
	}
	
	public void searchingProduct(String product) {
		sendkeys(getSearchBox(), product);
	}
	
}
