package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.CookiesPageElements;

public class CookiesPageSteps extends CookiesPageElements {

	public CookiesPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Method to verify cookies pop-up is getting displayed.
	public void verifyCookiesPopUpIsDisplayed() {
		waitForElement(cookiesHeader);
		log("info", "Cookies pop-up is displayed successfully.");
	}

	// Method to verify cookies pop-up content message.
	public void verifyCookiesPopUpContentMessage(String expectedMessage) {
		waitForElement(cookiesContent);
		String actualMessage = getElementText(cookiesContent).trim();
		Assert.assertEquals(actualMessage, expectedMessage, "Cookies pop-up content message is not as expected.");
		log("info", "Cookies pop-up content message is displayed as expected.");
	}
	
	// Method to verify cookies pop-up logos.
	public void verifyCookiesPopUpLogos() {
		waitForElement(creatioLogo);
		waitForElement(cookieBotLogo);
		log("info", "Cookies pop-up logos are displayed successfully.");
	}
	
	// Method to Verify Cookie Selection Buttons
	public void verifyCookieSelectionButtons() {
		waitForElement(allowAllButton);
		waitForElement(allowSelectionButton);
		waitForElement(denyButton);
		log("info", "Cookie selection buttons are displayed successfully.");
	}
	
	// Method to Verify Cookie Switch Buttons
	public void verifyCookieSwitchButtons() {
		waitForElement(necessarySwitchButton);
		waitForElement(preferencesSwitchButton);
		waitForElement(statisticsSwitchButton);
		waitForElement(marketingSwitchButton);
		log("info", "Cookie switch buttons are displayed successfully.");
	}
	
	// Method to verify show details link.
	public void verifyShowDetailsLink() {
		waitForElement(showDetailsLink);		
		log("info", "Show details link is displayed successfully.");
	}
	
	// Method to click on the "Show Details" link.
	public void clickOnShowDetailsLink() {
		waitForElement(showDetailsLink);
		click(showDetailsLink);
		log("info", "Clicked on the 'Show Details' link successfully.");
	}
	
	// Method to verify: Cookies pop up, expanded view is displayed.
	public void verifyCookiesPopUpExpandedViewIsDisplayed() {
		waitForElement(cokkiesPopUpExpandedView);		
		log("info", "Cookies pop up, expanded view is displayed successfully.");
	}
	
	// Method to Select the cookies by using the allowSelectionButton.
	public void ClickOnCookieSelectionButton(String buttonName) {
		waitForElement(allowSelectionButton);
		switch (buttonName.toLowerCase()) {
		case "allow selection":
			click(allowSelectionButton);
			log("info", "Clicked on the 'Allow Selection' button successfully.");
			break;
		case "allow all":
			click(allowAllButton);
			log("info", "Clicked on the 'Allow All' button successfully.");
			break;
		case "deny":
			click(denyButton);
			log("info", "Clicked on the 'Deny' button successfully.");
			break;
		default:
			Assert.fail("Invalid button name provided: " + buttonName);
		}
		log("info", "Clicked on the '" + buttonName + "' button successfully.");
	}
	
	// Method to verify: The cookie's pop-up is disappeared from the page.
	public void verifyCookiesPopUpIsDisappeared() {
		waitForElementToDisappear(cookiesHeader);
		log("info", "Cookies pop-up is disappeared from the page successfully.");
	}

}
