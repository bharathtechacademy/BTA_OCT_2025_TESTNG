package com.creatio.crm.framework.reports;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	
	// This class will contain all the common methods to generate the report by using TestNG and ExtentReports
	public static ExtentHtmlReporter html;  //white paper
	public static ExtentReports extent;  //printer
	public static ExtentTest logger; //ink
	
	// Method to setup the report
	@BeforeSuite(alwaysRun = true)
	public static void setupReport() {
		html = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\AutomationTestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(html);
	}
	
	// Method to start the printing process.
	public static void startReporting(String testName) {
		logger = extent.createTest(testName);
	}
	
	// Method to end the printing process
	public static void endReport() {
		extent.flush();
	}
	
	// Method to print the messages
	public static void logMessage(String status, String message) {
		if(status.equalsIgnoreCase("pass")) {
			logger.pass(message);
		} else if(status.equalsIgnoreCase("fail")) {
			logger.fail(message);
		} else if(status.equalsIgnoreCase("info")) {
			logger.info(message);
		} else if(status.equalsIgnoreCase("warning")) {
			logger.warning(message);
		}
	}
	
	// Method to Attach screenshot within the report.
	public static void attachScreenshot(String screenshotPath) {
		try {
			logger.addScreenCaptureFromPath(screenshotPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
