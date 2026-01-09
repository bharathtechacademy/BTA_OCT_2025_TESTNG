package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.SignUpPageElements;

public class SignUpPageSteps extends SignUpPageElements {
	
	public SignUpPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Method to verify sign-up page is launched.
	public void verifySignUpPageIsLaunched() {
		String currentUrl = getCurrentURL();
		Assert.assertTrue(currentUrl.contains("registration"), "Sign-Up page is not launched successfully.");
		log("info", "Sign-Up page is launched successfully.");
	}

}
