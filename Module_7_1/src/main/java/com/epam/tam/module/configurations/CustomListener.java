package com.epam.tam.module.configurations;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    WebDriver driver = DefaultDriver.initializeDriver(); 
    String filePath = "./evidence/screenshots/";  
    Logger logger = LogManager.getRootLogger();

    public void onTestStart(ITestResult result) { 
	String resultOutput = result.getName();
	logger.info("*****The name of the testcase Started is :" + resultOutput);
	String methodName = resultOutput.toString().trim();
	String Name = "Startof" + methodName;
//	takeScreenshot(Name);
    }

    public void onTestSuccess(ITestResult result) { 
    String resultOutput = result.getName();
	logger.info("*****The name of the testcase Passed is :" + resultOutput);
	String methodName = resultOutput.toString().trim();
	String Name = "OnSuccessof" + methodName;
//	takeScreenshot(Name);
    }

    public void onTestFailure(ITestResult result) { 
    String resultOutput = result.getName();
	logger.info("*****The name of the testcase Failed is :" + resultOutput);
	String methodName = resultOutput.toString().trim();
	String Name = "OnFailureof" + methodName;
	takeScreenshot(Name);
    }

    public void takeIntermediateScreenshot(String name) {
	logger.info("Taking screenshot of: " + name);
//	takeScreenshot(name);
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    public void onStart(ISuite suite) {

    }

    public void onFinish(ISuite suite) {

    }

    private void takeScreenshot(String Name) {
	driver = DefaultDriver.initializeDriver();
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
	    FileUtils.copyFile(scrFile, new File(filePath + Name + ".png"));
	} catch (IOException e) {
	    logger.trace("Error in plcaing the file due to, " + e.getMessage());
	}
    }

}
