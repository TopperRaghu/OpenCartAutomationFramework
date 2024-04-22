package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchPage;

public class BaseTest {
	DriverFactory df;
	WebDriver driver;
	protected Properties prop;
	protected LoginPage lp;
	protected AccountsPage accs;
	protected SearchPage searchPage;
	protected ProductInfoPage productInfoPage;
	protected RegistrationPage registrationPage;
	//why am i maintain all the pages object in Base Test
   //Because this parent class for all the test Pages and what if we need login page and account page 
  // for other pages 
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop=df.initProp();
	    driver=df.initBrowser(prop);
	    lp=new LoginPage(driver);
	    
	}

	@AfterTest
	public void tearDown() {
        driver.quit();
	}

}
