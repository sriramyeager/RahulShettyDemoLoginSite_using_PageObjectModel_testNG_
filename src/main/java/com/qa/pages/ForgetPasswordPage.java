package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPage {

	WebDriver driver;

	@FindBy(linkText = "Forgot your password?")
	WebElement forgetPasswordLink;

	@FindBy(xpath = "//input[@placeholder='Name']" )
	WebElement userNameField;

	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement userEmailField;

	@FindBy(xpath = "//input[@placeholder='Phone Number']")
	WebElement userPhoneNumberField;

	@FindBy(className = "reset-pwd-btn")
	WebElement resetPasswordBtn;

	@FindBy(css = "p.infoMsg")
	WebElement infoMsg;

	@FindBy(css = ".go-to-login-btn")
	WebElement loginBtn;


	public ForgetPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void clickForgetPasswordLink() {
		forgetPasswordLink.click();
	}

	/*public void enterUserNameField(String userNameText) {
		userNameField.sendKeys(userNameText);
	}
	public void enterEmailField(String userEmailText) {
		userEmailField.sendKeys(userEmailText);
	}
	public void enterPhoneNumberField(String userPhoneText) {
		userPhoneNumberField.sendKeys(userPhoneText);
	}
	public void resetPasswordButton() {
		resetPasswordBtn.click();
	}*/
	public void forgetPasswordPageLogin(String userNameText, String userEmailText, String userPhoneText) {
		userNameField.sendKeys(userNameText);
		userEmailField.sendKeys(userEmailText);
		userPhoneNumberField.sendKeys(userPhoneText);
		resetPasswordBtn.click();
	}
	
	//get Info Message
	public String getTemporaryPwdText() {
		return infoMsg.getText();
	}

	//go to login page
	public void goToLoginBtn() {
		loginBtn.click();
	}






}
