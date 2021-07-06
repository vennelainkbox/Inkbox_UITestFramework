package Inkbox.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
		
	//	System.out.println("Constructor is called");
	}
	
	String emailId="//input[@id='signup-email-field']";
	String password="//input[@id='signup-password-field']";
	String SignUpButton="(//button[@type='submit'])[2]";
	
	public void EnterEmail()  {
//		WebDriver driver=new ChromeDriver();
//		driver.findElement(By.xpath(emailId)).sendKeys("vennelakish1@gamil.com");
//		
		String path = null;
	
			ControlHelpers.Entertext(By.xpath(emailId), "vennelakish12@gamil.com");
			
		
	}
	
	public void Enterpassword() {
		
		
		
			ControlHelpers.Entertext(By.xpath(password), "Inkbok!123");
	
		

	}
	
	public void ClickOnSignUp()   {
		
		
	
			ControlHelpers.ButtonClick(By.xpath(SignUpButton));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
