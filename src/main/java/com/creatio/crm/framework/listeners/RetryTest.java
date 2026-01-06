package com.creatio.crm.framework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer{
	
	int count = 0;
	int maxRetries = 2;

	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
			if(count < maxRetries) {
				count++;
				return true; //re-execute the failed test
			}
		}	
		return false;//do not re-execute the test
	}

}
