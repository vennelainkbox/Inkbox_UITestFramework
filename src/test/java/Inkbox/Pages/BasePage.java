package Inkbox.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;
import Helpers.LaunchDriver;
import Helpers.Screenshots;

public class BasePage {
	ExtentTest test;

	public BasePage(ExtentTest test) {

		this.test = test;
		ControlHelpers controlHelpers = new ControlHelpers(test);
	}

	// local veriables
	String searchtext;
	String presentUrl;
	String previousUrl;

	// search items
	String SortBy = "//button[@id='options-menu']";

	// Header paths
	String Student_discount = "//*[@id='header-student']/a[text()='Student Discount']";
	String Rewards = "//*[@id=\"header-rewards\"]/a[text()='Rewards']";
	String Help = "//div[@id='header-help']/button/span[text()='Help']";
	String Login_Button = "//*[@id='header-user']/button";

	String Shop = "//div[@id='nav-links']/div/a[contains(text(),'Shop')]";
	String TattooQuiz = "//div[@id='nav-links']/div/a[contains(text(),'Tattoo Quiz')]";
	String Custom = "//div[@id='nav-links']/div/a[contains(text(),'Custom')]";
	String Collabs = "//div[@id='nav-links']/div/a[contains(text(),'Collabs')]";
	String Trending = "//div[@id='nav-links']/div/a[contains(text(),'Trending')]";
	String Sale = "//div[@id='nav-links']/div/a[contains(text(),'Sale')]";
	String How_It_Work = "//div[@id='nav-links']/div/a[contains(text(),'How it Works')]";
	String BTS_Inkbox = "//div[@id='nav-links']/div/a[contains(text(),'BTS | Inkbox')]";

	// profile

	String UserImage = "//div[@id='profile']/descendant::div/img";
	String ChangePhoto = "//div[@id='profile']/descendant::p/label";
	String ChangePassword = "//div[@id='profile']/descendant::a[text()='Change Password']";
	String OldPassword = "//input[@id='currentPassword']";
	String NewPassword = "//input[@id='newPassword']";
	String Confirmpassword = "//input[@id='confirmPassword']";
	String Save = "//button[text()='Save']";
	String succesMsg = "//div[@x-show='showAlert']/descendant::h3[contains(text(),'Success')]";

	String Logout = "//button[text()='Logout']";

	// Menu Items

	String MyRewards = "//div[@id='header-user']/descendant::a[contains(text(),'My Rewards')]";
	String MyFavorites = "//div[@id='header-user']/descendant::a[contains(text(),'My Favorites')]";
	String OrderHistory = "//div[@id='header-user']/descendant::a[contains(text(),'Order History')]";
	String YourProfile = "//div[@id='header-user']/descendant::a[contains(text(),'Your Profile')]";

	// navbar items
	String logo = "//a[@id='logo']";
	String Search_textbox = "//input[@id='search-field-input']";
	String wishlist = "//a[@id='nav-wishlist']";
	String Cart = "//div[@id='cartTotal']";

	// footer
//	 String about_ink= "//*[@id=\"site-content\"]/main/footer/div/div[1]/div/div[2]/div[1]/div[1]/h4)]";
	String CustomersSay = "//span[@id='translations-customerssay']";
	String Score = "//div[@id='trust-score']";
	String Rating_box = "//a[@id='tp-widget-stars']/div";
	String Email_Textbox = "//input[@id='subscribe_email_default']";
	String instagram = "(//a/span[text()='Instagram']/parent::a)[1]";
	String Pinterest = "((//a/span[text()='Instagram']/parent::a)[1]/following-sibling::a)[1]";
	String Facebook = "(//a/span[text()='Facebook']/parent::a)[1]";
	String YouTube = "((//a/span[text()='Instagram']/parent::a)[1]/following-sibling::a)[3]";
	String Twitter = "(//a/span[text()='Twitter']/parent::a)[1]";
	String Tiktok = "((//a/span[text()='Instagram']/parent::a)[1]/following-sibling::a)[5]";
	String Get_free_tattoos = "//span[contains(text(),'get free tattoos')]";
	String Terms_of_Service = "(//div[contains(@class,'bottom-container')]/descendant::a[text()='Terms of Service'])[1]";
	String Privacy_Policy = "(//div[contains(@class,'bottom-container')]/descendant::a[text()='Privacy Policy'])[1]";

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

	// profilepage
	String Inkbox_balance = "//form[@id='profile_form']/descendant::p[text()='Inkbucks Balance']";
	String Inkbucks = "//form[@id='profile_form']/descendant::p[text()='150 inkbucks']";
	String RewardsChapter = "//form[@id='profile_form']/descendant::p[text()='Rewards Chapter']";
	String Chapter = "//form[@id='profile_form']/descendant::p[text()='Chapter 1']";
	String Redeem_Rewards = "//form[@id='profile_form']/descendant::button[contains(text(),'Redeem Rewards')]";
	String Name_textbox = "//input[@name='name']";
	String Email_textbox = "//input[@name='email']";
	String Sign_up_Checkbox = "//div[@id='profile']/descendant::input[@type='checkbox']";

