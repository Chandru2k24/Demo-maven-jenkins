
package com.Utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerData implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		System.out.println("The name of the test started : "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the test falied : "+result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" : Test was success ");
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName()+" : Test was Skipped ");
	}

}
