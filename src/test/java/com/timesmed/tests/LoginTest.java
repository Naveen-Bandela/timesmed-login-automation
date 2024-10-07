package com.timesmed.tests;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.timesmed.pages.LoginPage;
import com.timesmed.utils.ExpectedUtils;
import com.timesmed.utils.TestDataUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class LoginTest extends BaseTest {
	
	
	private static final Logger logger = Logger.getLogger(LoginTest.class.getName());
	 LoginPage loginPage=null;

	 @BeforeClass
	 public void initMobileDriver() throws MalformedURLException, InterruptedException, URISyntaxException {
		 
		 logger.info("Starting of initMobileDriver Method in LoginTest ");
		 
	     setup();
	     loginPage = new LoginPage(driver);
	     logger.info("Ending of initMobileDriver Method in LoginTest ");
	     
	     Thread.sleep(2000);
	 }
		 
	@Test(priority = 1)
	@Description("Verify the Login functionality with Valid credentials")
	@Severity(SeverityLevel.BLOCKER)
	public void VerifyLogin() throws Exception {

		logger.info("Starting of VerifyLogin Method ");
		

		try {

			loginPage.getLoginLabel(ExpectedUtils.getExpectedData("login.page"));

			loginPage.setPhoneNumber(TestDataUtils.getTestData("login.phonenumber"));

			loginPage.setPassword(TestDataUtils.getTestData("login.password"));
			
			driver.hideKeyboard();

			loginPage.clickonLoginButton();

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Ending of VerifyLogin Method");

	}
}
