package Inkbox.Pages;

import org.openqa.selenium.By;

import Helpers.ControlHelpers;

public class LoginPage {
	
	String email="//*[@id=\"login-email-field\"]";
	String password="//*[@id=\"login-password-field\"]";
	String Login="//*[@id=\"accountLoginForm_popup\"]/div/button";
	String Continue_with_google="(//button[@href='https://inkbox.com/google/redirect'])[2]";
	String Continue_with_facebook="(//button[@href='https://inkbox.com/facebook/redirect'])[2]";
	String Login_link="//span[text()='Log in']";
	
	//Continue with Google
	String emailID_ContinueWithGoogle="//input[@type='email']";
	String Next_button="//button/span[text()='Next']";
	String password_ContinueWithGoogle="//input[@type='password']";
	
	//Continue with Facebook
	//String emailID_facebook="//div[@id='email_container']/input";
	String emailID_facebook="//input[@id='signup-email-field']";
	String password_facebook="//div[@id='email_container']/following-sibling::div/input";
	String login_facebook="//div[@id='email_container']/following-sibling::div/button";
	

	
	public void ClickLogin_link() {
		
		ControlHelpers.ButtonClick(By.xpath(Login_link));
		
	}
	public void EnterEmail(String emailtext) {
		ControlHelpers.Entertext(By.xpath(email), emailtext);
	}
	
	public void EnterPassword(String passwordtext) {
		ControlHelpers.Entertext(By.xpath(password),passwordtext);
	}
	
	public void ClickLoginButton() {
		ControlHelpers.ButtonClick(By.xpath(Login));
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
		
	}
	public void EnterGoogle_Password(String password) throws InterruptedException {
//		ControlHelpers.Entertext(By.xpath(password_ContinueWithGoogle), password);
//		ControlHelpers.ButtonClick(By.xpath(Next_button));
		
		Thread.sleep(5000);
		ControlHelpers.JavaScriptExecutor_Entertext(By.xpath(password_ContinueWithGoogle), password);
		ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(Next_button));
	}
	
	public void EnterEmail_facebook(String emailid) {
		//ControlHelpers.Entertext(By.xpath(emailID_facebook), emailId);
		ControlHelpers.JavaScriptExecutor_Entertext(By.xpath(emailID_facebook), emailid);
	}
	
	public void EnterPassword_facebook(String password) {
		//ControlHelpers.Entertext(By.xpath(emailID_facebook), password);
		ControlHelpers.JavaScriptExecutor_Entertext(By.xpath(password_facebook), password);
	}
	
	public  void Click_On_Login_facebook() {
		ControlHelpers.ButtonClick(By.xpath(login_facebook));
	}

}
