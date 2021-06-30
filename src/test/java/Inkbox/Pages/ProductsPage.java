package Inkbox.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;

public class ProductsPage {
	ExtentTest test;
	String Addtocart_xpath;
	String Product_AddTocart;
	
	public String ProductAdded;
	public int numberOfproductsAdded;
	int randomnumber;

	public ProductsPage(ExtentTest test) {

		this.test = test;
	}

	String product_img = "//div[@id='browse']/descendant::div[starts-with(@id,'original')]";
	String product_name = "//div[@id='browse']/descendant::div[starts-with(@id,'original')]/div[position()=2]/div/div[position()=1]/a";
	String product_price = "//div[@id='browse']/descendant::div[starts-with(@id,'original')]/div[position()=2]/descendant::div[starts-with(@class,'productCard-price')]";
	//String product_AddToCart = "//div[@id='browse']/descendant::div[starts-with(@id,'original')]/div[position()=2]/descendant::div/button[position()=1]";
	//String product_AddToCart="(//div[@id='browse']/descendant::div[starts-with(@id,'original')]/div[position()=2]/div/div[position()=1]/a)[\"+randomnumber+\"]";
	String	product_AddToCart;
	
	public int getNumberOfProductsInPage(By locator) {
		List<WebElement> elements = ControlHelpers.getElementsList(locator);
		int elementsSize = elements.size();
		return elementsSize;
	}

	public void selectProductRandomly() {
		try {

			 randomnumber = ControlHelpers.getRandomNumber(getNumberOfProductsInPage(By.xpath(product_name)));
   
			// System.out.println(randomnumber);
		//	 System.out.println(product_AddToCart);
			product_AddToCart="(//div[@id='browse']/descendant::div[starts-with(@id,'original')]/div[position()=2]/div/div[position()=1]/a)["+randomnumber+"]";
			System.out.println(product_AddToCart);
			ProductAdded=ControlHelpers.getText(By.xpath(product_AddToCart));
			System.out.println(ControlHelpers.getText(By.xpath(product_AddToCart)));
			
			Addtocart_xpath = "(//div[@id='browse']/descendant::div[starts-with(@id,'original')]/div[position()=2]/descendant::div/button[position()=1])["
					+ randomnumber + "]";
			ControlHelpers.MoveToElementAndClick(By.xpath(Addtocart_xpath));
			numberOfproductsAdded=numberOfproductsAdded+1;
			test.log(LogStatus.PASS, "Product :" + ControlHelpers.getText(By.xpath(Addtocart_xpath)) + " is added");

		} catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.ERROR, e.getMessage());
		}

	}

	public void selectProductRandomly_SecondTime() {
		ControlHelpers.MoveToElementAndClick(By.xpath(Addtocart_xpath));
		numberOfproductsAdded=numberOfproductsAdded+1;
		test.log(LogStatus.PASS, "Product :" + ControlHelpers.getText(By.xpath(Addtocart_xpath)) + " is added 2nd time.");
	}
	
	

}
