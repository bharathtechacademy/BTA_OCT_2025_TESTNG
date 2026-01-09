package com.creatio.crm.framework.web.commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.constants.Web;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.utilities.PropUtil;

public class WebCommons {
	
	// This class will contain all the common methods related to UI automation using Selenium.
	public WebDriver driver = BasePage.getDriver();
	public Properties prop = PropUtil.readData("Config.properties");
	
	//Common method to launch the application and verify the title of the application.
	public void launchApplication() {
		driver.get(prop.getProperty("APP_URL"));
		wait(2);
		String expectedTitle = prop.getProperty("APP_TITLE");
		String actualTitle = driver.getTitle();
		if(!actualTitle.contains(expectedTitle)) {			
			Assert.fail("Application title verification failed. Expected: " + expectedTitle + ", but got: " + actualTitle);
		}
	}
	
	//Common method to scroll to the element.
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	// Common method to Click on the element.
	public void click(WebElement element) {
		scrollToElement(element);
		element.click();
	}
	
	// Common method to Click on the hidden element.
	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	// Common method to perform double-click on the element.
	public void doubleClick(WebElement element) {
		scrollToElement(element);
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	// Common method to perform right-click on the element.
	public void rightClick(WebElement element) {
		scrollToElement(element);
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	// Common method to perform hover on the element.
	public void mouseHover(WebElement element) {
		scrollToElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	//Common method to enter the text into text field.
	public void enterText(WebElement element, String text) {
		scrollToElement(element);
		element.clear();
		element.sendKeys(text);
	}
	
	// Common method to select the checkbox.
	public void selectCheckbox(WebElement element, boolean status) {
		scrollToElement(element);
		if(element.isSelected()!=status) {
			element.click();
		}
	}
	
	// Common method to select the option from drop-down.
	public void selectDropdownOption(WebElement dropdown, String option, String selectBy) {
		scrollToElement(dropdown);
		Select select = new Select(dropdown);
		switch(selectBy.toLowerCase()) {
			case "value":
				select.selectByValue(option);
				break;
			case "visibletext":
				select.selectByVisibleText(option);
				break;
			case "index":
				select.selectByIndex(Integer.parseInt(option));
				break;
			default:
				Assert.fail("Invalid selectBy option: " + selectBy);
		}
	}
	
	// Common method to get the text of the element.
	public String getElementText(WebElement element) {
		scrollToElement(element);
		return element.getText();
	}
	
	// Common method to get the attribute value of the element.
	public String getElementAttribute(WebElement element, String attribute) {
		scrollToElement(element);
		return element.getAttribute(attribute);
	}
	
	// Common method to get the current URL.
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	// Common method to refresh the page.
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	// Common method to verify element display status.
	public boolean isElementDisplayed(WebElement element) {
		try {
			scrollToElement(element);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	// Common method to verify element enabled status.
	public boolean isElementEnabled(WebElement element) {
		try {
			scrollToElement(element);
			return element.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}
	
	// Common method to wait by using Java wait.
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Common method to wait for the element.
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Web.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	// Common method to wait for the element.
	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Web.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}
	
	// Common method Wait until element is disappeared.
	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Web.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}	
	
	// Common method to switch to frame by WebElement.
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// Common method to switch to frame by name or id.
	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	// Common method to switch back to the default content from the frame.
	public void switchToMainWindow() {
		driver.switchTo().defaultContent();
	}
	
	//	Common method to capture the screenshot of entire browser window.
	public static String getWindowScreenshot(WebDriver driver, String screenshotName) {
		String filePath = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + ".png";
		try {
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}

	//	Common Method to Capture screenshot of web element.
	public static String getElementScreenshot(WebElement element, String screenshotName) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + ".png";
		try {
			File screenshotFile = element.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}
	
	// Common method to switch to the alert.
	public Alert getAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}
	
	// Common method to accept /dismiss the alert.
	public void handleAlert(boolean accept) {
		Alert alert = getAlert();
		if(accept) {
			alert.accept();
		} else {
			alert.dismiss();
		}
	}
	
	// Method to print the messages
	public static void log(String status, String message) {
		if (status.equalsIgnoreCase("pass")) {
			Reports.logger.pass(message);
		} else if (status.equalsIgnoreCase("fail")) {
			Reports.logger.fail(message);
		} else if (status.equalsIgnoreCase("info")) {
			Reports.logger.info(message);
		} else if (status.equalsIgnoreCase("warning")) {
			Reports.logger.warning(message);
		}
	}
}
