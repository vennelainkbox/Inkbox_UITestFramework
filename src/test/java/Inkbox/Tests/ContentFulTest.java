package Inkbox.Tests;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;
import Helpers.ExtentFactory;
import Helpers.LaunchDriver;
import Helpers.Screenshots;
import Inkbox.Pages.ContentfulPage;

public class ContentFulTest extends LaunchDriver {
	ExtentTest test;
	@BeforeMethod(alwaysRun = true)
	public void BeforeMethod(ITestResult result) throws InterruptedException {

		
		report = ExtentFactory.getInstance();
		System.out.println(result.getMethod().getMethodName());
		test = report.startTest(result.getMethod().getMethodName());
		
	}
	@AfterMethod(alwaysRun = true)
	public void AfterMethod(ITestResult result) throws IOException
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(getDriver(), result.getName());
			String imagePath = test.addScreenCapture(path);
			System.out.println(result.getThrowable());
			test.log(LogStatus.FAIL,result.getThrowable().toString(),imagePath);
			//test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
		}
		report.endTest(test);
		report.flush();
	}
	
	@Test
	public void Login() {
		ControlHelpers.GetDriver().get("https://app.contentful.com/spaces/pkpedwjf5oyt/entries/qNZptxr5VNANDVrNUdmiM");
		ContentfulPage contentfulPage=new ContentfulPage(test);
		contentfulPage.Contentful_Login();
		contentfulPage.Hero_Banner_validation();
		
	}

}
