package Inkbox.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import Helpers.ControlHelpers;

public class Ads extends Helpers.LaunchDriver {

	WebDriver driver;
	ExtentTest test;

	public Ads(ExtentTest test) {

		this.test = test;
		ControlHelpers controlHelpers=new ControlHelpers(test);
	}

	//String ad = "(//button[contains(text(),'×')])[1]";
	String ad = "//button[@id='closeIconContainer']";
	

	public void closeAd() throws InterruptedException {
		
		
		
			Thread.sleep(5000);
		//	ControlHelpers.ButtonClick(By.xpath(ad));
			ControlHelpers.ButtonClickJavaScriptExecutor_AddButton(By.xpath(ad));
		
//			test.log(LogStatus.INFO, "Add is Closed");

		

	}
	


}
