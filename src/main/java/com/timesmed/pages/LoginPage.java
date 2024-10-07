package com.timesmed.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class LoginPage extends BasePage {
	
	private static final Logger logger = Logger.getLogger(LoginPage.class.getName());
	
	@FindBy(xpath = "//android.view.View[@content-desc='LOGIN']")
	private WebElement lblLogin;

	@FindBy(xpath = "//android.widget.EditText[@resource-id='']")
	private WebElement txtPhoneNumber;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=''][2]")
	private WebElement txtPassword;

	@FindBy(xpath = "//android.widget.Button[@content-desc='Login']")
	private WebElement btnLogin;
	

	public LoginPage(AppiumDriver<WebElement> driver) {
		super(driver);
		 PageFactory.initElements(driver, this);
	}
	
	public String getLoginLabel(String lblLogin) {
		logger.info("Starting of getLoginLabel Method");
		logger.info("Starting of getLoginLabel Method");
	
		return lblLogin;
	}

	public void setPhoneNumber(String phoneNumber) {
		logger.info("Starting of setPhoneNumber Method");

		this.clickOnElement(txtPhoneNumber);
		this.enterText(txtPhoneNumber, phoneNumber);

		logger.info("Ending of setPhoneNumber Method");
	}

	public void setPassword(String password) {
		logger.info("Starting of setPassword Method");

		this.clickOnElement(txtPassword);
		this.enterText(txtPassword, password);

		logger.info("Ending of setPassword Method");

	}

	public void clickonLoginButton() {
		logger.info("Starting of clickonLoginButton Method");
		
		driver.hideKeyboard();
	
		this.clickOnElement(btnLogin);

		logger.info("Ending of clickonLoginButton Method");

	}

}
