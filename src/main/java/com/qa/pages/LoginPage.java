package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Username']" )
	WebElement userNameField;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordField;

	@FindBy(xpath = "//input[@id='chkboxOne']")
	WebElement checkBoxOne;

	@FindBy(xpath = "//input[@id='chkboxTwo']")
	WebElement checkBoxTwo;

	@FindBy(xpath = "//form[@class='form']//button[1]")
	WebElement signButton;
	
	@FindBy(xpath = "//form[@class='form']//p[1]")
	WebElement incorrectFieldMsg;
	
	//successful submit
	@FindBy(xpath = "//form[@class='form']//button[1]")
	WebElement submitButton;
	
	//successful msg
	 @FindBy(tagName = "p")
	 WebElement successfulLoginText;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserNameField (String userNameText) {
		userNameField.sendKeys(userNameText);
	}
	public void enterPasswordField (String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	public void clickCheckBoxOne () {
		checkBoxOne.click();
	}
	public void clickCheckBoxTwo () {
		checkBoxTwo.click();
	}
	public  void clickSignButton () {
		 signButton.click();
	}

    public String incorrectMsg() {
    	return incorrectFieldMsg.getText();
    }

    
   // successful submit
    public void clickSubmitButton() {
    submitButton.click();
    }
 
    public String successfullyLoginText() {
    	return successfulLoginText.getText();
    }
 






}
