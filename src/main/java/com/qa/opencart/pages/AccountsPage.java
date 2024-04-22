package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utility.ElementUtil;
import com.qa.opencart.constants.AppConstants;

public class AccountsPage {
	public WebDriver driver;
	private ElementUtil eleUtil;

	private By infoList = By.xpath("//div[@id='content']//h2");
	//private By searchBox = By.xpath("//input[@name='search']");
	private By cart = By.id("cart");
	private By logo = By.xpath("//img[@title='naveenopencart']");
	private By logout = By.xpath("//*[@id='column-right']/div/a[13]");
	private By search = By.xpath("//input[@name='search']");
	private By srchBtn = By.cssSelector("#search button");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil=new ElementUtil(driver);
	}

	public String accountPageTitle() {
		// String title = driver.getTitle();
		String title = eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, "My Account");
		return title;
	}

	public String accountPageUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public boolean verifyLogoExists() {
		// return driver.findElement(logo).isDisplayed();
		return eleUtil.doElementIsDisplayed(logo);
	}

	public boolean verifySearchBoxExits() {
		return eleUtil.waitForElementPresence(search, AppConstants.DEFAULT_SHORT_TIME_OUT).isDisplayed();
	}

	public boolean verifyCartExits() {
		return driver.findElement(cart).isDisplayed();
	}

	public boolean verifyLogoutLinkExits() {
		return driver.findElement(logout).isDisplayed();
	}

	public List<String> verifyInfoList() {
		List<WebElement> inform = driver.findElements(infoList);
		List<String> infodetail = new ArrayList<String>();
		for (WebElement e : inform) {
			String text = e.getText();
			infodetail.add(text);
		}
		return infodetail;
	}

	public SearchPage performSearch(String searchKey) {
		if (verifySearchBoxExits()) {
			//eleUtil.waitForElementsVisible(search, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
			eleUtil.doSendKeys(search, searchKey);
			eleUtil.doClick(srchBtn);
			return new SearchPage(driver);
		} else {
			System.out.println("Search page is not present......");
			return null;
		}

	}

}
