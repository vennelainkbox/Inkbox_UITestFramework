package Inkbox.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;
import Helpers.LaunchDriver;
import Helpers.Screenshots;

public class SignUpPage {
	ExtentTest test;
	WebDriver driver;
	LaunchDriver launchDriver;

//	
	public SignUpPage(ExtentTest test) {

		this.test = test;
		ControlHelpers controlHelpers = new ControlHelpers(test);
	}

	String emailId = "//input[@id='signup-email-field']";
	String password = "//input[@id='signup-password-field']";
	String SignUpButton = "(//button[@type='submit'])[2]";

	String SignUpMsg = "//div[@x-show='showAlert']/descendant::li";

	public void EnterEmail(String Email) {

		ControlHelpers.Entertext(By.xpath(emailId), Email);

	}

	public void Enterpassword(String Password) {
		ControlHelpers.Entertext(By.xpath(password), Password);
	}

	public void ClickOnSignUp() {

		ControlHelpers.ButtonClick(By.xpath(SignUpButton));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ValidateSignup() {
		String message = ControlHelpers.getText(By.xpath(SignUpMsg));
		if (message.contains("Success. Thanks for joining the inkfam!")) {
			test.log(LogStatus.PASS, "Successfully SignUp");
		} else {
			test.log(LogStatus.FAIL, "SignUp failed");
			Assert.fail();
		}
	}

}
