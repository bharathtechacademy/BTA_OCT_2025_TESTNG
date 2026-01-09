package com.creatio.crm.framework.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.web.commons.WebCommons;

public class TestListeners extends Reports implements ITestListener {

	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		startReporting(testName);
		logger.info("Execution started for Test Case: " + testName);
	}

	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		logger.pass("Execution is Successfully Completed for Test Case: " + testName);
		 endReport();		
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		logger.fail("Execution is Failed for Test Case: " + testName);
		logger.fail("Failure Reason: " + result.getThrowable().getMessage());
		attachScreenshot(WebCommons.getWindowScreenshot(BasePage.getDriver(), testName));
		endReport();
	}

}
