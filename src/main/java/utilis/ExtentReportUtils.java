package utilis;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtils {

	private ExtentReports extent;

	private ExtentSparkReporter spark;

	private ExtentTest extentTest;

	public ExtentReportUtils(String reportName) throws Exception {

		reportName = reportName.trim();

		if (reportName.endsWith(".html")) {

			extent = new ExtentReports();

			spark = new ExtentSparkReporter(reportName);

			extent.attachReporter(spark);

		} else {
			throw new Exception("Invalid report type");
		}

	}

	public void createTestCase(String testcaseName) {

		extentTest = extent.createTest(testcaseName);

	}

	public void addLogs(String status, String message) {

		status = status.trim();

		status = status.toLowerCase();

		switch (status) {
		case "info": {

			extentTest.log(Status.INFO, message);
			break;

		}
		case "warn": {

			extentTest.log(Status.WARNING, message);
			break;
		}
		case "pass": {

			extentTest.log(Status.PASS, message);
			break;
		}

		case "skip": {

			extentTest.log(Status.SKIP, message);
			break;
		}

		case "fail": {

			extentTest.log(Status.FAIL, message);
			break;
		}
		default:
			extentTest.log(Status.INFO, message);
			break;
		}

	}

	public void attachScreenshot(String reportName) {

		extentTest.addScreenCaptureFromPath(reportName);
	}

	public void flushReport() {
		extent.flush();
	}

}
