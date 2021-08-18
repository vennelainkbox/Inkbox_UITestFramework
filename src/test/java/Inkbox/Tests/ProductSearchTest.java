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
import Inkbox.Pages.BasePage;
import Inkbox.Pages.CartPage;
import Inkbox.Pages.LoginPage;
import Inkbox.Pages.ProductsPage;

public class ProductSearchTest extends LaunchDriver {
	ExtentTest test;

	@Test(groups = { "smoketest" })
	public void Autosuggestion_Validation() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage = new BasePage(test);
		basePage.validate_SearchBox_Acceptence();
		basePage.EnterTextInsearchBox("Butterfly");
		basePage.AutoSuggestValidation();

	}
	@Test(groups = { "smoketest" })
	public void Autosuggestion_Validation_Negative() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage = new BasePage(test);
		basePage.validate_SearchBox_Acceptence();
		basePage.EnterTextInsearchBox("#45%");
		basePage.AutoSuggestValidation();

	}
	
	@Test(groups = { "smoketest" })
	public void EmptySearchBox_Validation() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage = new BasePage(test);
		basePage.Verify_Emptysearch();
		
	}

	@Test(groups = { "smoketest" })
	public void SearchResults_Validation() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage = new BasePage(test);
		basePage.ValidateSearchResults();
	}

	@Test(groups = { "regression" })
	public void SortByPriceLowToHigh() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		ProductsPage productspage = new ProductsPage(test);
		productspage.SortByLowToHigh();
		productspage.ValidatePriceLowToHigh();
	}
	
	@Test(groups = { "regression" })
	public void SortByPriceHighToLow() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		ProductsPage productspage = new ProductsPage(test);
		productspage.SortByHighToLow();
		productspage.ValidatePriceHighToLow();
	}
	

	@Test(groups = { "smoketest" })
	public void Verify_SearchResults() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		ProductsPage productspage = new ProductsPage(test);
		productspage.Verify_Number_of_Searchresults();
	}

	@Test(groups = { "smoketest" })
	public void FilterBySize() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		ProductsPage productspage = new ProductsPage(test);
		String expected = productspage.SortBySize();
		CartPage cartpage = new CartPage(test);
		String actual = cartpage.GetProductsize();
		if (expected.equalsIgnoreCase(actual)) {
			test.log(LogStatus.PASS, "Product size in cart is same as selected size");
		} else {
			test.log(LogStatus.FAIL, "Selected size is :" + expected + " but product size in Cart is :" + actual);
		}
	}

	@Test(groups = { "smoketest" })
	public void ValidatePresentUrl_with_PreviousUrl() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage = new BasePage(test);
		basePage.Validate_PresentURL_With_PreviousURL();
	}

	@Test(groups = { "smoketest" })
	public void ValidatePricingBlock() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		ProductsPage productspage = new ProductsPage(test);
		productspage.Validating_PricingBlock();
	}

	@BeforeMethod(alwaysRun = true)
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
			// test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
		}
		report.endTest(test);
		report.flush();
	}

}
