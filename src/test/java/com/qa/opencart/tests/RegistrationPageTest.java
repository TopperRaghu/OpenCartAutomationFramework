package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass

	public void registrationLinkTest() {
		registrationPage = lp.navigateToRegisterPage();
	}

	@DataProvider

	public Object[][] registrationData() {
		return new Object[][] {
			{"Ragha","Pat","Raggha@gmail.com","9008080579","Patt@123","no"},
		};
	}
	
	@Test(dataProvider = "registrationData")
	public void registrationTest(String firstName, String lastName, String email,
			String telephone, String password,
			String subscribe){
		//boolean doRegis=registrationPage.doTheRegistration(firstName, lastName, email, telephone, password, subscribe);
	  //  Assert.assertTrue(doRegis);
	}
}
