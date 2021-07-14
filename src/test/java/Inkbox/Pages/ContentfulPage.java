package Inkbox.Pages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;

import Helpers.ControlHelpers;

public class ContentfulPage {
	ExtentTest test;

	public ContentfulPage(ExtentTest test) {

		this.test = test;
		ControlHelpers controlHelpers = new ControlHelpers(test);
	}
	
	
	String Login_link="//div[text()='Log in']";
	String EmailId="//input[@id='user_email']";
	String Password="//input[@id='user_password']";
	String Login_button="//input[@value='Log in' and @type='submit']";
	
	public void Contentful_Login() {
		ControlHelpers.ButtonClick(By.xpath(Login_link));
		ControlHelpers.Entertext(By.xpath(EmailId), "inkboxqa@getinkbox.com");
		ControlHelpers.Entertext(By.xpath(Password), "Pa55word123!!!");
		ControlHelpers.ButtonClick(By.xpath(Login_button));
		}
}
