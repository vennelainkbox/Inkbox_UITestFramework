package Inkbox.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;

public class Ads extends Helpers.LaunchDriver {

	WebDriver driver;
	// ControlHelpers controlHelpers;
	ExtentTest test;

	public Ads(ExtentTest test) {

		this.test = test;
		ControlHelpers controlHelpers=new ControlHelpers(test);
	}

	//String ad = "(//button[contains(text(),'×')])[1]";
	String ad = "//button[@id='closeIconContainer']";
	

	public void closeAd() throws InterruptedException {
		
		
		
			Thread.sleep(5000);
			//ControlHelpers.ButtonClick(By.xpath(ad));
			ControlHelpers.ButtonClickJavaScriptExecutor_AddButton(By.xpath(ad));
		
//			test.log(LogStatus.INFO, "Add is Closed");

		

	}
	


}
