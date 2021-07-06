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
import Inkbox.Pages.LoginPage;
import Inkbox.Pages.ProductsPage;

public class ProductSearchTest extends LaunchDriver {
	ExtentTest test;
	
	
	@Test(priority = 0)
	public void Autosuggestion_Validation() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage=new BasePage(test);
		basePage.validate_SearchBox_Acceptence();
		basePage.EnterTextInsearchBox("butterfly");
		basePage.AutoSuggestValidation();
		
	}
	
	@Test(priority = 1)
	public void SortByPriceLowToHigh() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		ProductsPage productspage = new ProductsPage(test);
		productspage.SortByLowToHigh();
		productspage.ValidatePriceLowToHigh();
	}
	
	@Test(priority = 2)
	public void SortBySize() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		ProductsPage productspage = new ProductsPage(test);
		productspage.SortBySize();
	}
	
	
	@Test(priority = 3)
	public void ValidatePresentUrl_with_PreviousUrl() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		BasePage basePage=new BasePage(test);
		basePage.Validate_PresentURL_With_PreviousURL();
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
