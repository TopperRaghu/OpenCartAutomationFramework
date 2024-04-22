package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest{
	
	@BeforeClass
	public void loginPageTest() {
		accs=lp.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{"Macbook","MacBook Air",4},
			{"Imac","iMac",3},
			{"IPhone","iPhone",6}
		};
	}
	
	@Test(dataProvider = "getSearchData")
	public void ProductMetaDataTest(String product,String productName,int imageNo) {
		searchPage=accs.performSearch(product);
		productInfoPage=searchPage.selectTheProduct(productName);
		//searchPage.getSearchProductCount();
		Assert.assertEquals(productInfoPage.getAllTheProdImage(), imageNo);
		productInfoPage.productMetaData();
		
	}
	
}