package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utility.ElementUtil;
import com.qa.opencart.constants.AppConstants;

public class SearchPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
   //private By prodName=By.xpath("//a[text()='MacBook Air']");
   private By totalProd=By.cssSelector("div#product-search div.product-layout");

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		eleUtil=new ElementUtil(driver);
	}
	
	public int getSearchProductCount() {
		return eleUtil.waitForElementsVisible(totalProd, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
	}
	
	public ProductInfoPage selectTheProduct(String productName) {
		By productLocator = By.linkText(productName);
		eleUtil.waitForElementVisible(productLocator, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
		return new ProductInfoPage(driver);
	}

}
