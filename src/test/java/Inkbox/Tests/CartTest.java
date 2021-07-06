package Inkbox.Tests;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ExtentFactory;
import Helpers.LaunchDriver;
import Helpers.Screenshots;
import Inkbox.Pages.Ads;
import Inkbox.Pages.BasePage;
import Inkbox.Pages.CartPage;
import Inkbox.Pages.LoginPage;
import Inkbox.Pages.ProductsPage;

public class CartTest extends LaunchDriver {
	ExtentTest test;
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
	
	@Test(priority = 0)
	public void ValidateItems_Adding_To_Cart() {
		AddingItemsTocart();
	}
	
	@Test(priority = 1)
	public void IncreamentProduct_InCart_And_Remove_Items_In_Cart() {
		AddingItemsTocart();
		CartPage cartpage = new CartPage(test);
		cartpage.IncrementOrDecrementTheProduct();
		cartpage.RemoveItemsFromCart();
		BasePage basePage=new BasePage(test);
		basePage.Logout();
		cartpage.VerifyCartIsEmpty();
	}
	
	@Test(priority = 2)
	public void AddItemsToCart_without_Login_and_ValidateAfterLogin() {
		Ads ads = new Ads(test);
		try {
			ads.closeAd();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BasePage basePage=new BasePage(test);
		basePage.Click_On_Shop();
		ProductsPage productpage=new ProductsPage(test);
		productpage.selectProductRandomly_AddToCart();
		CartPage cartpage = new CartPage(test);
		cartpage.Click_on_KeepShoping();
		basePage.AcctountIcon();
		LoginPage loginPage = new LoginPage(test);
		loginPage.ClickLogin_link();
		loginPage.EnterEmail("testinkbox@gmail.com");
		loginPage.EnterPassword("Test@123");
		loginPage.ClickLoginButton();
		cartpage.ValidateItemIncart();
	}
	
	public void AddingItemsTocart() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		ProductsPage productspage=new ProductsPage(test);
		productspage.selectProductRandomly_AddToCart();
		CartPage cartpage=new CartPage(test);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cartpage.Click_on_KeepShoping();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		productspage.SelectsameProduct_nextTime();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			cartpage.ValidateNumberOfItemInCart();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
