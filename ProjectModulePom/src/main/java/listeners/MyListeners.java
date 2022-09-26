package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import baseclass.BaseClass;
import utility.DriverUtility;

public class MyListeners extends BaseClass implements ITestListener{

	public void onFinish(ITestContext result) {
		report.flush();
	}

	
	public void onStart(ITestContext result) {
		reportInhit();
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"Test case failed with test name:"+result.getName());
		String path = DriverUtility.getScreenshot(result.getName());
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,"Test case skiped with test name:"+result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test case Passed with test name:"+result.getName());
		
	}

}
