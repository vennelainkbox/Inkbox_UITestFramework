package Inkbox.Tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
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
import Inkbox.Pages.HomePage;
import Inkbox.Pages.LoginPage;
import Inkbox.Pages.ProductsPage;

public class HomePageTest extends LaunchDriver {
	ExtentTest test;
	ProductsPage productspage;
	
	LoginPage loginPage;

	
	
	@Test(priority = 0)
	public void Verify_Changepassword() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage=new BasePage(test);
		basePage.verifyChangePassword();
	}
	
//	@Test
//	public void UserImageChangingOrNot() throws AWTException, InterruptedException {
//		LoginPage loginPage = new LoginPage(test);
//		loginPage.UserLogin();
//		BasePage basePage=new BasePage(test);
//		basePage.VerifyUserImage_Is_Changing_Or_Not();
//	}
	 
	@Test(priority = 1)
	public void Verify_Display_of_Products_on_Homepage() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		HomePage homePage=new HomePage(test);
		homePage.Validating_JustDrop_Products();
	}
	@Test(priority = 2)
	public void ProductsDisplayed_are_Clicable_And_Move_To_PDP() throws InterruptedException {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		
		productspage = new ProductsPage(test);
		productspage.Validate_Products_displayed_clickable();
	}
	
	@Test(priority = 3)
	public void VerifypopularCategories() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		HomePage homePage=new HomePage(test);
		homePage.ValidatePopularCategories();
	}
	@Test(priority = 4)
	public void Validating_Headers() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage=new BasePage(test);
		basePage.Vadidating_Header();
		basePage.Validating_NavBar();
		basePage.Validating_MenuItems();
		
	}
	
	//@Test(priority = 5)
	public void Validating_Footers() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage=new BasePage(test);
		basePage.Validate_Footer();
	}
	
	@Test(priority = 5)
	public void ValidateProfilePage() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage=new BasePage(test);
		basePage.ValidateProfile();
	}
	
	@BeforeMethod
	public void BeforeMethod(ITestResult result) throws InterruptedException {

		
		report = ExtentFactory.getInstance();
		
		System.out.println(result.getMethod().getMethodName());
		test = report.startTest(result.getMethod().getMethodName());
		
	}
	
	@AfterMethod
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
