package Inkbox.Pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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
	public static int numberOfproductsAdded=0;
	public  static String ProductAddedTocart=null;
	int randomnumber;
	
	

	public ProductsPage(ExtentTest test) {

		this.test = test;
		ControlHelpers controlHelpers=new ControlHelpers(test);
	}
	String Search_textbox = "//input[@id='search-field-input']";

	//String product_img = "//div[@id='browse']/descendant::div[starts-with(@id,'original')]";
	String product_img = "//div[@id='browse']/descendant::div[starts-with(@id,'original')]/div[@class='relative group']";
	String product_name = "//div[@id='browse']/descendant::div[starts-with(@id,'original')]/div[position()=2]/div/div[position()=1]/a";
	String product_price = "//div[@id='browse']/descendant::div[starts-with(@id,'original')]/div[position()=2]/descendant::div[starts-with(@class,'productCard-price')]";
	//String product_AddToCart = "//div[@id='browse']/descendant::div[starts-with(@id,'original')]/div[position()=2]/descendant::div/button[position()=1]";
	//String product_AddToCart="(//div[@id='browse']/descendant::div[starts-with(@id,'original')]/div[position()=2]/div/div[position()=1]/a)[\"+randomnumber+\"]";
	String	product_AddToCart;
	
	String products_Under_Shop="//li[@id='menu-L0-shop']/descendant::ul/span[text()='Shop']/parent::ul/child::li/a";
	String Sort_By="//button/span[text()='Sort By']";
	String PriceLow_High="//div[@class='py-1']/ul/li/label/span[text()='Price: Low - High']";
	String Sort_By_Size="//div[@id='size']/descendant::label";
	String Additem="//button[@id='cart-item-add']";
	
	public int getNumberOfProductsInPage(By locator) {
		List<WebElement> elements = ControlHelpers.getElementsList(locator);
		int elementsSize = elements.size();
		return elementsSize;
	}

	public void selectProductRandomly_AddToCart() {
		try {

			BasePage basePage=new BasePage(test);
			basePage.Click_On_Shop();
			 randomnumber = ControlHelpers.getRandomNumber(getNumberOfProductsInPage(By.xpath(product_name)));
   
			// System.out.println(randomnumber);
		//	 System.out.println(product_AddToCart);
			product_AddToCart="(//div[@id='browse']/descendant::div[starts-with(@id,'original')]/div[position()=2]/div/div[position()=1]/a)["+randomnumber+"]";
			System.out.println(product_AddToCart);
			ProductAdded=ControlHelpers.getText(By.xpath(product_AddToCart));
			ProductAddedTocart=ControlHelpers.getText(By.xpath(product_AddToCart)); 
			System.out.println(ProductAddedTocart);
			
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
	public void SortByLowToHigh() {
		
		BasePage basePage=new BasePage(test);
		basePage.Click_On_Shop();
		
	//	ControlHelpers.ClickEnter(By.xpath(Search_textbox));
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControlHelpers.ButtonClick(By.xpath(Sort_By));
		ControlHelpers.ButtonClick(By.xpath(PriceLow_High));
		
		
	}
	
	public void ValidatePriceLowToHigh() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Double> pricelist = new ArrayList<Double>();
		List<WebElement> products = ControlHelpers.getElementsList(By.xpath(product_price));
		for (int i = 0; i < products.size(); i++) {
			int j=i+1;
			String pricePath="(//div[@id='browse']/descendant::div[starts-with(@id,'original')]/div[position()=2]/descendant::div[starts-with(@class,'productCard-price')])["+j+"]";
			String path=ControlHelpers.getText(By.xpath(pricePath));
			path=path.replace("$", "").replace("USD", "").replace("CAD", "");
			path=path.trim();
			//System.out.println(path);
			double price=Double.parseDouble(path);
			pricelist.add(price);
		}
		int k=0;
		for (int i = 0; i < pricelist.size() - 1; i++) {
			
			if (pricelist.get(i) > pricelist.get(i + 1)) {
			//	System.out.println("false :" + pricelist.get(i));
				test.log(LogStatus.ERROR, "Price is not Sorted by Low to High");
				k=1;
			}
			
		}
		
		if(k!=1)
		{
			test.log(LogStatus.PASS, "Able to sort by price low/high");
		}
	}
	
	public void SortBySize() {
		
		BasePage basePage=new BasePage(test);
		basePage.Click_On_Shop();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> elements = ControlHelpers.getElementsList(By.xpath(Sort_By_Size));
		
		int randompath=ControlHelpers.getRandomNumber(elements.size()-1);
		
		String SizePath="(//div[@id='size']/descendant::label)["+randompath+"]";
		String size=ControlHelpers.getText(By.xpath(SizePath));
		
	//	ControlHelpers.ButtonClick(By.xpath(SizePath));
		ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(SizePath));
		size=size.replace("\"", "").replace("Inches", "");
		size=size.trim();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url=ControlHelpers.GetDriver().getCurrentUrl();
		if(url.contains(size))
		{
			test.log(LogStatus.PASS, "Able to filter by size");
		}
		else {
			System.out.println("URL :"+url+ " size :"+size);
			test.log(LogStatus.ERROR, "Unnable to filter by size");
			//Assert.fail();
		}
		
//		for (int i = 0; i < elements.size()-1; i++) {
//			int j=i+1;
//			String sizePath="(//div[@id='size']/descendant::label)["+j+"]";
//			System.out.println(ControlHelpers.getText(By.xpath(sizePath)));
//			
//		}
		
	}
	
	public void SelectsameProduct_nextTime() {
		ControlHelpers.MoveToElementAndClick(By.xpath(Addtocart_xpath));
		numberOfproductsAdded=numberOfproductsAdded+1;
		test.log(LogStatus.PASS, "Product :" + ControlHelpers.getText(By.xpath(Addtocart_xpath)) + " is added next time.");
		System.out.println(numberOfproductsAdded);
		
	}
	
	public void Validate_Products_displayed_clickable() {
		//To validates products are displayed or not in home page
		BasePage basePage=new BasePage(test);
		basePage.Click_On_Shop();
		List<WebElement> products = ControlHelpers.getElementsList(By.xpath(product_img));
		if(products.size()>1)
		{
			test.log(LogStatus.INFO, "Products displayed on Home screen");
		}
		else {
			test.log(LogStatus.ERROR, "Products are not displayed on Home screen");
		}
		
		int randomnum = ControlHelpers.getRandomNumber(getNumberOfProductsInPage(By.xpath(product_img)));
		
		String randomXpath="(//div[@id='browse']/descendant::div[starts-with(@id,'original')]/div[position()=2]/div/div[position()=1]/a)["+randomnum+"]";
		String productText=ControlHelpers.getText(By.xpath(randomXpath));
		ControlHelpers.ButtonClick(By.xpath(randomXpath));
		test.log(LogStatus.PASS, "Products displayed are clickable");
		String url=ControlHelpers.GetDriver().getCurrentUrl();
		url.toLowerCase();
		productText=productText.toLowerCase();
		url=url.replace("-", "").replace(" ", "");
		productText=productText.replace("-", "").replace(" ", "");
		url=url.trim();
		productText=productText.trim();
		System.out.println("uRL :"+url +" discription :"+productText);
		if(url.contains(productText))
		{
			test.log(LogStatus.PASS, "Takes to Product discription page");
		}
		else {
			test.log(LogStatus.ERROR, "Not Takes to Product discription page");
			System.out.println("URL :"+url +"selected product :"+productText);
		}
	}
	
	
	
	
	

}
