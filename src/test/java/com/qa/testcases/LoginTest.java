package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.base;
import com.qa.pages.ForgetPasswordPage;
import com.qa.pages.LoginPage;


public class LoginTest extends base {

	public LoginTest() {
		super();
	}

	WebDriver driver;
	LoginPage loginPage;

	@BeforeTest
	public void setUp() {
		
		driver = intializeBrowserAndOpenApplication(prop.getProperty("browserName"));
	}

	//inValidSign start
	@Test(priority = 0)
	public void verifyWithInvalidCredentials() {
		loginPage = new LoginPage(driver);
		loginPage.enterUserNameField(prop.getProperty("invalidUserName"));
		loginPage.enterPasswordField(prop.getProperty("invalidPassword"));
		loginPage.clickCheckBoxOne();
		loginPage.clickCheckBoxTwo();
        loginPage.clickSignButton();

		String actualMsg = loginPage.incorrectMsg();
		Assert.assertEquals(actualMsg, prop.getProperty("incorrectUsernameandPasswordIsDisplayed"),"incorrect username and password not displayed");
	}
	//forgetPasswordPage
	@Test(priority = 1)
	public void verifyTheForgetPasswordCredntials(){
		ForgetPasswordPage  forgetPwdPage = new ForgetPasswordPage(driver);
		forgetPwdPage.clickForgetPasswordLink();
		forgetPwdPage.forgetPasswordPageLogin(prop.getProperty("userName"), prop.getProperty("email"), prop.getProperty("phoneNumber"));
		String actualMsg =forgetPwdPage.getTemporaryPwdText();
		Assert.assertEquals(actualMsg, prop.getProperty("temporaryPasswordIsDisplayed"),"temporary password is not matched");

		forgetPwdPage.goToLoginBtn();

	}
	@Test(priority = 2)
	public void verifyWithValidCredentials() {
		loginPage.enterUserNameField(prop.getProperty("validUserName"));
		loginPage.enterPasswordField(prop.getProperty("validPassword"));
		//loginPage.clickCheckBoxOne();
		//loginPage.clickCheckBoxTwo();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		loginPage.clickSubmitButton();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String actualSuccessMsg = loginPage.successfullyLoginText();
		Assert.assertEquals(actualSuccessMsg, prop.getProperty("successFullyMsgIsDisplayed"), "successful message is not displayed");

	}

    @AfterTest
	public void tearDown() {
		driver.quit();
	}





}

