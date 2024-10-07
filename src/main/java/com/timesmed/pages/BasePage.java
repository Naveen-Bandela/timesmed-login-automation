package com.timesmed.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class BasePage {
	
	private static final Logger logger = Logger.getLogger(BasePage.class.getName());
	
	protected AppiumDriver<WebElement> driver;
    protected WebDriverWait wait;

    public BasePage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
       // this.wait = new WebDriverWait(driver, 20);
    }

    // Common method to click elements
    public void clickOnElement(WebElement element) {
    	logger.info("Starting of clickOnElement Method ");
    	
        element.click();
        
        logger.info("Ending of clickOnElement Method ");
    }

    // Common method to enter text
    public void enterText(WebElement element, String text) {
    	logger.info("Starting of enterText Method ");
        element.clear();
        element.sendKeys(text);
        logger.info("Ending of enterText Method ");
    }
    

}
