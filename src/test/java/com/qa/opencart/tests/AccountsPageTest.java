package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest{
  SoftAssert sfa=new SoftAssert();
  
	@BeforeClass
	public void loginPageTest() {
		accs=lp.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	
	@Test
	public void accountPageTitle() {
		String actualTitleText=accs.accountPageTitle();
		System.out.println(actualTitleText);
		Assert.assertEquals(actualTitleText, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
		//sfa.assertEquals(actualTitleText, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void accountPageUrlTest() {
		String actualUrl=accs.accountPageUrl();
		Assert.assertTrue(actualUrl.contains(AppConstants.ACCOUNTS_PAGE_URL_FRACTION_VALUE));
	}
	@Test
	public void searchBoxTest() {
		boolean srch=accs.verifySearchBoxExits();
		Assert.assertTrue(srch);
		
	}
	@Test
	public void logoTest() {
		boolean logo=accs.verifyLogoExists();
		Assert.assertTrue(logo);
	}
	
	@Test
	public void infoListTest() {
		List<String>allinfoLinks=accs.verifyInfoList();
		System.out.println(allinfoLinks.size());
		Assert.assertEquals(allinfoLinks.size(), AppConstants.ACCOUNTS_PAGE_HEADER_COUNT);
	}
	
	@Test
	public void infoListValueTest() {
		List<String>allinfoLinks=accs.verifyInfoList();
		Assert.assertEquals(allinfoLinks, AppConstants.EXPECTED_ACCOUNT_HEADER_LIST);
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
	public void searchTest(String searchKey,String productName,int imageNo) {
		searchPage=accs.performSearch(searchKey);
		searchPage.selectTheProduct(productName);
		searchPage.getSearchProductCount();
		Assert.assertTrue(searchPage.getSearchProductCount()>0);
		Assert.assertEquals(productInfoPage.getAllTheProdImage(), imageNo);
		
	}
}
