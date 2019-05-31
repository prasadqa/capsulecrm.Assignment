package com.capsulecrm.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.capsulecrm.base.TestBase;

public class ItestListenerImplimentation extends TestBase implements ITestListener {

	public void onFinish(ITestContext context) {
		
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	// error message gets print in console if test fails 
	public void onTestFailure(ITestResult result) {
		//screenshot(result.getMethod().getMethodName());
		System.out.println(result.getThrowable().getMessage());
		System.out.println(result.getMethod().getMethodName()+" is failed");
		
	}
	// error message gets print in console if test skips 
	public void onTestSkipped(ITestResult result) {
		System.out.println(result);
		System.out.println(result.getThrowable());
		System.out.println(result.getMethod().getMethodName()+" is skipped");
		
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
	}

}
