package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Epic;

@Epic(value = "EPIC NO-100-Login test design")
public class LoginPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualTitle=lp.getPageTitle();
		Assert.assertEquals(actualTitle, "Account Login");
	}
	@Test(priority = 2)
	public void loginPageUrlTest() {
		String actualurl=lp.getCurrentUrl();
		Assert.assertTrue(actualurl.contains("/opencart/index.php?route=account/login"));
	}
	
	@Test(priority = 3)
	public void forgotPwdTest() {
		boolean cond=lp.forgetLinkDisplayed();
		Assert.assertTrue(cond);
	}
	@Test(priority = 4)
	public void doLoginTest()  {
		accs=lp.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		Assert.assertTrue(accs.verifyLogoutLinkExits());
	}
	
	
	
}
