package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.LoginPageElements;

public class LoginPageSteps extends LoginPageElements{
	
	public LoginPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}	
	
	// Method to verify whether login page is displayed successfully.
	public void verifyLoginPageDisplayed() {
		waitForElement(loginPageHeader);
		log("info", "Login page is displayed successfully.");
	}
	
	// Method to enter Business email and password.
	public void enterBusinessEmailAndPassword(String businessEmail, String password) {
		waitForElement(businessEmailTextbox);
		enterText(businessEmailTextbox, businessEmail);
		log("info", "Entered business email: " + businessEmail);		
		waitForElement(passwordTextbox);
		enterText(passwordTextbox, password);
		log("info", "Entered password.");
	}
	
	// Method to enter business email.
	public void enterBusinessEmail(String businessEmail) {
		waitForElement(businessEmailTextbox);
		enterText(businessEmailTextbox, businessEmail);
		log("info", "Entered business email: " + businessEmail);		
	}
	
	// Method to click on the loginButton
	public void clickOnLoginButton() {
		waitForElement(loginButton);
		click(loginButton);
		log("info", "Clicked on the Login button.");
	}
	
	// Method to verify the forgotPasswordLink is displayed.
	public void verifyForgotPasswordLinkDisplayed() {
		waitForElement(forgotPasswordLink);
		log("info", "Forgot Password link is displayed successfully.");
	}
	
	// Method to verify sign-up link is displayed.
	public void verifySignUpLinkDisplayed() {
		waitForElement(signUpLink);
		log("info", "Sign Up link is displayed successfully.");
	}
	
	// Method to verify social media links displayed within the login page.
	public void verifySocialMediaLinksDisplayed() {
		waitForElement(linkedInIcon);
		log("info", "LinkedIn icon is displayed successfully.");
		waitForElement(googleIcon);
		log("info", "Google icon is displayed successfully.");
	}
	
	// Method to click on the sign up link.
	public void clickOnSignUpLink() {
		waitForElement(signUpLink);
		click(signUpLink);
		log("info", "Clicked on the Sign Up link.");
	}
	
	// Method to Click on the forgotPasswordLink
	public void clickOnForgotPasswordLink() {
		waitForElement(forgotPasswordLink);
		click(forgotPasswordLink);
		log("info", "Clicked on the Forgot Password link.");
	}
	
	// Method to verify reset password confirmation message is displayed.
	public void verifyResetPasswordConfirmationMessageDisplayed() {
		waitForElement(resetPasswordConfirmation);
		log("info", "Reset Password confirmation message is displayed successfully.");
	}

}
