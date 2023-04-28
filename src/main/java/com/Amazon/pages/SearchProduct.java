package com.Amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct extends BasePage {

	// Design pattern - page factory

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchbox;

	@FindBy(id = "searchDropdownBox")
	private WebElement searchDropdownbox;

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchButton;

	@FindBy(xpath = "(//div[@data-component-type='s-search-result'])[1]")
	private WebElement firstProduct;

	public SearchProduct(WebDriver driver) {

		super(driver);

		PageFactory.initElements(driver, this);

	}

	public void searchProduct(String product, String category) {

		elementControl.typeText(searchbox, product);

		dropdownControl.selectViaVisibleText(searchDropdownbox, category);

		elementControl.clickElement(searchButton);

	}

	public String getProductInfo() {
		return elementControl.getText(firstProduct);

	}

}
