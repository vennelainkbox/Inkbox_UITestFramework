package Inkbox.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;

public class BasePage {
	ExtentTest test;

	public BasePage(ExtentTest test) {

		this.test = test;
	}

	// local veriables
	String searchtext;

	// search items
	String SortBy = "//button[@id='options-menu']";

	// Header paths
	String Student_discount = "//*[@id=\"header-student\"]/a[text()='Student Discount']";
	String Rewards = "//*[@id=\"header-rewards\"]/a[text()='Rewards']";
	String Help = "//div[@id='header-help']/button/span[text()='Help']";
	String Login_Button = "//*[@id='header-user']/button";

	// Menu Items
	String Shop = "//div[@id='nav-links']/div/a[contains(text(),'Shop')]";
	String TattooQuiz = "//div[@id='nav-links']/div/a[contains(text(),'Tattoo Quiz')]";
	String Custom = "//div[@id='nav-links']/div/a[contains(text(),'Custom')]";
	String Collabs = "//div[@id='nav-links']/div/a[contains(text(),'Collabs')]";
	String Trending = "//div[@id='nav-links']/div/a[contains(text(),'Trending')]";
	String Sale = "//div[@id='nav-links']/div/a[contains(text(),'Sale')]";
	String How_It_Work = "//div[@id='nav-links']/div/a[contains(text(),'How it Works')]";
	String BTS_Inkbox = "//div[@id='nav-links']/div/a[contains(text(),'BTS | Inkbox')]";

	// navbar items
	String logo = "//a[@id='logo']";
	String Search_textbox = "//input[@id='search-field-input']";
	String wishlist = "//a[@id='nav-wishlist']";
	String Cart = "//div[@id='cartTotal']";

	// footer
//	 String about_ink= "//*[@id=\"site-content\"]/main/footer/div/div[1]/div/div[2]/div[1]/div[1]/h4)]";

	String our_storys = "//*[@id=\"site-content\"]/main/footer/div/div[1]/div/div[2]/div[1]/div[1]/ul/li[1]/a";

	String Our_Story = "//a[contains(text(),'Our Story')]";
	String Reviews = "//a[contains(text(),'Reviews')]";
	String Carrers = "//a[contains(text(),' Careers')]";
	String Press = "//a[contains(text(),' Press')]";
	String Shipping = "//a[contains(text(),' Shipping')]";
	String Returns = "//a[contains(text(),' Returns')]";
	String Help_FAQ = "(//a[contains(text(),'Help & FAQ')])[2]";
	String ContactUs = "(//a[contains(text(),'Contact Us')])[2]";
	String Partnerships = "//a[contains(text(),'Partnerships')]";
	String Bulk_Orders = "//a[contains(text(),'Bulk Orders')";
	String StudentDiscount = "(//a[contains(text(),'Student Discount')])[3]";
	String AffiliateProgram = "//a[contains(text(),'Affiliate Program')]";

	String productsList = "//div[@id='search-list']/descendant::a";

	public void AcctountIcon() {
		try {
			ControlHelpers.ButtonClick(By.xpath(Login_Button));
			test.log(LogStatus.INFO, "Clicked on Account Icon");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.fillInStackTrace());
			test.log(LogStatus.ERROR, e.getMessage());
		}

	}
	
	public void Click_On_Shop() {
		ControlHelpers.ButtonClick(By.xpath(Shop));
	}

	public void EnterTextInsearchBox(String searchProduct) {
		searchtext = searchProduct;
		ControlHelpers.ButtonClick(By.xpath(Search_textbox));
		ControlHelpers.Entertext(By.xpath(Search_textbox), searchProduct);
		test.log(LogStatus.INFO, "Searching for :" + searchProduct);

	}

	public void AutoSuggestValidation() {
		List<WebElement> elements = ControlHelpers.getElementsList(By.xpath(productsList));

		for (WebElement webElement : elements) {

			String expecstring = webElement.getText();
			if (expecstring.contains(searchtext)) {
				test.log(LogStatus.INFO, expecstring + " : is validated");
				// System.out.println(webElement.getText());
			} else {
				test.log(LogStatus.ERROR, expecstring + " : is validated");
			}

		}

	}

	public String VerifyAccount() {
		String account_buttonText = ControlHelpers.getText(By.xpath(Login_Button));

		return account_buttonText;
	}
}
