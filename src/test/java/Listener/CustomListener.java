package Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import Helpers.LaunchDriver;
import Helpers.Screenshots;

public class CustomListener extends LaunchDriver implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		// When test method starts
		System.out.println("onTestStart -> Test Name: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// If test method is successful
		System.out.println("onTestSuccess -> Test Name: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// If test method is failed
		//System.out.println("onTestFailure -> Test Name: " + result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
		//	String path = Screenshots.takeScreenshot(getDriver(), result.getName());
		//	String imagePath = test.addScreenCapture(path);
		//	test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// If test method is failed
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Ignore this
	}

	@Override
	public void onStart(ITestContext context) {
		// Before <test> tag of xml file
		System.out.println("onStart -> Test Tag Name: " + context.getName());
		ITestNGMethod methods[] = context.getAllTestMethods();
		System.out.println("These methods will be executed in this test tag:");
		for (ITestNGMethod method : methods) {
			System.out.println(method.getMethodName());
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		// After <test> tag of xml file
		System.out.println("onFinish -> Test Tag Name: " + context.getName());
	}

}