	public void AcctountIcon() {
		try {
			ControlHelpers.ButtonClick(By.xpath(Login_Button));
			// test.log(LogStatus.INFO, "Clicked on Account Icon");
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Searching for :" + searchProduct);

	}

	public void AutoSuggestValidation() {
		SoftAssert softAssert=new SoftAssert();
		List<WebElement> elements = ControlHelpers.getElementsList(By.xpath(productsList));

		for (WebElement webElement : elements) {

			String expecstring = webElement.getText();
			if (expecstring.contains(searchtext)) {
				test.log(LogStatus.INFO, expecstring + " : is validated");
			} else {
				test.log(LogStatus.ERROR, "Searching for :"+searchtext+" but getting value :"+expecstring);
				softAssert.fail();
			}

		}
		softAssert.assertAll();

	}

	public boolean VerifyAccountLogin() {

//		String account_buttonText=ControlHelpers.WaitForElementAndGetText(By.xpath(Login_Button));
//		return account_buttonText;

		return ControlHelpers.IsElementVisible(By.xpath(Login_Button));

	}

	public void VerifyUserImage_Is_Changing_Or_Not() throws AWTException, InterruptedException {
		ClickOnMyAccount();
		ClickOnYourProfile();

		System.out.println("Image present :"
				+ ControlHelpers.IsElementVisible(By.xpath("//form[@id='profile_form']/descendant::img")));
		ControlHelpers.ButtonClick(By.xpath(ChangePhoto));

		Thread.sleep(3000);
		String driverpath = System.getProperty("user.dir");
		StringSelection ss = new StringSelection(driverpath + "\\Resources\\inkboxImage1.jpg");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// Ctrl + v
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);

		Thread.sleep(3000);
		ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(Save));
		Thread.sleep(5000);
		String path = null;
		try {
			path = Screenshots.takeScreenshot(ControlHelpers.GetDriver(), "Upload_Profile_Image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.log(LogStatus.INFO, "Profile image Updated");
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.PASS, "Profile image Updated", imagePath);
		
		ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(Logout));
		Thread.sleep(5000);
		LoginPage loginPage = new LoginPage(test);
		loginPage.Login();
		
		
		ClickOnMyAccount();
		ClickOnYourProfile();
		ControlHelpers.ButtonClick(By.xpath(ChangePhoto));
		Thread.sleep(3000);
		StringSelection ss2 = new StringSelection(driverpath + "\\Resources\\inkboxImage2.jpg");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss2, null);

		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);
		String path2 = null;
		try {
			path2 = Screenshots.takeScreenshot(ControlHelpers.GetDriver(), "Change_Profile_Image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Profile image Changed");
		String imagePath2 = test.addScreenCapture(path2);
		test.log(LogStatus.PASS, "Profile image Changed", imagePath2);
		

	}

	public void Logout() {
		ClickOnMyAccount();
		ClickOnYourProfile();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(Logout));
	}

	public void verifyChangePassword() {
		ClickOnMyAccount();
		ClickOnYourProfile();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ControlHelpers.MoveToElementAndClick(By.xpath(ChangePassword));

		String oldpassword = LaunchDriver.getPassword();
		String oldpasswordText = null;
		String newpasswordtext = null;

		if (oldpassword.equalsIgnoreCase("Test@123")) {

			LaunchDriver.setPassword("Test@1234");
			oldpasswordText = "Test@123";
			newpasswordtext = "Test@1234";
			LaunchDriver.setpassword_configFile(newpasswordtext);
		} else if (oldpassword.equalsIgnoreCase("Test@1234")) {
			LaunchDriver.setPassword("Test@123");
			oldpasswordText = "Test@1234";
			newpasswordtext = "Test@123";
			LaunchDriver.setpassword_configFile(newpasswordtext);
		}

		ControlHelpers.Entertext(By.xpath(OldPassword), oldpasswordText);
		ControlHelpers.Entertext(By.xpath(NewPassword), newpasswordtext);
		ControlHelpers.Entertext(By.xpath(Confirmpassword), newpasswordtext);
		ControlHelpers.ButtonClick(By.xpath(Save));

		boolean status = ControlHelpers.IsElementVisible(By.xpath(succesMsg));
		if (status) {
			test.log(LogStatus.PASS, "Password changed succesfully to :" + newpasswordtext);
		} else {
			test.log(LogStatus.ERROR, "Unnable to change password");
			Assert.fail("Unnable to change password");
		}

//		boolean visiblility = ControlHelpers.IsElementVisible(By.xpath(ChangePassword));
//		
//		if (!visiblility) {
//			test.log(LogStatus.ERROR, "Change Password is not verified");
//
//		} else {
//			test.log(LogStatus.PASS, "Change Password is  verified");
//		}
	}

	public void ValidateSearchResults() {
		ControlHelpers.ButtonClick(By.xpath(Search_textbox));
		ControlHelpers.Entertext(By.xpath(Search_textbox), "flowers");
		ControlHelpers.getElement(By.xpath(Search_textbox)).sendKeys(Keys.ENTER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String URL_flowers=ControlHelpers.GetCurrentUrl();
		if(URL_flowers.contains("flowers"))
		{
			test.log(LogStatus.PASS, "Searching for Flowers and it is redirected to :"+URL_flowers);
		}
		else {
			test.log(LogStatus.ERROR, "Searching for Flowers and it is redirected to :"+URL_flowers);
		}
		
		ControlHelpers.ButtonClick(By.xpath(Search_textbox));
		ControlHelpers.Entertext(By.xpath(Search_textbox), "insects");
		ControlHelpers.getElement(By.xpath(Search_textbox)).sendKeys(Keys.ENTER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String URL_insects=ControlHelpers.GetCurrentUrl();
		if(URL_insects.contains("insects"))
		{
			test.log(LogStatus.PASS, "Searching for Insects and it is redirected to :"+URL_insects);
		}
		else {
			test.log(LogStatus.ERROR, "Searching for Insects and it is redirected to :"+URL_insects);
		}
		
		ControlHelpers.ButtonClick(By.xpath(Search_textbox));
		ControlHelpers.Entertext(By.xpath(Search_textbox), "quotes");
		ControlHelpers.getElement(By.xpath(Search_textbox)).sendKeys(Keys.ENTER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String URL_quotes=ControlHelpers.GetCurrentUrl();
		if(URL_quotes.contains("quotes"))
		{
			test.log(LogStatus.PASS, "Searching for quotes and it is redirected to :"+URL_insects);
		}
		else {
			test.log(LogStatus.ERROR, "Searching for quotes and it is redirected to :"+URL_insects);
		}
	}
	public void validate_SearchBox_Acceptence() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EnterTextInsearchBox("Test@product1");
		String textboxtext = ControlHelpers.getTextBox_Text(By.xpath(Search_textbox));
		if (textboxtext.equalsIgnoreCase("Test@product1")) {
			test.log(LogStatus.PASS, "SearchBox accepting character,number and special character");
		} else {
			test.log(LogStatus.ERROR, "SearchBox not accepting character,number and special character");
		}
		// System.out.println("TextBox text :"+textboxtext);

	}

	public void ClickOnMyAccount() {
		ControlHelpers.ButtonClick(By.xpath(Login_Button));
	}

	public void ClickOnYourProfile() {
		ControlHelpers.ButtonClick(By.xpath(YourProfile));

	}

	public void Validate_PresentURL_With_PreviousURL() {

		Click_On_Shop();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		presentUrl = ControlHelpers.GetDriver().getCurrentUrl();
		// test.log(LogStatus.INFO, "Present URL :"+presentUrl);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControlHelpers.GetDriver().navigate().back();
		previousUrl = ControlHelpers.GetDriver().getCurrentUrl();
		// test.log(LogStatus.INFO, "Previous URL :"+previousUrl);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControlHelpers.GetDriver().navigate().forward();
		if (presentUrl.equalsIgnoreCase(ControlHelpers.GetDriver().getCurrentUrl())) {
			test.log(LogStatus.PASS, "Navigate to Present Url after get back to previous Url");
		} else {
			test.log(LogStatus.ERROR, "Unnable to Navigate to Present Url after get back to previous Url");
			Assert.fail();
		}

	}

	public void Vadidating_Header() {
		List<WebElement> elements = ControlHelpers.getElementsList(By.xpath("//div[@id='nav-links']/div/a"));
		String[] headerArray = { "SHOP", "TATTOO QUIZ", "CUSTOM", "COLLABS", "TRENDING", "FREEHAND INK", "SALE",
				"HOW IT WORKS", "BTS | INKBOX" };
		for (int i = 0; i < headerArray.length; i++) {
			int visible = 0;
			for (int j = 1; j < elements.size(); j++) {
				int k = j + 1;
				String xpath = "(//div[@id='nav-links']/div/a)[" + k + "]";
				String elementName = ControlHelpers.getText(By.xpath(xpath));
				if (elementName.equalsIgnoreCase(headerArray[i])) {
					// System.out.println(elementName);
					visible = 1;
				}
			}
			if (visible == 1) {
				test.log(LogStatus.PASS, headerArray[i] + " : is visible on Menubar");
			} else {
				test.log(LogStatus.FAIL, headerArray[i] + " : is not visible on Menubar");
			}
		}
	}

	public void ValidateFooter() {
		Validate_About_Linkbox_Footer();
		Validate_Customer_Care_Footer();
		Validate_Other_Footer();
		Validate_Email_Textbox_Footer();
		Validate_InstagramLink_Footer();
		Validate_PinterestLink_Footer();
		Validate_FacebookLink_Footer();
		Validate_TwitterLink_Footer();
		Tiktok_TwitterLink_Footer();
		Validate_GetFreeTattoos_Footer();
		Validate_Privacy_Policy_Footer();
		Validate_Terms_of_Service_Footer();
//		Validate_Rating_box_Footer();
				
	}
	public void Validate_Shop_Menubar() {
		ControlHelpers.HoverOver(By.xpath(Shop));
		String[] Shop_Array = { "Best Sellers", "New Tattoos", "Picked For You", "Instagram","Bundles" };
		
		List<WebElement> Shop_elements = ControlHelpers.getElementsList(By.xpath("//li[@class='menu-L1']/ul/span[text()='Shop']/following-sibling::li/a"));
		for (int i = 0; i < Shop_Array.length; i++)
		{
			String elementName = null;
			String Url = null;
			int visible = 0;
			for (int j = 0; j < Shop_elements.size(); j++)
			{
				int k = j + 1;
				String xpath = "(//li[@class='menu-L1']/ul/span[text()='Shop']/following-sibling::li/a)[" + k + "]";
			    elementName = ControlHelpers.getText(By.xpath(xpath));
			    if (elementName.equalsIgnoreCase(Shop_Array[i]))
			    {
			    	visible = 1;
			    	break;
			    }
			}
			if (visible == 1) 
			{
				test.log(LogStatus.PASS, Shop_Array[i] + " : is  visible under Shop");
			}
			else {
				test.log(LogStatus.PASS, Shop_Array[i] + " : is  visible under Shop");
			}
		}

		
	}
	
	// Terms_of_Service validation
		public void Validate_Terms_of_Service_Footer() {
			int Terms_of_Service_status = ControlHelpers.IsElementPresent(By.xpath(Terms_of_Service));
			if (Terms_of_Service_status > 0) {
				test.log(LogStatus.PASS, "Terms of Service is visible on Footer");
			} else {
				test.log(LogStatus.FAIL, "Terms of Service is not visible on Footer");
			}
		}
	
	// Privacy_Policy validation
		public void Validate_Privacy_Policy_Footer() {
			int Privacy_Policy_status = ControlHelpers.IsElementPresent(By.xpath(Privacy_Policy));
			if (Privacy_Policy_status > 0) {
				test.log(LogStatus.PASS, "Privacy Policy is visible on Footer");
			} else {
				test.log(LogStatus.FAIL, "Privacy Policy is not visible on Footer");
			}
		}
	
	public void Validate_GetFreeTattoos_Footer() {
		ControlHelpers.SwitchToFrame("talkable-offer-iframe");
		int Get_free_tattoos_status = ControlHelpers.IsElementPresent(By.xpath(Get_free_tattoos));
		if (Get_free_tattoos_status > 0) {
			test.log(LogStatus.INFO, "GET FREE TATTOOS is visible on Footer");
			ControlHelpers.ButtonClick(By.xpath(Get_free_tattoos));
			ControlHelpers.SwitchToDefault();
			ControlHelpers.SwitchToFrame("talkable-offer-iframe-popup");
			int Get_free_tattoos_page_status = ControlHelpers.IsElementPresent(
					By.xpath("//div[@class='content']/descendant::h1[contains(text(),'Get a Free Tattoo')]"));
			if (Get_free_tattoos_page_status > 0) {
				test.log(LogStatus.PASS, "GET FREE TATTOOS page  is visible when clicked on GetFreeTattoos button.");
				ControlHelpers.ButtonClick(By.xpath("//div[@class='popup-close js-offer-close is-solid']"));
				ControlHelpers.SwitchToDefault();
			} else {
				test.log(LogStatus.ERROR,
						"GET FREE TATTOOS page  is not visible when clicked on GetFreeTattoos button.");
			}
//			String etext=ControlHelpers.getText(By.xpath("//div[@class='content']/descendant::h1[contains(text(),'Get a Free Tattoo')]"));
//			System.out.println(etext);
		} else {
			test.log(LogStatus.FAIL, "GET FREE TATTOOS is not visible on Footer");
		}
	}

	// Email textbox validation
	public void Validate_Email_Textbox_Footer() {

		int Email_Textbox_status = ControlHelpers.IsElementPresent(By.xpath(Email_Textbox));
		if (Email_Textbox_status > 0) {
			test.log(LogStatus.PASS, "Enter Email textbox is visible on Footer");
		} else {
			test.log(LogStatus.FAIL, "Enter Email textbox is not visible on Footer");
		}
	}
	//Tiktok_status link Validation
	public void Tiktok_TwitterLink_Footer()
	{
		
		int Tiktok_status = ControlHelpers.IsElementPresent(By.xpath(Tiktok));
		if (Tiktok_status > 0) {
			String URL=null;
			test.log(LogStatus.INFO, "Tiktok link is visible on Footer");
			ControlHelpers.ButtonClick(By.xpath(Tiktok));
			String parentWindow = ControlHelpers.GetDriver().getWindowHandle();
			Set<String> handles =  ControlHelpers.GetDriver().getWindowHandles();
			   for(String windowHandle  : handles)
			       {
			       if(!windowHandle.equals(parentWindow))
			          {
			    	   ControlHelpers.GetDriver().switchTo().window(windowHandle);
			    	   URL=ControlHelpers.GetDriver().getCurrentUrl();
			       //  <!--Perform your operation here for new window-->
			    	   ControlHelpers.GetDriver().close(); //closing child window
			         ControlHelpers.GetDriver().switchTo().window(parentWindow); //cntrl to parent window
			          }
			       }
			if(URL.contains("https://www.tiktok.com/"))
			{
				test.log(LogStatus.PASS,"Tiktok link is redirected to :"+URL);
			}
			else {
				test.log(LogStatus.FAIL,"Tiktok link is not redirected to :"+URL);
			}
		} else {
			test.log(LogStatus.FAIL, "Tiktok link is not visible on Footer");
		}
	}
	//Twitter_status link Validation
	public void Validate_TwitterLink_Footer()
	{
		
		int Twitter_status = ControlHelpers.IsElementPresent(By.xpath(Twitter));
		if (Twitter_status > 0) {
			String URL=null;
			test.log(LogStatus.INFO, "Twitter link is visible on Footer");
			ControlHelpers.ButtonClick(By.xpath(Twitter));
			String parentWindow = ControlHelpers.GetDriver().getWindowHandle();
			Set<String> handles =  ControlHelpers.GetDriver().getWindowHandles();
			   for(String windowHandle  : handles)
			       {
			       if(!windowHandle.equals(parentWindow))
			          {
			    	   ControlHelpers.GetDriver().switchTo().window(windowHandle);
			    	   URL=ControlHelpers.GetDriver().getCurrentUrl();
			       //  <!--Perform your operation here for new window-->
			    	   ControlHelpers.GetDriver().close(); //closing child window
			         ControlHelpers.GetDriver().switchTo().window(parentWindow); //cntrl to parent window
			          }
			       }
			if(URL.contains("https://twitter.com/getinkbox"))
			{
				test.log(LogStatus.PASS,"Twitter link is redirected to :"+URL);
			}
			else {
				test.log(LogStatus.FAIL,"Twitter link is not redirected to :"+URL);
			}
		} else {
			test.log(LogStatus.FAIL, "Twitter link is not visible on Footer");
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//YouTube_status link Validation
	public void Validate_YouTubeLink_Footer()
	{
		
		int YouTube_status = ControlHelpers.IsElementPresent(By.xpath(YouTube));
		if (YouTube_status > 0) {
			String URL=null;
			test.log(LogStatus.INFO, "YouTube link is visible on Footer");
			ControlHelpers.ButtonClick(By.xpath(YouTube));
			String parentWindow = ControlHelpers.GetDriver().getWindowHandle();
			Set<String> handles =  ControlHelpers.GetDriver().getWindowHandles();
			   for(String windowHandle  : handles)
			       {
			       if(!windowHandle.equals(parentWindow))
			          {
			    	   ControlHelpers.GetDriver().switchTo().window(windowHandle);
			    	   URL=ControlHelpers.GetDriver().getCurrentUrl();
			       //  <!--Perform your operation here for new window-->
			    	   ControlHelpers.GetDriver().close(); //closing child window
			         ControlHelpers.GetDriver().switchTo().window(parentWindow); //cntrl to parent window
			          }
			       }
			if(URL.contains("https://www.youtube.com/channel/"))
			{
				test.log(LogStatus.PASS,"YouTube link is redirected to :"+URL);
			}
			else {
				test.log(LogStatus.FAIL,"YouTube link is not redirected to :"+URL);
			}
		} else {
			test.log(LogStatus.FAIL, "YouTube link is not visible on Footer");
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Facebook_status link Validation
	public void Validate_FacebookLink_Footer()
	{
		
		int Facebook_status = ControlHelpers.IsElementPresent(By.xpath(Facebook));
		if (Facebook_status > 0) {
			String URL=null;
			test.log(LogStatus.INFO, "Facebook link is visible on Footer");
			ControlHelpers.ButtonClick(By.xpath(Facebook));
			String parentWindow = ControlHelpers.GetDriver().getWindowHandle();
			Set<String> handles =  ControlHelpers.GetDriver().getWindowHandles();
			   for(String windowHandle  : handles)
			       {
			       if(!windowHandle.equals(parentWindow))
			          {
			    	   ControlHelpers.GetDriver().switchTo().window(windowHandle);
			    	   URL=ControlHelpers.GetDriver().getCurrentUrl();
			       //  <!--Perform your operation here for new window-->
			    	   ControlHelpers.GetDriver().close(); //closing child window
			         ControlHelpers.GetDriver().switchTo().window(parentWindow); //cntrl to parent window
			          }
			       }
			if(URL.contains("https://www.facebook.com"))
			{
				test.log(LogStatus.PASS,"Facebook link is redirected to :"+URL);
			}
			else {
				test.log(LogStatus.FAIL,"Facebook link is not redirected to :"+URL);
			}
		} else {
			test.log(LogStatus.FAIL, "Facebook link is not visible on Footer");
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//Pinterest_status link Validation
	public void Validate_PinterestLink_Footer()
	{
		
		int Pinterest_status = ControlHelpers.IsElementPresent(By.xpath(Pinterest));
		if (Pinterest_status > 0) {
			String URL=null;
			test.log(LogStatus.INFO, "Pinterest link is visible on Footer");
			ControlHelpers.ButtonClick(By.xpath(Pinterest));
			String parentWindow = ControlHelpers.GetDriver().getWindowHandle();
			Set<String> handles =  ControlHelpers.GetDriver().getWindowHandles();
			   for(String windowHandle  : handles)
			       {
			       if(!windowHandle.equals(parentWindow))
			          {
			    	   ControlHelpers.GetDriver().switchTo().window(windowHandle);
			    	   URL=ControlHelpers.GetDriver().getCurrentUrl();
			       //  <!--Perform your operation here for new window-->
			    	   ControlHelpers.GetDriver().close(); //closing child window
			         ControlHelpers.GetDriver().switchTo().window(parentWindow); //cntrl to parent window
			          }
			       }
			if(URL.contains("https://www.pinterest.ca/"))
			{
				test.log(LogStatus.PASS,"pinterest link is redirected to :"+URL);
			}
			else {
				test.log(LogStatus.FAIL,"pinterest link is not redirected to :"+URL);
			}
		} else {
			test.log(LogStatus.FAIL, "pinterest link is not visible on Footer");
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Instagram link Validation
	public void Validate_InstagramLink_Footer() {
		// Instagram link Validation
		int instagram_status = ControlHelpers.IsElementPresent(By.xpath(instagram));
		if (instagram_status > 0) {
			String URL = null;
			test.log(LogStatus.INFO, "Instagram link is visible on Footer");
			ControlHelpers.ButtonClick(By.xpath(instagram));
			String parentWindow = ControlHelpers.GetDriver().getWindowHandle();
			Set<String> handles = ControlHelpers.GetDriver().getWindowHandles();
			for (String windowHandle : handles) {
				if (!windowHandle.equals(parentWindow)) {
					ControlHelpers.GetDriver().switchTo().window(windowHandle);
					URL = ControlHelpers.GetDriver().getCurrentUrl();
					// <!--Perform your operation here for new window-->
					ControlHelpers.GetDriver().close(); // closing child window
					ControlHelpers.GetDriver().switchTo().window(parentWindow); // cntrl to parent window
				}
			}

			if (URL.contains("https://www.instagram.com")) {
				test.log(LogStatus.PASS, "Instagram link is redirected to :" + URL);
			} else {
				test.log(LogStatus.FAIL, "Instagram link is not redirected to :" + URL);
			}
		} else {
			test.log(LogStatus.FAIL, "Instagram link is not visible on Footer");
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Validate_About_Linkbox_Footer() {
		// About Linkbox validation
		ControlHelpers
				.MoveToElement(By.xpath("//h4[contains(text(),'About Inkbox')]/following-sibling::ul/descendant::a"));

		String[] About_Inkbox_Array = { "Our Story", "Reviews", "Careers", "Press" };
		List<WebElement> About_Inkbox_elements = ControlHelpers
				.getElementsList(By.xpath("//h4[contains(text(),'About Inkbox')]/following-sibling::ul/descendant::a"));
		for (int i = 0; i < About_Inkbox_Array.length; i++) {
			String elementName = null;
			String Url = null;
			int visible = 0;
			for (int j = 0; j < About_Inkbox_elements.size(); j++) {
				int k = j + 1;
				String xpath = "(//h4[contains(text(),'About Inkbox')]/following-sibling::ul/descendant::a)[" + k + "]";
				elementName = ControlHelpers.getText(By.xpath(xpath));

				if (elementName.equalsIgnoreCase(About_Inkbox_Array[i])) {
					visible = 1;
					ControlHelpers.ButtonClick(By.xpath(xpath));
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Url = ControlHelpers.GetDriver().getCurrentUrl();
					ControlHelpers.GetDriver().navigate().back();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			String ename = elementName;
			elementName = elementName.toLowerCase().replace(" ", "").replace("-", "");
			String correntURL = Url;
			Url = Url.toLowerCase().replace(" ", "").replace("-", "");
			if (visible == 1) {
				if (Url.contains(elementName)) {
					test.log(LogStatus.PASS, ename + " : under About Inkbox is redirected to :" + correntURL);
				} else {
					test.log(LogStatus.FAIL, ename + " : under About Inkbox is redirected to :" + correntURL);
				}
			} else {
				test.log(LogStatus.FAIL, About_Inkbox_Array[i] + " : is not visible on Footer");
			}
		}
	}

	public void Validate_Customer_Care_Footer() {

		// Customer Care Validation

		String[] Customer_Care_Array = { "Shipping", "Returns", "Help & FAQ", "Contact Us" };
		List<WebElement> Customer_Care_elements = ControlHelpers.getElementsList(
				By.xpath("//h4[contains(text(),'Customer Care')]/following-sibling::ul/descendant::a"));
		for (int i = 0; i < Customer_Care_Array.length; i++) {
			String elementName = null;
			String Url = null;
			int visible = 0;
			for (int j = 0; j < Customer_Care_elements.size(); j++) {
				int k = j + 1;
				String xpath = "(//h4[contains(text(),'Customer Care')]/following-sibling::ul/descendant::a)[" + k
						+ "]";
				elementName = ControlHelpers.getText(By.xpath(xpath));

				if (elementName.equalsIgnoreCase(Customer_Care_Array[i])) {
					visible = 1;
					ControlHelpers.ButtonClick(By.xpath(xpath));
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Url = ControlHelpers.GetDriver().getCurrentUrl();
					ControlHelpers.GetDriver().navigate().back();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}

			}
			String ename = elementName;
			elementName = elementName.toLowerCase().replace(" ", "").replace("-", "");
			String correntURL = Url;
			Url = Url.toLowerCase().replace(" ", "").replace("-", "");
			if (visible == 1) {
				if (ename.equalsIgnoreCase("Help & FAQ") || ename.equalsIgnoreCase("Contact Us")) {
					if (correntURL.contains("https://help.inkbox.com/")) {
						test.log(LogStatus.PASS, ename + " : under Customer Care is redirected to :" + correntURL);
					} else {
						test.log(LogStatus.FAIL, ename + " : under Customer Care is redirected to :" + correntURL);
					}
				} else {
					if (Url.contains(elementName)) {
						test.log(LogStatus.PASS, ename + " : under Customer Care is redirected to :" + correntURL);
					} else {
						test.log(LogStatus.FAIL, ename + " : under Customer Care is redirected to :" + correntURL);
					}
				}

			} else {
				test.log(LogStatus.FAIL, Customer_Care_Array[i] + " : is not visible on Footer");
			}
		}
	}

	public void Validate_Other_Footer() {
		// Other Validation
		String[] Other_Array = { "Partnerships", "Bulk Orders", "Student Discount", "Affiliate Program" };
		List<WebElement> Other_elements = ControlHelpers
				.getElementsList(By.xpath("//h4[contains(text(),'Other')]/following-sibling::ul/descendant::a"));
		for (int i = 0; i < Other_Array.length; i++) {
			String elementName = null;
			String Url = null;
			int visible = 0;
			for (int j = 0; j < Other_elements.size(); j++) {
				int k = j + 1;
				String xpath = "(//h4[contains(text(),'Other')]/following-sibling::ul/descendant::a)[" + k + "]";
				elementName = ControlHelpers.getText(By.xpath(xpath));

				if (elementName.equalsIgnoreCase(Other_Array[i])) {
					visible = 1;
					ControlHelpers.ButtonClick(By.xpath(xpath));
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Url = ControlHelpers.GetDriver().getCurrentUrl();
					ControlHelpers.GetDriver().navigate().back();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			String ename = elementName;
			elementName = elementName.toLowerCase().replace(" ", "").replace("-", "");
			String correntURL = Url;
			Url = Url.toLowerCase().replace(" ", "").replace("-", "");
			if (visible == 1) {
				if (ename.equalsIgnoreCase("Affiliate Program")) {
					if (correntURL.contains("https://signup.linkshare.com/publishers/registration/")) {
						test.log(LogStatus.PASS, ename + " : under Others is redirected to :" + correntURL);
					} else {
						test.log(LogStatus.FAIL, ename + " : under Others is redirected to :" + correntURL);
					}
				} else {
					if (Url.contains(elementName)) {
						test.log(LogStatus.PASS, ename + " : under Others is redirected to :" + correntURL);
					} else {
						test.log(LogStatus.FAIL, ename + " : under Others is redirected to :" + correntURL);
					}
				}

			} else {
				test.log(LogStatus.FAIL, Other_Array[i] + " : is not visible on Footer");
			}
		}

	}

	public void Validating_MenuItems() {
		ControlHelpers.ButtonClick(By.xpath(Login_Button));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int yourProfile_status = ControlHelpers.IsElementPresent(By.xpath(YourProfile));
		if (yourProfile_status > 0) {
			test.log(LogStatus.PASS, "Your Profile is visible on Manubar");
		} else {
			test.log(LogStatus.FAIL, "Your Profile is not visible on Manubar");
		}

		int orderhistory_status = ControlHelpers.IsElementPresent(By.xpath(OrderHistory));
		if (orderhistory_status > 0) {
			test.log(LogStatus.PASS, "OrderHistory is visible on Manubar");
		} else {
			test.log(LogStatus.FAIL, "OrderHistory is not visible on Manubar");
		}

		int MyRewards_status = ControlHelpers.IsElementPresent(By.xpath(MyRewards));
		if (MyRewards_status > 0) {
			test.log(LogStatus.PASS, "My Rewards is visible on Manubar");
		} else {
			test.log(LogStatus.FAIL, "My Rewards is not visible on Manubar");
		}

		int MyFavorites_status = ControlHelpers.IsElementPresent(By.xpath(MyFavorites));
		if (MyFavorites_status > 0) {
			test.log(LogStatus.PASS, "My Favorites is visible on Manubar");
		} else {
			test.log(LogStatus.FAIL, "My Favorites is not visible on Manubar");
		}

	}

	public void Validating_NavBar() {
		int studentdiscount_status = ControlHelpers.IsElementPresent(By.xpath(Student_discount));
		if (studentdiscount_status > 0) {
			test.log(LogStatus.PASS, "Student Discount button is visible on Navbar");
		} else {
			test.log(LogStatus.FAIL, "Student Discount button is not visible on Navbar");
		}

		int help_status = ControlHelpers.IsElementPresent(By.xpath(Help));
		if (help_status > 0) {
			test.log(LogStatus.PASS, "Help button is visible on Navbar");
		} else {
			test.log(LogStatus.FAIL, "Help button is not visible on Navbar");
		}

		int UserIcon_status = ControlHelpers.IsElementPresent(By.xpath(Login_Button));
		if (UserIcon_status > 0) {
			test.log(LogStatus.PASS, "UserAccount button is visible on Navbar");
		} else {
			test.log(LogStatus.FAIL, "UserAccount button is not visible on Navbar");
		}

	}

	public void ValidateProfile() {
		ClickOnMyAccount();
		ClickOnYourProfile();
		int Inkbox_balance_status = ControlHelpers.IsElementPresent(By.xpath(Inkbox_balance));
		if (Inkbox_balance_status > 0) {
			test.log(LogStatus.PASS, "Inkbox balance is visible on Profile page");
		} else {
			test.log(LogStatus.FAIL, "Inkbox balance is not visible on Profile page");
		}

		int Inkbucks_status = ControlHelpers.IsElementPresent(By.xpath(Inkbucks));
		if (Inkbucks_status > 0) {
			test.log(LogStatus.PASS, "Inkbucks is visible on Profile page");
		} else {
			test.log(LogStatus.FAIL, "Inkbucks is not visible on Profile page");
		}

		int RewardsChapter_status = ControlHelpers.IsElementPresent(By.xpath(RewardsChapter));
		if (RewardsChapter_status > 0) {
			test.log(LogStatus.PASS, "RewardsChapter is visible on Profile page");
		} else {
			test.log(LogStatus.FAIL, "RewardsChapter is not visible on Profile page");
		}

		int Chapter_status = ControlHelpers.IsElementPresent(By.xpath(Chapter));
		if (Chapter_status > 0) {
			test.log(LogStatus.PASS, "Chapter is visible on Profile page");
		} else {
			test.log(LogStatus.FAIL, "Chapter is not visible on Profile page");
		}

		int Redeem_Rewards_status = ControlHelpers.IsElementPresent(By.xpath(Redeem_Rewards));
		if (Redeem_Rewards_status > 0) {
			test.log(LogStatus.PASS, "Redeem_Rewards is visible on Profile page");
		} else {
			test.log(LogStatus.FAIL, "Redeem_Rewards is not visible on Profile page");
		}

		int Name_textbox_status = ControlHelpers.IsElementPresent(By.xpath(Name_textbox));
		if (Name_textbox_status > 0) {
			test.log(LogStatus.PASS, "First&Last Name textbox is visible on Profile page");
		} else {
			test.log(LogStatus.FAIL, "First&Last Name textbox is not visible on Profile page");
		}

		int Email_textbox_status = ControlHelpers.IsElementPresent(By.xpath(Email_textbox));
		if (Email_textbox_status > 0) {
			test.log(LogStatus.PASS, "Email textbox is visible on Profile page");
		} else {
			test.log(LogStatus.FAIL, "Email textbox is not visible on Profile page");
		}

		int ChangePassword_status = ControlHelpers.IsElementPresent(By.xpath(ChangePassword));
		if (ChangePassword_status > 0) {
			test.log(LogStatus.PASS, "ChangePassword is visible on Profile page");
		} else {
			test.log(LogStatus.FAIL, "ChangePassword is not visible on Profile page");
		}
		ControlHelpers.MoveToElement(By.xpath(Email_textbox));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
