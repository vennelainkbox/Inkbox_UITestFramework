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
	
	//selecting random product from Shop page and add to cart for Guest user
	@Test(groups = {"smoketest"})
	public void GuestScenario_Adding_ItemsTocart() {
		ProductsPage productspage=new ProductsPage(test);
		productspage.numberOfproductsAdded=0;
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
	
	@Test(groups = {"smoketest"})
	public void ValidateItems_Adding_To_Cart() {
		AddingItemsTocart();
	
	}
	
	@Test(groups = {"smoketest"})
	public void IncreamentProduct_InCart_And_INC_145_cannot_remove_item_from_cart() {
		AddingItemsTocart();
	
		CartPage cartpage = new CartPage(test);
		cartpage.IncrementTheProductInCart();
		cartpage.RemoveItemsFromCart();
		int count =cartpage.VerifyCartIsEmpty();
		if (count == 0) {
			test.log(LogStatus.PASS, "Cart is Empty");
		} else {
			test.log(LogStatus.ERROR, "Cart is not Empty :" + count + " items present in cart");
		}
		
		boolean status=cartpage.Verify_No_Items_In_Cart_Message();
		if(status)
		{
			test.log(LogStatus.PASS, "You have no items in your cart");
		}
		else {
			test.log(LogStatus.FAIL, "You have no items in your cart is not visible in cart");
		}
		
		int ContinueToCheckout=cartpage.Verify_ContinueToCheckout();
		if(ContinueToCheckout >0)
		{
			test.log(LogStatus.FAIL, "Continue To Checkout is visible after cart is emplty");
			
		}
		else {
			test.log(LogStatus.PASS, "Continue To Checkout is not visible after cart is emplty");
		}
		
		int status_SubTotal=cartpage.Verify_SubTotal();
		if(status_SubTotal>0)
		{
			test.log(LogStatus.FAIL, "SubTotal is visible after cart is emplty");
			
		}
		else {
			test.log(LogStatus.PASS, "SubTotal is not visible after cart is emplty");
		}
		
		int status_Total=cartpage.Verify_SubTotal();
		if(status_Total >0)
		{
			test.log(LogStatus.FAIL, "Total is visible after cart is emplty");
			
		}
		else {
			test.log(LogStatus.PASS, "Total is not visible after cart is emplty");
		}
	}
	

	
	@Test(groups = {"smoketest"})
	public void VerifyFreeShippingMessage() {
		LoginPage loginPage = new LoginPage(test);
		loginPage.UserLogin();
		ProductsPage productspage=new ProductsPage(test);
		//productspage.numberOfproductsAdded=0;
		productspage.selectProductRandomly_AddToCart();
		CartPage cartPage=new CartPage(test);
		String price;
		float priceInFloat = 0;
		do
		{
			cartPage.IncrementTheProductInCart();
			price = cartPage.GetPriceOfProductInCart();
			priceInFloat = (Float.parseFloat(price.replace("$", "")));
		}while(priceInFloat < 35.0);
		
		String ShippingPrice=cartPage.GetShippigPrice();
		if(ShippingPrice.equalsIgnoreCase("You have free shipping"))
		{
			test.log(LogStatus.PASS, ShippingPrice+ " message is shown");
		}
		else {
			test.log(LogStatus.FAIL, ShippingPrice+ " is shown, instead of 'You have free shipping'");
		}
		
	}
	
	@Test(groups = {"smoketest"})
	public void AddItemsToCart_without_Login_and_ValidateAfterLogin() {
		Ads ads = new Ads(test);
		try {
			ads.closeAd();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
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
		productspage.numberOfproductsAdded=0;
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
