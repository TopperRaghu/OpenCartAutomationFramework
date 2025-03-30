package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Epic;

@Epic(value = "EPIC NO-100-Login test design")
public class LoginPageTest extends BaseTest{
	
	@Test
	public void loginPageTitleTest() {
		String actualTitle=lp.getPageTitle();
		Assert.assertEquals(actualTitle, "Account Login");
	}
	@Test
	public void loginPageUrlTest() {
		String actualurl=lp.getCurrentUrl();
		Assert.assertTrue(actualurl.contains("/opencart/index.php?route=account/login"));
	}
	
	@Test
	public void forgotPwdTest() {
		boolean cond=lp.forgetLinkDisplayed();
		Assert.assertTrue(cond);
	}
	@Test(priority = Integer.MAX_VALUE)
	public void doLoginTest()  {
		accs=lp.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		Assert.assertTrue(accs.verifyLogoutLinkExits());
	}
	
	
	
}
