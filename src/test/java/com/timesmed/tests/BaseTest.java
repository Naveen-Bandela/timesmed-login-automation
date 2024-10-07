package com.timesmed.tests;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;

import com.timesmed.utils.ConfigUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	
	
	private static final Logger logger = Logger.getLogger(BaseTest.class.getName());
	
	protected AppiumDriver<WebElement> driver=null;
	

    public void setup() throws MalformedURLException, URISyntaxException {
    	
    	logger.info("Starting of init MobileDriver in BaseTest"); 
    	
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid", ConfigUtils.getProperty("udid"));
        capabilities.setCapability("platformName", ConfigUtils.getProperty("platform.name"));
        capabilities.setCapability("platforVersion", ConfigUtils.getProperty("platform.version"));
        capabilities.setCapability("appPackage", ConfigUtils.getProperty("app.package"));
        capabilities.setCapability("appActivity", ConfigUtils.getProperty("app.activity"));
        capabilities.setCapability("deviceName", ConfigUtils.getProperty("device.name"));
        capabilities.setCapability("automationName", ConfigUtils.getProperty("automation.name"));
        
		/*
		 * URI uri = new URI(ConfigUtils.getProperty("appium.server.url")); this.url =
		 * uri.toURL(); driver = new AppiumDriver<MobileElement>(url, capabilities);
		 */
        driver = new AndroidDriver<WebElement>(new URL (ConfigUtils.getProperty("appium.server.url")), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        logger.info("Ending of init MobileDriver in BaseTest");
   
    }

	@AfterSuite
    public void teardown() {
		logger.info("Starting of quit MobileDriver in BaseTest"); 
		
        if (driver != null) {
            driver.quit();
        }
        logger.info("Ending of quit MobileDriver in BaseTest"); 
    }

}
