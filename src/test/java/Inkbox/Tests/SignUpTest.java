package Inkbox.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
	public void SignUp() throws IOException  {
		String randomstring=GenerateRandomString(8);
		String username="TestInk"+randomstring+"@gmail.com";
		setUsername_configFile(username);
		SaveUsernameToCsvFile(username);
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
//		signUpPage.EnterEmail("TestInkbox123456@gamil.com");
//		signUpPage.Enterpassword("Inkbok!123");
		signUpPage.EnterEmail(LaunchDriver.getUsername());
		signUpPage.Enterpassword(LaunchDriver.getPassword());
		test.log(LogStatus.INFO, "SignUp with credentials");
		String path = Screenshots.takeScreenshot(getDriver(), "SighUp");
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.PASS, imagePath);
		//$NON-NLS-N$
	
		signUpPage.ClickOnSignUp();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Clicked on SignUpButton");
		String path2 = Screenshots.takeScreenshot(getDriver(), "SighUp");
		String imagePath2= test.addScreenCapture(path2);
		test.log(LogStatus.PASS, imagePath2);
		
		signUpPage.ValidateSignup();
		

	}
	

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
}
