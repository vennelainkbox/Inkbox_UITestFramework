package Inkbox.Pages;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;
import Helpers.LaunchDriver;

public class LoginPage {
	ExtentTest test;
	BasePage basePage;
	LoginPage loginPage;
	public LoginPage(ExtentTest test)
	{
		this.test=test;
		ControlHelpers controlHelpers=new ControlHelpers(test);
	}
	
	String email="//*[@id=\"login-email-field\"]";
	String password="//*[@id=\"login-password-field\"]";
	String Login="//form[@id='accountLoginForm_popup']/div/button[@type='submit']";
	//String Login="//*[@id='accountLoginForm_popup']/div/button";
	String Continue_with_google="(//button[@href='https://inkbox.com/google/redirect'])[2]";
	String Continue_with_facebook="(//button[@href='https://inkbox.com/facebook/redirect'])[2]";
	String Login_link="//span[text()='Log in']";
	
	//Continue with Google
	String emailID_ContinueWithGoogle="//input[@type='email']";
	String Next_button="//button/span[text()='Next']";
	String password_ContinueWithGoogle="//input[@type='password']";
	
	//Continue with Facebook
	//String emailID_facebook="//input[@id='signup-email-field']";
	String emailID_facebook="//input[@id='email']";
	String password_facebook="//div[@id='email_container']/following-sibling::div/input";
	String login_facebook="//div[@id='email_container']/following-sibling::div/button";
	

	
	public void ClickLogin_link() {
		
			ControlHelpers.ButtonClick(By.xpath(Login_link));
		
		
	}
	public void EnterEmail(String emailtext) {
		ControlHelpers.Entertext(By.xpath(email), emailtext);
		test.log(LogStatus.INFO, "UserName :" + emailtext);
	}
	
	public void EnterPassword(String passwordtext) {
		ControlHelpers.Entertext(By.xpath(password),passwordtext);
		test.log(LogStatus.INFO, "Password :" + passwordtext);
	}
	
	public void ClickLoginButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ControlHelpers.ButtonClick(By.xpath(Login));
		test.log(LogStatus.INFO, "Clicked on Login button");
		
	}
	
	public  void UserLogin() {

		try {

			Ads ads = new Ads(test);
			ads.closeAd();
			basePage = new BasePage(test);
			basePage.AcctountIcon();
			loginPage = new LoginPage(test);
			loginPage.ClickLogin_link();
			//loginPage.EnterEmail("testinkbox@gmail.com");
			//loginPage.EnterPassword("Test@123");
			loginPage.EnterEmail(LaunchDriver.getUsername());
			loginPage.EnterPassword(LaunchDriver.getPassword());
			loginPage.ClickLoginButton();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.fillInStackTrace());
		}

	}
	
	public void Login() {
		try {

			basePage = new BasePage(test);
			basePage.AcctountIcon();
			loginPage = new LoginPage(test);
			loginPage.ClickLogin_link();
			//loginPage.EnterEmail("testinkbox@gmail.com");
			//loginPage.EnterPassword("Test@123");
			loginPage.EnterEmail(LaunchDriver.getUsername());
			loginPage.EnterPassword(LaunchDriver.getPassword());
			loginPage.ClickLoginButton();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.fillInStackTrace());
		}
	}
	
	public  void UserLogin_With_Google() {
		try {
			Ads ads = new Ads(test);
			ads.closeAd();
			basePage = new BasePage(test);
			basePage.AcctountIcon();
			loginPage = new LoginPage(test);
			loginPage.ClickContinue_With_google();
//			loginPage.EnterGoogle_MailID("testinkbox@gmail.com");
//			loginPage.EnterGoogle_Password("Inkbox!123");
			loginPage.EnterGoogle_MailID(LaunchDriver.getUsername());
			loginPage.EnterGoogle_Password(LaunchDriver.gmail_facbook_password);

		} catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}

	}
	
	public  void UserLogin_With_FaceBook() {
		try {
			
			Ads ads = new Ads(test);
			ads.closeAd();
			basePage = new BasePage(test);
			basePage.AcctountIcon();
			loginPage = new LoginPage(test);
			loginPage.ClickContinue_With_facebook();
//			loginPage.EnterEmail_facebook("testinkbox@gmail.com");
//			loginPage.EnterPassword_facebook("Inkbox!123");
			loginPage.EnterEmail_facebook(LaunchDriver.getUsername());
			loginPage.EnterPassword_facebook(LaunchDriver.gmail_facbook_password);
			loginPage.Click_On_Login_facebook();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.fillInStackTrace());
		}

	}
	
	public void ClickContinue_With_google() {
		//ControlHelpers.ButtonClick(By.xpath(Continue_with_google));
		ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(Continue_with_google));
	}
	
	
	public void ClickContinue_With_facebook() {
		//ControlHelpers.ButtonClick(By.xpath(Continue_with_facebook));
		//ControlHelpers.WaitForElementAndClick(By.xpath(Continue_with_facebook));
		ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(Continue_with_facebook));
	}
	
	public void EnterGoogle_MailID(String emailid) {
	//	ControlHelpers.Entertext(By.xpath(emailID_ContinueWithGoogle), emailid);
	//	ControlHelpers.ButtonClick(By.xpath(Next_button));
		ControlHelpers.JavaScriptExecutor_Entertext(By.xpath(emailID_ContinueWithGoogle), emailid);
		ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(Next_button));
		test.log(LogStatus.INFO, "EmailId :" + emailid);
		
	}
	public void EnterGoogle_Password(String password) throws InterruptedException {
//		ControlHelpers.Entertext(By.xpath(password_ContinueWithGoogle), password);
//		ControlHelpers.ButtonClick(By.xpath(Next_button));
		
		Thread.sleep(5000);
		ControlHelpers.JavaScriptExecutor_Entertext(By.xpath(password_ContinueWithGoogle), password);
		ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(Next_button));
		test.log(LogStatus.INFO, "Password :" + password);
	}
	
	public void EnterEmail_facebook(String emailid) {
		//ControlHelpers.Entertext(By.xpath(emailID_facebook), emailId);
		ControlHelpers.JavaScriptExecutor_Entertext(By.xpath(emailID_facebook), emailid);
		test.log(LogStatus.INFO, "UserName :" + emailid);
	}
	
	public void EnterPassword_facebook(String password) {
		//ControlHelpers.Entertext(By.xpath(emailID_facebook), password);
		ControlHelpers.JavaScriptExecutor_Entertext(By.xpath(password_facebook), password);
		test.log(LogStatus.INFO, "UserName :" + password);
	}
	
	public  void Click_On_Login_facebook() {
		ControlHelpers.ButtonClick(By.xpath(login_facebook));
	}

}
