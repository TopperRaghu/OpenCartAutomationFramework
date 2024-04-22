package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utility.ElementUtil;
import com.qa.opencart.constants.AppConstants;
        //whenever we are clicking on the button and it is landing on another new page 
	   //in such case its reponsibilty of current class to return the object of new landing 
	  //page 
public class LoginPage {
	public WebDriver driver;
	private ElementUtil eleUtil;
	// By locator

	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By forgetLink = By.linkText("Forgotten Password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By registerLink=By.linkText("Register");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil=new ElementUtil(driver);
	}

	public String getPageTitle() {
		String title =eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.LOGIN_PAGE_TITLE_VALUE);
		return title;
	}
   
	public String getCurrentUrl() {
		String url =driver.getCurrentUrl();
		return url;
	}
	
	public boolean forgetLinkDisplayed() {
		return driver.findElement(forgetLink).isDisplayed();
	}
	
	public AccountsPage doLogin(String un,String pwd) {
		eleUtil.doSendKeys(email, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}
	
	public RegistrationPage navigateToRegisterPage() {
		eleUtil.waitForElementVisible(registerLink, AppConstants.DEFAULT_SHORT_TIME_OUT).click();
		return new RegistrationPage(driver);
	}
}
