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

import Helpers.ControlHelpers;
import Helpers.ExtentFactory;
import Helpers.LaunchDriver;
import Helpers.Screenshots;
import Inkbox.Pages.Ads;
import Inkbox.Pages.BasePage;
import Inkbox.Pages.CartPage;
import Inkbox.Pages.LoginPage;
import Inkbox.Pages.ProductsPage;

public class AddToCartTest extends LaunchDriver {
	WebDriver Webdriver;

	LoginPage loginPage;
	BasePage basePage;
	ExtentReports report;
	ExtentTest test;
	ProductsPage productpage;
	CartPage cartpage;

	@BeforeClass
	public void beforeClass() {
		report = ExtentFactory.getInstance();
		test = report.startTest("Add To Cart test");
	}

	@AfterClass
	public void afterClass() {
		report.endTest(test);
		report.flush();
	}

	@AfterMethod
	public void beforeTest(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(ControlHelpers.GetDriver(), testResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "", imagePath);
		}

	}

//	@Test(priority = 0)
//	public void AdditemsToCart() throws InterruptedException {
//		productpage = new ProductsPage(test);
//		productpage.selectProductRandomly_AddToCart();
//		cartpage = new CartPage(test);
//
//		Thread.sleep(6000);
//
//		cartpage.Click_on_KeepShoping();
//
//		Thread.sleep(6000);
//
//		productpage.SelectsameProduct_nextTime();
//		cartpage.ValidateNumberOfItemInCart();
//
//	}
	@Test(priority = 0)
	public void AddItemsToCart() throws InterruptedException {
		//UserLogin();
//		basePage =new BasePage(test);
//		basePage.Click_On_Shop();
		productpage=new ProductsPage(test);
		productpage.selectProductRandomly_AddToCart();
		cartpage =new CartPage(test);
		Thread.sleep(8000);
		cartpage.Click_on_KeepShoping();
		Thread.sleep(6000);
		productpage.SelectsameProduct_nextTime();
		Thread.sleep(6000);
		cartpage.ValidateNumberOfItemInCart();
		
	}
	@Test(priority = 1)
	public void IncreamentProduct() {
		cartpage = new CartPage(test);
		cartpage.IncrementOrDecrementTheProduct();
	}
	
	@Test(priority = 2)
	public void RemoveItems() {
		cartpage.RemoveItemsFromCart();
	}
	

	@Test(priority =3 )
	public void Logout_VerifyCart() {
		basePage=new BasePage(test);
		basePage.Logout();
		cartpage.VerifyCartIsEmpty();
	}

	
	
	
	@Test(priority = 4)
	public void AddItemsTocart() {
		basePage.Click_On_Shop();
		productpage.selectProductRandomly_AddToCart();
		cartpage.Click_on_KeepShoping();
	}
	
	
	
	@Test(priority = 5)
	public void LoginAndValidateItemIncart() {
		
		basePage.AcctountIcon();
		loginPage = new LoginPage(test);
		loginPage.ClickLogin_link();
		loginPage.EnterEmail("testinkbox@gmail.com");
		loginPage.EnterPassword("Test@123");
		loginPage.ClickLoginButton();
		cartpage.ValidateItemIncart();
		
	}
	
	
	
	
	public void UserLogin() {

		try {
			Ads ads = new Ads(test);
			ads.closeAd();
			basePage = new BasePage(test);
			basePage.AcctountIcon();
			loginPage = new LoginPage(test);
			loginPage.ClickLogin_link();
			loginPage.EnterEmail("testinkbox@gmail.com");
			loginPage.EnterPassword("Test@123");
			loginPage.ClickLoginButton();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.fillInStackTrace());
		}

	}
//	public void ValidateMyAccount() {
//		BasePage basePage=new BasePage(test);
//		String accountText=basePage.VerifyAccount();
//		if(accountText.contains("My Account"))
//		{
//			System.out.println(accountText);
//			test.log(LogStatus.PASS, accountText);
//		}
//		else
//		{
//			System.out.println(accountText);
//			test.log(LogStatus.ERROR, accountText);
//		}
//	}

}
