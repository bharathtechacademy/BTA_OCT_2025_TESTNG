package com.creatio.crm.framework.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println("Execution started for Test Case: " + testName);
	}

	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println("Execution is Successfully Completed for Test Case: " + testName);
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println("Execution is Failed for Test Case: " + testName);
		System.out.println("Failure Reason: " + result.getThrowable().getMessage());
		System.out.println("Taking Screenshot for Test Case: " + testName);
	}

}
