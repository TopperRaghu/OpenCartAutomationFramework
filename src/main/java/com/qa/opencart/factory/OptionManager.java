package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;

	public OptionManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOption() {
		co = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
			System.out.println("Running chrome in headless");
			co.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			System.out.println("Running chrome in incognito");
			co.addArguments("--incognito");
		return co;
	}

	public EdgeOptions getEdgeOption() {
		eo = new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
			System.out.println("Running edge in headless");
			eo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			System.out.println("Running edge in incognito");
			eo.addArguments("--incognito");
		return eo;
	}

	public FirefoxOptions getFirefoxOption() {
		fo = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
			System.out.println("Running firefox in headless");
			fo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			System.out.println("Running firefox in incognito");
			fo.addArguments("--incognito");
		return fo;
	}

}
