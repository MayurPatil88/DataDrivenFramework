package com.edusoln.base;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edusoln.runner.TestRunner;



public class Listners implements ITestListener  {
	
   
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("============On test Start=========");
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("============On test failure=========");
		TestRunner.test.log(Status.FAIL, "===test is fail===").addScreenCaptureFromPath(CommonFunctions.getScreenshot(TestRunner.driver, "LoginFailuer"));
		
			
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
	
		System.out.println("============On test sucess=========");
		TestRunner.test.log(Status.INFO, "====test is sucessfull===");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("============On test Skipped=========");
		TestRunner.test.log(Status.INFO, "====test is skipped===");
	}
	

}

	
	