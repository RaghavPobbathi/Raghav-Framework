package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.CommonUtils;
import utils.ElementUtilities;

public class MyListeners implements ITestListener{
	ExtentReports reports;
	ExtentTest extentTest;
	WebDriver driver;
	
	@Override
	public void onStart(ITestContext context) {
		reports = CommonUtils.getExtentReports();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		extentTest = reports.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS,result.getName() +" Test got Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.log(Status.PASS, result.getName()+" Test got failed");
	
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		String screenshotFilePath = new ElementUtilities(driver).captureScreenshot(driver, result.getName());
		extentTest.addScreenCaptureFromPath(screenshotFilePath);
		extentTest.log(Status.INFO, result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.PASS, result.getName()+" Test got skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		File extentReport = new File(System.getProperty("user.dir")+"\\Reports\\ExtentReport.html");
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		reports.flush();
	}

}
