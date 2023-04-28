package com.amazon.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.Amazon.pages.SearchProduct;

import commonLibs.CommonDriver;
import commonLibs.ScreenshotControl;
import utilis.ConfigUtils;
import utilis.DateTimeUtils;
import utilis.ExtentReportUtils;

public class BaseTest {

	CommonDriver cmnDriver;

	WebDriver driver;

	SearchProduct searchProduct;

	static ExtentReportUtils reportUtils;

	private static String reportName;

	private static String currentWorkingDirectory;

	private static String executionStartTime;

	ScreenshotControl screenshotControl;

	private static String configFileName;

	Properties configProperties;

	@BeforeClass
	public void preSetup() throws Exception {

		executionStartTime = DateTimeUtils.getCurrentDateAndTime();

		currentWorkingDirectory = System.getProperty("user.dir");

		reportName = String.format("%s/reports/%s/amazonReport.html", currentWorkingDirectory, executionStartTime);

		reportUtils = new ExtentReportUtils(reportName);

		configFileName = String.format("%s/config/config.properties", currentWorkingDirectory);

		configProperties = ConfigUtils.readConfig(configFileName);

	}

	@BeforeMethod
	public void setup() throws Exception {

		cmnDriver = new CommonDriver(configProperties.getProperty("browser"));

		cmnDriver.navigateToURL(configProperties.getProperty("baseUrl"));

		driver = cmnDriver.getDriver();

		searchProduct = new SearchProduct(driver);

		screenshotControl = new ScreenshotControl(driver);
	}

	@AfterMethod
	public void cleanup(ITestResult testResult) throws Exception {

		if (testResult.getStatus() == ITestResult.SUCCESS) {

			reportUtils.addLogs("pass", "All test steps passed ");

		} else if (testResult.getStatus() == ITestResult.FAILURE) {

			String screenshotExecutionTime = DateTimeUtils.getCurrentDateAndTime();

			String screenshotName = testResult.getName();

			String screenshotFullName = String.format("%s/screenshot/%s/%s.jpeg", currentWorkingDirectory,
					screenshotExecutionTime, screenshotName);

			screenshotControl.captureAndSaveScreenshot(screenshotFullName);

			reportUtils.attachScreenshot(screenshotFullName);

			reportUtils.addLogs("fail", testResult.getThrowable().toString());

			reportUtils.addLogs("fail", "One or more test step failed");

		} else {

			reportUtils.addLogs("skip", "Test steps skipped");

		}

		cmnDriver.quitBrowser();
	}

	@AfterClass
	public void postCleanup() {

		reportUtils.flushReport();

	}

}
