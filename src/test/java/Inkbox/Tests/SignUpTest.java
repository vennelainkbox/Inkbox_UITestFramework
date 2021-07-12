package Inkbox.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ExtentFactory;
import Helpers.LaunchDriver;
import Helpers.Screenshots;
import Inkbox.Pages.Ads;
import Inkbox.Pages.BasePage;
import Inkbox.Pages.LoginPage;
import Inkbox.Pages.SignUpPage;

public class SignUpTest extends LaunchDriver {
	WebDriver Webdriver;

	LoginPage loginPage;
	BasePage basePage;
	ExtentReports report;
	ExtentTest test;
	SignUpPage signUpPage;

	@Test(priority = 0)
	public void SignUpTest() throws IOException  {
		Ads ads = new Ads(test);
		try {
			ads.closeAd();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		basePage = new BasePage(test);
		basePage.AcctountIcon();
		signUpPage=new SignUpPage(test);
		signUpPage.EnterEmail();
		signUpPage.Enterpassword();
		String path = Screenshots.takeScreenshot(getDriver(), "SighUp");
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.PASS, "Verify Welcome Text Failed", imagePath);
		//$NON-NLS-N$
	
		signUpPage.ClickOnSignUp();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String path2 = Screenshots.takeScreenshot(getDriver(), "SighUp");
		String imagePath2= test.addScreenCapture(path2);
		test.log(LogStatus.PASS, "Verify Welcome Text Failed", imagePath2);
		
		

	}
	

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		report = ExtentFactory.getInstance();
		test = report.startTest("User SignUp");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		report.endTest(test);
		report.flush();
	}

	@AfterMethod(alwaysRun = true)
	public void beforeTest(ITestResult testResult) throws IOException  {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(getDriver(), testResult.getName());
			String imagePath = test.addScreenCapture(path);
			//$NON-NLS-N$
			System.out.println(testResult.getStatus());
			test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
		}
	

	}
}
