
package com.Utilities;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {
	private static HelperClass helperClass ;
	private static WebDriver driver ;
	private static WebDriverWait wait ;
	private static final int TIMEOUT = 10;
	public static final Logger logger = LogManager.getLogger(HelperClass.class);
	
	HelperClass(){
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		wait = new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT));
		driver.manage().window().maximize();
		
	}
	public static void openWebPage(String url) {
		logger.info("Opening Web Browser");
		driver.get(url);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setUpDriver() {
		if(helperClass == null) {
			helperClass = new HelperClass();
		}
	}
	
	public static void TearDown() {
		if(driver != null) {
			logger.info("Closing Web Browser");
			driver.close();
			driver.quit();
		}
		helperClass = null;
	}
}
