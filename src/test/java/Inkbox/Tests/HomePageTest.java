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

<<<<<<< HEAD
	
	
	@Test(priority = 0)
=======
	@Test(groups = "smoketest")
>>>>>>> 9371c42d095809cbae0eb94b625c81ff88e329db
	public void Verify_Changepassword() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage = new BasePage(test);
		basePage.verifyChangePassword();
	}
<<<<<<< HEAD
	

	 
	@Test(priority = 1)
=======

	@Test(groups = "smoketest")
	public void UserImageChangingOrNot() throws AWTException, InterruptedException {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage = new BasePage(test);
		basePage.VerifyUserImage_Is_Changing_Or_Not();
	}

	@Test(groups = "smoketest")
	public void Verify_Shop() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage = new BasePage(test);
		basePage.Validate_Shop_Menubar();
	}

	@Test(groups = "regression")
>>>>>>> 9371c42d095809cbae0eb94b625c81ff88e329db
	public void Verify_Display_of_Products_on_Homepage() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		HomePage homePage = new HomePage(test);
		homePage.Validating_JustDrop_Products();
	}

	@Test(groups = "smoketest")
	public void ProductsDisplayed_are_Clicable_And_Move_To_PDP() throws InterruptedException {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();

		productspage = new ProductsPage(test);
		productspage.Validate_Products_displayed_clickable();
	}

	@Test(groups = "smoketest")
	public void VerifypopularCategories() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		HomePage homePage = new HomePage(test);
		homePage.ValidatePopularCategories();
	}
<<<<<<< HEAD
	@Test(priority = 4)
	public void Validating_HomePage() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage=new BasePage(test);
		basePage.Vadidating_Header();
		basePage.Validating_NavBar();
		basePage.Validating_MenuItems();
		
	}
	
	@BeforeMethod
=======

	@Test(groups = "smoketest")
	public void Validating_HomePage() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage = new BasePage(test);
		basePage.Vadidating_Header();
		basePage.Validating_NavBar();
		basePage.Validating_MenuItems();

	}

	@Test(groups = "smoketest")
	public void Validate_Footer() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage = new BasePage(test);
		basePage.ValidateFooter();
	}

	@BeforeMethod(alwaysRun = true)
>>>>>>> 9371c42d095809cbae0eb94b625c81ff88e329db
	public void BeforeMethod(ITestResult result) throws InterruptedException {

		report = ExtentFactory.getInstance();

		System.out.println(result.getMethod().getMethodName());
		test = report.startTest(result.getMethod().getMethodName());

	}

	@AfterMethod(alwaysRun = true)
	public void AfterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(getDriver(), result.getName());
			String imagePath = test.addScreenCapture(path);
			System.out.println(result.getThrowable());
			test.log(LogStatus.FAIL, result.getThrowable().toString(), imagePath);
		}
		report.endTest(test);
		report.flush();

	}
}
