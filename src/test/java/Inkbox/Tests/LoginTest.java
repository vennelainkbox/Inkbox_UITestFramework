package Inkbox.Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;
import Helpers.ExtentFactory;
import Helpers.LaunchDriver;
import Helpers.Screenshots;
import Helpers.WebdriverFactory;
import Inkbox.Pages.Ads;
import Inkbox.Pages.BasePage;
import Inkbox.Pages.LoginPage;

public class LoginTest extends LaunchDriver {
	
	ExtentTest test;
	
	

	@Test(groups = {"smoketest"})
	public void LoginWithDirectUser() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		Loginvalidation();
		
		
	}
	
	@Test(groups = {"smoketest"})
	public void LoginWithGoogle() {
		
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin_With_Google();
		Loginvalidation();
		
	}
	
	@Test(groups = {"smoketest"})
	public void LoginWithFacebook() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin_With_FaceBook();
		Loginvalidation();
	}
	

	public void Loginvalidation() {
		BasePage basePage=new BasePage(test);
		boolean userLogin=basePage.VerifyAccountLogin();
		if(userLogin)
		{
			test.log(LogStatus.PASS, "Login Success");
		}
		else
		{
			test.log(LogStatus.FAIL, "Login fail");
			Assert.fail("Login fail");
		}
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
