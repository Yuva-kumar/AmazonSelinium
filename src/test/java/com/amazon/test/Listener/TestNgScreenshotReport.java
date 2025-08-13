package com.amazon.test.Listener;

import com.amazon.test.utility.ExtentManager;
import com.amazon.test.utility.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.openqa.selenium.WebDriver;

public class TestNgScreenshotReport implements ITestListener {

    ExtentReports extent = ExtentManager.getReporter();
    ExtentTest test;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());
        Object driverObject = result.getTestContext().getAttribute("WebDriver");
        if (driverObject instanceof WebDriver) {
            String screenshotPath = ScreenshotUtil.takeScreenshot((WebDriver) driverObject, result.getMethod().getMethodName());
            extentTest.get().addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}


