package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utility.ElementUtil;
import com.qa.opencart.constants.AppConstants;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	// div#content ul li img
	private By productImage = By.xpath("//div[@id='content']//ul/li//img");
	private By productInfo = By.xpath("(//div[@class='col-sm-4']//ul)[position()=1]/li");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public int getAllTheProdImage() {
		List<WebElement> allprodImage = eleUtil.waitForElementsVisible(productImage,
				AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		int imageCount = allprodImage.size();
		return imageCount;
	}

	public Map<String, String> productMetaData() {
		Map<String, String> allMetaInfo = new LinkedHashMap<String, String>();
		List<WebElement> proddata = eleUtil.getElements(productInfo);
		for (WebElement e : proddata) {
			String dataHeader = e.getText().trim().split(":")[0];
			String infoCell = e.getText().trim().split(":")[1];
			allMetaInfo.put(dataHeader, infoCell);
		}
		System.out.println(allMetaInfo);
		return allMetaInfo;
	}

}
