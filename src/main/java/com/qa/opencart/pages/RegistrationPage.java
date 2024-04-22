package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utility.ElementUtil;
import com.qa.opencart.constants.AppConstants;

public class RegistrationPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

	private By subscribeYes = By.xpath("//label[normalize-space()='Yes']/input[@type='radio']");
	private By subscribeNo = By.xpath("//label[normalize-space()='No']/input[@type='radio']");

	private By registerSuccessMesg = By.cssSelector("div#content h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public boolean doTheRegistration(String firstName, String lastName, String email, String telephone, String password,
			String subscribe) {
		eleUtil.waitForElementVisible(this.firstName, AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(confirmpassword, password);
		if (subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doActionsCick(subscribeYes);
		} else {
			eleUtil.doActionsCick(subscribeNo);

		}
		String success_Mgs = eleUtil.waitForElementVisible(registerSuccessMesg, AppConstants.DEFAULT_SHORT_TIME_OUT)
				.getText();
		if (success_Mgs.contains(AppConstants.USER_REG_SUCCESS_MESSG)) {
			 eleUtil.doClick(agreeCheckBox);
		     eleUtil.doActionsCick(continueButton);
			return true;
		} else {
           return false;
		}
	}

}
