package Inkbox.Pages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;

public class CartPage {
	ExtentTest test;

	public CartPage(ExtentTest test) {

		this.test = test;
		ControlHelpers controlHelpers = new ControlHelpers(test);
	}

	int numberofitemIncart;
	String Additem = "//button[@id='cart-item-add']";
	String Remove = "//div[text()='Remove']";
	String Cart = "//*[@id='nav-right-icons']/div";
	String items = "//div[@id='cart']/descendant::span[@class='cart-item-count']";
	String item_Name = "//div[@id='cart']/descendant::div[contains(@class,'cart-itemName')]";
	String price = "//*[@id=\"CartDrawer\"]/div/div[2]/div[1]/div/div[3]/div[1]/div[1]";

	String keep_shopping = "//div[@id='cart']/descendant::div/p[contains(text(),'Keep Shopping')]";
	String NumberofItemsinCart = "//button[@id='cart-item-sub']/following-sibling::div";
	String ProductSize="//div[@id=\"CartDrawer\"]/descendant::div[contains(@class,'cart-itemName')]/following-sibling::div";
	String free_Shipping = "//*[@id=\"CartDrawer\"]/div//p/span[contains(text(),'You have free shipping')]";
	String NoItemsInCart = "//div[@id='cart']/descendant::h3";
	String ContinueToCheckout = "//div[@id='CartDrawer']/descendant::span[contains(text(),'Continue to Checkout')]";
	String SubTotal = "//div[@id='CartDrawer']/descendant::p[text()='Subtotal']";
	String Total = "//div[@id='CartDrawer']/descendant::p[text()='Total']";

	public void Click_on_KeepShoping() {
		// ControlHelpers.ButtonClick(By.xpath(keep_shopping));
		ControlHelpers.WaitForElementAndClick(By.xpath(keep_shopping));
	}

	public String GetItemName() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ControlHelpers.getText(By.xpath(item_Name));

	}

	public void IncrementTheProductInCart() {

		int BeforeIncreament = GetNumberOfItemInCart();
		ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(Additem));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int AfterIncreament = GetNumberOfItemInCart();
		if (AfterIncreament == BeforeIncreament + 1) {
			test.log(LogStatus.PASS, "Increament the Products in cart");
		} else {
			test.log(LogStatus.ERROR, "Unnable to increament products in cart");
		}

	}

	public String GetPriceOfProductInCart() {
		return ControlHelpers.getText(By.xpath(price));
	}

	public String GetShippigPrice() {
		return ControlHelpers.getText(By.xpath(free_Shipping));
	}

	public int GetNumberOfItemInCart() {
		String numberofIteminCart = ControlHelpers.getText(By.xpath(NumberofItemsinCart));
		int number = Integer.parseInt(numberofIteminCart);
		System.out.println("Number of Items in cart :" + number);
		return number;
	}

	public int VerifyCartIsEmpty() {
		ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(Cart));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControlHelpers.WaitForElementAndClick(By.xpath(items));
		String items_count = ControlHelpers.getText(By.xpath(items));
		System.out.println("items in cart :" + items_count);
		int count = Integer.parseInt(items_count);
//		if (count == 0) {
//			test.log(LogStatus.PASS, "Cart is Empty");
//		} else {
//			test.log(LogStatus.ERROR, "Cart is not Empty :" + count + " items present in cart");
//		}
		// Click_on_KeepShoping();
		return count;
	}

	public boolean Verify_No_Items_In_Cart_Message() {
		return ControlHelpers.IsElementVisible(By.xpath(NoItemsInCart));
	}
	
	public int Verify_ContinueToCheckout() {
		return ControlHelpers.IsElementPresent(By.xpath(ContinueToCheckout));
	}
	
	public int Verify_SubTotal() {
		return ControlHelpers.IsElementPresent(By.xpath(SubTotal));
	}
	
	public int Verify_Total() {
		return ControlHelpers.IsElementPresent(By.xpath(Total));
	}

	public void RemoveItemsFromCart() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(Remove));
		test.log(LogStatus.INFO, "Products is removed from cart");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Click_on_KeepShoping();
	}

	public void ValidateNumberOfItemInCart() throws InterruptedException {
		Thread.sleep(3000);
		// ProductsPage page=new ProductsPage(test);

		System.out.println("items added " + ProductsPage.numberOfproductsAdded);
		System.out.println("items in cart " + GetNumberOfItemInCart());
		if (ProductsPage.numberOfproductsAdded == GetNumberOfItemInCart()) {
			test.log(LogStatus.PASS, "Number of Items Added is :" + ProductsPage.numberOfproductsAdded);
		} else {
			test.log(LogStatus.ERROR, "Number of Items Added is :" + ProductsPage.numberOfproductsAdded
					+ " is differ from number of Items in Card :" + GetNumberOfItemInCart());
		}
	}

	public void ValidateItemIncart() {
		ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(Cart));
		String itemname = ProductsPage.ProductAddedTocart;

		if (itemname.equalsIgnoreCase(GetItemName())) {
			test.log(LogStatus.PASS, "Product :" + itemname + " is present in cart");
		} else {
			test.log(LogStatus.ERROR, "Product is not present in cart");
		}
		Click_on_KeepShoping();
	}
	
	public String GetProductsize() {
		String size=ControlHelpers.getText(By.xpath(ProductSize));
		size=size.replace("Size:", "").replace("in", "").replace(" ", "");
		return size;
	}
}
