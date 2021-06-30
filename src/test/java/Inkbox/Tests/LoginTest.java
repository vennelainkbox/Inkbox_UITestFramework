package Inkbox.Tests;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;
import Helpers.ExtentFactory;
import Helpers.LaunchDriver;
import Helpers.Screenshots;
import Inkbox.Pages.*;

public class LoginTest extends LaunchDriver {
	WebDriver Webdriver;

	LoginPage loginPage;
	BasePage basePage;
	ExtentReports report;
	ExtentTest test;
	
	
	public void TestDirectUserLogin() {
		UserLogin();
		ValidateMyAccount();
	}
	

	
	public void TestGoogleUserLogin() {
		UserLogin_With_Google();
		ValidateMyAccount();
		
	}
	@Test
	public void TestFacebookUserLogin() {
		UserLogin_With_FaceBook();
		ValidateMyAccount();
	}
	
	public void ValidateMyAccount() {
		BasePage basePage=new BasePage(test);
		String accountText=basePage.VerifyAccount();
		if(accountText.contains("My Account"))
		{
			System.out.println(accountText);
			test.log(LogStatus.PASS, accountText);
		}
		else
		{
			System.out.println(accountText);
			test.log(LogStatus.ERROR, accountText);
		}
	}

	public void UserLogin() {
		

		try {
			Ads ads = new Ads(test);
			ads.closeAd();
			basePage = new BasePage(test);
			basePage.AcctountIcon();
			loginPage = new LoginPage();
			loginPage.ClickLogin_link();
			loginPage.EnterEmail("testinkbox@gmail.com");
			loginPage.EnterPassword("Test@123");
			loginPage.ClickLoginButton();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.fillInStackTrace());
		}

	}
	
	
	public  void UserLogin_With_Google() {
		try {
			Ads ads = new Ads(test);
			ads.closeAd();
			basePage = new BasePage(test);
			basePage.AcctountIcon();
			loginPage = new LoginPage();
			loginPage.ClickContinue_With_google();
			loginPage.EnterGoogle_MailID("testinkbox@gmail.com");
			loginPage.EnterGoogle_Password("Inkbox!123");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.fillInStackTrace());
		}

	}
	
	public  void UserLogin_With_FaceBook() {
		try {
			Ads ads = new Ads(test);
			ads.closeAd();
			basePage = new BasePage(test);
			basePage.AcctountIcon();
			loginPage = new LoginPage();
			loginPage.ClickContinue_With_facebook();
			loginPage.EnterEmail_facebook("testinkbox@gmail.com");
			loginPage.EnterPassword_facebook("Inkbox!123");
			loginPage.Click_On_Login_facebook();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.fillInStackTrace());
		}

	}
	
	
	@BeforeClass
	public void beforeClass()
	{
		report = ExtentFactory.getInstance();
		test = report.startTest("User Login");
	}
	
	@AfterClass
	public void afterClass() {
		report.endTest(test);
		report.flush();
	}
	@AfterMethod
	public void beforeTest(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(getDriver(), testResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
		}
		
	}

}
