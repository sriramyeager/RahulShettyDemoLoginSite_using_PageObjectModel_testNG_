package com.qa.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners implements ITestListener {

	ExtentReports  extentReports;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		extentReports = ExtentReporter.generateExtentReporter();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extentTest = extentReports.createTest(testName);
		extentTest.log(Status.INFO, testName +" start executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.PASS, testName+" got successfully executed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL,testName+" got failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP,testName+" got skipped");
	}	


	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}


}
