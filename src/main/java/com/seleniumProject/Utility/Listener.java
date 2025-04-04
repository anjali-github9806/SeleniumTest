package com.seleniumProject.Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import Infy.SeleniumProject.ExtentReport;


public class Listener implements ITestListener {

	 ExtentReports repo;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		
		ExtentTest extentTest = repo.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName() + "Execution started");
		System.out.println(result.getName() + "Execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestSuccess(result);
		System.out.println(result.getName() + "Execution completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		System.out.println(result.getThrowable() + "Test Failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		System.out.println(result.getName() +result.getThrowable()+ "Test Skipped");

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
		  repo = ExtentReport.reports();
		System.out.println("Execution started");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stu
		repo.flush();
		ITestListener.super.onFinish(context);
		System.out.println("Execution Finished");

	}
	
	
	

}
