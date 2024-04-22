package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public Properties prop;
	public OptionManager optionManger;
	public static String highlight;
	public static ThreadLocal<WebDriver>tldriver=new ThreadLocal<WebDriver>();
	/**
	 * 
	 * @param browserName
	 * @return
	 */

	public WebDriver initBrowser(Properties prop) {
		optionManger=new OptionManager(prop);
		highlight=prop.getProperty("highlight").trim();
		String browserName =prop.getProperty("browser").toLowerCase().trim();
		System.out.println("Broswer name is::" + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromiumdriver().setup();
			//driver = new ChromeDriver(optionManger.getChromeOption());
			tldriver.set(new ChromeDriver(optionManger.getChromeOption()));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionManger.getFirefoxOption());
			tldriver.set(new FirefoxDriver(optionManger.getFirefoxOption()));
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver(optionManger.getEdgeOption())
					;// session ID is created example:-123fjjhfd
			//driver = new EdgeDriver();
			tldriver.set(new EdgeDriver(optionManger.getEdgeOption()));
		} else {
			System.out.println("Plz pass the right browser name::" + browserName);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url").trim());
	    return getDriver();
		//return driver;
	    // and here driver is returned with same session ID which is created
	    // example:-123fjjhfd
	    // this is called page chaining
	}
	
	
	public static synchronized WebDriver getDriver() {
		 return tldriver.get();
	}
	
	/**
	 * 
	 * @return
	 */

	public Properties initProp() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	/**
	 * take screenshot
	 */
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}


}
