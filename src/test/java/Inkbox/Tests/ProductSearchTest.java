package Inkbox.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Helpers.ExtentFactory;
import Helpers.LaunchDriver;
import Inkbox.Pages.BasePage;

public class ProductSearchTest extends LaunchDriver {
	ExtentReports report;
	ExtentTest test;
	@Test
	public void ProductSearchFunctionality() {
		try {
			BasePage basePage=new BasePage(test);
			basePage.EnterTextInsearchBox("butter");
			basePage.AutoSuggestValidation();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.fillInStackTrace());
		}
		
	}

	@BeforeClass
	public void beforeClass()
	{
		report = ExtentFactory.getInstance();
		test = report.startTest("Product search functionality");
	}
	@AfterClass
	public void afterClass() {
		report.endTest(test);
		report.flush();
	}

}
