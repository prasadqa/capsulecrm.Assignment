package com.capsulecrm.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer{

	private int counter = 0;
	private int retry = 3;//failed test case runs for times 
	
	public boolean retry(ITestResult result) {
		
		if (counter<retry) {
			counter++;
			return true;
		}
		return false;
	}

}
 