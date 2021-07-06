package Inkbox.Pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;

public class HomePage {
	ExtentTest test;

	public HomePage(ExtentTest test) {
		this.test = test;
		ControlHelpers controlHelpers=new ControlHelpers(test);
	}
	
	public void ValidateHomePage() {
		String URL="https://inkbox.com";
		ControlHelpers.GetDriver().getCurrentUrl();
		if(URL.equalsIgnoreCase("https://inkbox.com"))
		{
			test.log(LogStatus.INFO, "Home page is displayed");
		}
		else
		{
			test.log(LogStatus.INFO, "Home page is not displayed");
		}
	}

}
