package Inkbox.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;
import Helpers.LaunchDriver;

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
	String Student_discount = "//*[@id=\"header-student\"]/a[text()='Student Discount']";
	String Rewards = "//*[@id=\"header-rewards\"]/a[text()='Rewards']";
	String Help = "//div[@id='header-help']/button/span[text()='Help']";
	String Login_Button = "//*[@id='header-user']/button";

	// profile
	String YourProfile = "//div[@id='header-user']/descendant::a[contains(text(),'Your Profile')]";
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
		List<WebElement> elements = ControlHelpers.getElementsList(By.xpath(productsList));

		for (WebElement webElement : elements) {

			String expecstring = webElement.getText();
			if (expecstring.contains(searchtext)) {
				test.log(LogStatus.INFO, expecstring + " : is validated");
			} else {
				test.log(LogStatus.ERROR, expecstring + " : is validated");
			}

		}

	}

	public boolean VerifyAccountLogin() {

//		String account_buttonText=ControlHelpers.WaitForElementAndGetText(By.xpath(Login_Button));
//		return account_buttonText;

		return ControlHelpers.IsElementVisible(By.xpath(Login_Button));

	}

	public void VerifyUserImage_Is_Changing_Or_Not() throws AWTException, InterruptedException {
		ClickOnMyAccount();
		ClickOnYourProfile();
		
		System.out.println("Image present :"+ControlHelpers.IsElementVisible(By.xpath("//form[@id='profile_form']/descendant::img")));
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
		ControlHelpers.ButtonClick(By.xpath(ChangePhoto));

		Thread.sleep(3000);
		StringSelection ss2 = new StringSelection(driverpath + "\\Resources\\inkboxImage2.jpg");
	
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss2, null);

		// Ctrl + v
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_CONTROL);
		robot2.keyPress(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_V);
		robot2.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);

//		String src2 = ControlHelpers.GetDriver().findElement(By.xpath("//form[@id='profile_form']/descendant::img"))
//				.getAttribute("src");
//		System.out.println("second img :"+src2);

//		boolean visiblility = ControlHelpers.IsElementVisible(By.xpath(ChangePhoto));
//		System.out.println("Icon displayed :" + visiblility);
//		if (!visiblility) {
//			test.log(LogStatus.ERROR, "User image (Inkbucks) are not displayed in profile after login");
//
//		} else {
//			test.log(LogStatus.PASS, "User image (Inkbucks) are displayed in profile after login");
//		}
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
}
