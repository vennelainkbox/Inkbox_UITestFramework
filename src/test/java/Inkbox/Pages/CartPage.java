package Inkbox.Pages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;

public class CartPage {
	ExtentTest test;
	
	int numberofitemIncart;

	public CartPage(ExtentTest test) {

		this.test = test;
	}

	String keep_shopping = "//div[@id='cart']/descendant::div/p[contains(text(),'Keep Shopping')]";
	String NumberofItemsinCart="//button[@id='cart-item-sub']/following-sibling::div";
	
	
	public void Click_on_KeepShoping() {
		// ControlHelpers.ButtonClick(By.xpath(keep_shopping));
		ControlHelpers.WaitForElementAndClick(By.xpath(keep_shopping));
	}
	
	public int GetNumberOfItemInCart() {
		String numberofIteminCart=ControlHelpers.getText(By.xpath(NumberofItemsinCart));
		int number=Integer.parseInt(numberofIteminCart); 
		System.out.println("Number of Items in cart :"+number);
		return number;
	}
	
	public void ValidateNumberOfItemInCart() throws InterruptedException {
		Thread.sleep(3000);
		ProductsPage page=new ProductsPage(test);
		System.out.println("items added "+page.numberOfproductsAdded);
		System.out.println("items in cart "+GetNumberOfItemInCart());
		if(page.numberOfproductsAdded==GetNumberOfItemInCart())
		{
			test.log(LogStatus.PASS, "Number of Items Added is :"+page.numberOfproductsAdded);
		}
		else {
			test.log(LogStatus.ERROR, "Number of Items Added is :"+page.numberOfproductsAdded +" is differ from number of Items in Card :"+GetNumberOfItemInCart());
		}
	}
}
