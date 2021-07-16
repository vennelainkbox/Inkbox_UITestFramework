package Inkbox.Pages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;

public class ContentfulPage {
	ExtentTest test;

	public ContentfulPage(ExtentTest test) {

		this.test = test;
		ControlHelpers controlHelpers = new ControlHelpers(test);
	}

	String Login_link = "//div[text()='Log in']";
	String EmailId = "//input[@id='user_email']";
	String Password = "//input[@id='user_password']";
	String Login_button = "//input[@value='Log in' and @type='submit']";

	public void Contentful_Login() {
		// ControlHelpers.ButtonClick(By.xpath(Login_link));
		ControlHelpers.Entertext(By.xpath(EmailId), "inkboxqa@getinkbox.com");
		ControlHelpers.Entertext(By.xpath(Password), "Pa55word123!!!");
		ControlHelpers.ButtonClick(By.xpath(Login_button));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Hero_Banner_validation() {
//fromContentFul
		ControlHelpers.GetDriver().get("https://app.contentful.com/spaces/pkpedwjf5oyt/entries/qNZptxr5VNANDVrNUdmiM");
		ControlHelpers.ButtonClick(By.xpath("//div/h1[text()='NTW - Homepage Sale Hero Banner']"));
		// toget Title
		String TitleContentful = ControlHelpers.getText(
				By.xpath("(//div/label[text()='Title'])[2]/parent::div/following-sibling::div/descendant::input"));

		String descriptionContentful = ControlHelpers
				.getText(By.xpath("//div[@class='CodeMirror-lines']/descendant::span[@role='presentation']"));

		String buttonContentful = ControlHelpers
				.getText(By.xpath("//label[text()='Button']/parent::div/following-sibling::div/descendant::h1"));
		
		ControlHelpers.GetDriver().get("https://inkbox.com/");
		
		String TitleInbox=ControlHelpers.getText(By.xpath("//section[contains(@id,'promo_banner_separate')]/descendant::h1"));
		String descriptionInkbox=ControlHelpers.getText(By.xpath("//section[contains(@id,'promo_banner_separate')]/descendant::div[@class='items-center']/p"));
		
		String button_inbox=ControlHelpers.getText(By.xpath("//div[contains(@id,'button')]/a[text()='Meet Our Artists']"));
		
		if(TitleContentful.contains(TitleInbox))
		{
			test.log(LogStatus.PASS, "Title Validation of Hero Banner is scccess");
		}
		else {
			test.log(LogStatus.ERROR, "Title in contentful  site is :"+TitleContentful+ " is differ from title in Inkbox :"+TitleInbox);
		}
		
		if(descriptionContentful.contains(descriptionInkbox))
		{
			test.log(LogStatus.PASS, "Description  Validation of Hero Banner is scccess");
		}
		else {
			test.log(LogStatus.ERROR, "Description in contentful  site is :"+descriptionContentful+ " is differ from Description in Inkbox :"+descriptionInkbox);
		}
		
		if(buttonContentful.contains(button_inbox))
		{
			test.log(LogStatus.PASS, "Meet Our Artists button  Validation of Hero Banner is scccess");
		}
		else {
			test.log(LogStatus.ERROR, "Button in contentful  site is :"+buttonContentful+ " is differ from Button in Inkbox :"+button_inbox);
		}
	}

}
