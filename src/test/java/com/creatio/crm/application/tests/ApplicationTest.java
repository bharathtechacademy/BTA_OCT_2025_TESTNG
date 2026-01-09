package com.creatio.crm.application.tests;

import org.testng.annotations.Test;

public class ApplicationTest extends BaseTest {
	
	
	// Test Case 1: verify whether the cookies pop-up is displayed.
	@Test(priority=1)
	public void verifyCookiesPopupDisplayed() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
	}
	
	
	// Test Case 2: verify cookies pop-up content
	@Test(priority=2, dataProvider = "data")
	public void verifyCookiesPopupContent(String expectedContent) {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.verifyCookiesPopUpContentMessage(expectedContent);
	}
	
	// Test Case 3: verify cookies pop-up logos
	@Test(priority=3)
	public void verifyCookiesPopupLogos() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.verifyCookiesPopUpLogos();
	}
	
	// Test Case 4: verify cookie selection buttons
	@Test(priority=4)
	public void verifyCookieSelectionButtons() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.verifyCookieSelectionButtons();
	}
	
	// Test Case 5: verify cookie switch buttons
	@Test(priority=5)
	public void verifyCookieSwitchButtons() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.verifyCookieSwitchButtons();
	}
	
	// Test Case 6: verify show Details link displayed within the cookies pop-up along with expanded view.
	@Test(priority=6)
	public void verifyShowDetailsLinkAndExpandedView() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.clickOnShowDetailsLink();
		cookiesPage.verifyCookiesPopUpExpandedViewIsDisplayed();
	}
	
	// Test Case 7: verify cookies pop-up is getting closed on clicking "Allow All" button.
	@Test(priority=7)
	public void verifyCookiesPopupClosedOnAllowAll() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.ClickOnCookieSelectionButton("Allow All");
		cookiesPage.verifyCookiesPopUpIsDisappeared();
	}
	
	// Test Case 8: verify cookies pop-up is getting closed on clicking "deny" button.
	@Test(priority=8)
	public void verifyCookiesPopupClosedOnDeny() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.ClickOnCookieSelectionButton("Deny");
		cookiesPage.verifyCookiesPopUpIsDisappeared();
	}
	
	
	// Test Case 9: Verify sign-up link functionality with in the login page
	@Test(priority=9)
	public void verifySignUpLinkFunctionality() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.ClickOnCookieSelectionButton("Allow All");
		loginPage.verifyLoginPageDisplayed();
		loginPage.clickOnSignUpLink();
		signUpPage.verifySignUpPageIsLaunched();
	}
	
	// Test Case 10: Verify forgot password link functionality with in the login page
	@Test(priority=10, dataProvider = "data")
	public void verifyForgotPasswordLink(String email) {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.ClickOnCookieSelectionButton("Allow All");
		loginPage.verifyLoginPageDisplayed();
		loginPage.enterBusinessEmail(email);
		loginPage.verifyForgotPasswordLinkDisplayed();
		loginPage.clickOnForgotPasswordLink();
		loginPage.verifyResetPasswordConfirmationMessageDisplayed();
	}
	
	// Test case 11: Verify social media links displayed within the login page.
	@Test(priority=11)
	public void verifySocialMediaLinksDisplayedInLoginPage() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.ClickOnCookieSelectionButton("Allow All");
		loginPage.verifyLoginPageDisplayed();
		loginPage.verifySocialMediaLinksDisplayed();
	}
	
	// Test case 12: Verify login functionality with valid credentials.
	@Test(priority=12, dataProvider = "data")
	public void verifyLoginFunctionality(String businessEmail, String password) {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.ClickOnCookieSelectionButton("Allow All");
		loginPage.verifyLoginPageDisplayed();
		loginPage.enterBusinessEmailAndPassword(businessEmail, password);
		loginPage.clickOnLoginButton();
		homePage.verifyApplicationLandingPageIsDisplayed();
	}
	
	// Test Case 13: Verify logout functionality with valid credentials.
	@Test(priority=13, dataProvider = "data")
	public void verifyLogoutFunctionality(String businessEmail, String password) {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpIsDisplayed();
		cookiesPage.ClickOnCookieSelectionButton("Allow All");
		loginPage.verifyLoginPageDisplayed();
		loginPage.enterBusinessEmailAndPassword(businessEmail, password);
		loginPage.clickOnLoginButton();
		homePage.verifyApplicationLandingPageIsDisplayed();
		homePage.clickOnUserProfileIcon();
		homePage.clickOnLogoutButton();
		loginPage.verifyLoginPageDisplayed();
	}

}
