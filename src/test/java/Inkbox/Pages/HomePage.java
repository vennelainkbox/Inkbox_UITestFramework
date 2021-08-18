package Inkbox.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.ControlHelpers;

public class HomePage {
	ExtentTest test;

	public HomePage(ExtentTest test) {
		this.test = test;
		ControlHelpers controlHelpers=new ControlHelpers(test);
	}
	
	String PopularCategories="//div[contains(@id,'container')]/h1[contains(text(),'Popular Categories')]/parent::div/descendant::section/descendant::span";
	
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
	
	public void Validating_JustDrop_Products() {
<<<<<<< HEAD
		int randomNumber=ControlHelpers.getRandomNumber(4);
		String productXpath="((//div[contains(@class,'section')]/descendant::h1[contains(text(),'Just Dropped')]/parent::div/parent::div/following-sibling::div[contains(@id,'container')]/descendant::f[@class='trayItem'])["+randomNumber+"]/descendant::a)[2]";
		String selectedProductName=ControlHelpers.getText(By.xpath(productXpath));
		//ControlHelpers.ButtonClick(By.xpath(productXpath));
		ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(productXpath));
=======
>>>>>>> 9371c42d095809cbae0eb94b625c81ff88e329db
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int ispresent=ControlHelpers.IsElementPresent(By.xpath("//div[contains(@class,'section')]/descendant::h1[contains(text(),'Just Dropped')]"));
		if(ispresent > 0)
		{
			int randomNumber=ControlHelpers.getRandomNumber(4);
			String productXpath="((//div[contains(@class,'section')]/descendant::h1[contains(text(),'Just Dropped')]/parent::div/parent::div/following-sibling::div[contains(@id,'container')]/descendant::div[@class='trayItem'])["+randomNumber+"]/descendant::a)[2]";
			String selectedProductName=ControlHelpers.getText(By.xpath(productXpath));
			//ControlHelpers.ButtonClick(By.xpath(productXpath));
			ControlHelpers.JavaScriptExecutor_Button_Click(By.xpath(productXpath));
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String redirectedProduct=ControlHelpers.getText(By.xpath("//main/descendant::div[contains(@class,'items-center')]/h3"));
			if(selectedProductName.contains(redirectedProduct))
			{
				test.log(LogStatus.PASS, "Display of products on homepage of JustDropped is success");
			}
			else {
				test.log(LogStatus.FAIL, "Display of products on homepage of JustDropped is :"+selectedProductName+ " is differ from redirected product :"+redirectedProduct);
			}
		}
		else {
			test.log(LogStatus.INFO, "Just Dropped section is not present on HomePage");
		}
		
		
	}

	public void ValidatePopularCategories() {
		
		List<WebElement> elementList=ControlHelpers.getElementsList(By.xpath(PopularCategories));
		for (int i = 0; i < elementList.size(); i++) {
			int k=i+1;
			String xpath="(//div[contains(@id,'container')]/h1[contains(text(),'Popular Categories')]/parent::div/descendant::section/descendant::span)["+k+"]";
			String CategoryName=ControlHelpers.getText(By.xpath(xpath));
			CategoryName=CategoryName.toLowerCase().replace(" ", "");
			ControlHelpers.MoveToElementAndClick(By.xpath(xpath));
			String Url=ControlHelpers.GetCurrentUrl();
			String url=Url;
			Url=Url.toLowerCase().replace(" ", "").replace("%20", "");
			if(Url.contains(CategoryName))
			{
				test.log(LogStatus.PASS, CategoryName + " is verify");
			}
			else {
				test.log(LogStatus.FAIL, "Selected category is :"+CategoryName+ " but it is redirected to :"+url);
			}
			
			ControlHelpers.GetDriver().navigate().back();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
