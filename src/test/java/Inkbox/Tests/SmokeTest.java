package Inkbox.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Helpers.LaunchDriver;
import Inkbox.Pages.Ads;
import Inkbox.Pages.BasePage;
import Inkbox.Pages.LoginPage;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

public class SmokeTest extends LaunchDriver {
	// WebDriver driver;
	LoginPage loginPage;
	BasePage basePage;
	ExtentReports report;
	ExtentTest test;
//	@BeforeClass
//	public void setup() {
//		LaunchDriver driverlaunch=new LaunchDriver();
//		driver=driverlaunch.driver;
//	}

	@Test
	public void Setup() throws InterruptedException{
		
//		boolean displayed = driver.findElement(By.xpath("//a[@id='logo']")).isDisplayed();
//		System.out.println(displayed);
//		Thread.sleep(5000);

		
		Ads ads = new Ads(test);
		ads.closeAd();
		basePage = new BasePage(test);
		basePage.AcctountIcon();
//		loginPage = new LoginPage();
//		loginPage.ClickLogin_link();
//		loginPage.EnterEmail("testinkbox@gmail.com");
//		loginPage.EnterPassword("Inkbox!123");
//		loginPage.ClickLoginButton();
//		

	}

	

}
