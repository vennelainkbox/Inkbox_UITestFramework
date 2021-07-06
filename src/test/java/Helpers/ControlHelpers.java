package Helpers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helpers.WebdriverFactory;

public class ControlHelpers extends LaunchDriver {
	static WebDriver driver;
	static ExtentTest test;

	public ControlHelpers(WebDriver webdriver) {
		// LaunchDriver launchdriver=new LaunchDriver();
		ControlHelpers.driver = webdriver;
	}

	public ControlHelpers(ExtentTest test) {
		this.test = test;
	}

	public static WebDriver GetDriver() {
		return driver;
	}

	public static boolean IsElementVisible(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	public static WebElement GetWebElement(By locator) {
		WebElement element = null;
//		if (IsElementVisible(locator)==true) {
//			element = driver.findElement(locator);
//		}
//		else {
//			throw new NoSuchElementException("unnable to find "+locator);
//		}
//		
//		return element;
		return element = driver.findElement(locator);
	}

	public static void ButtonClick(By locator) {

		try {
			GetWebElement(locator).click();
//			test.log(LogStatus.PASS, "Clicked on " + getText(locator));
		} catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.ERROR, e.getLocalizedMessage());
			Assert.fail();
			throw new NoSuchElementException(e.getMessage());
		}

	}

	public static void ButtonClickJavaScriptExecutor_AddButton(By locator) {

		try {
			driver.switchTo().frame(driver.findElement(By.id("attentive_creative")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement button = driver.findElement(locator);
			js.executeScript("arguments[0].click();", button);
			driver.switchTo().defaultContent();

			//test.log(LogStatus.PASS, "Clicked on " + getText(locator));
		} catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.ERROR, e.getLocalizedMessage());
			Assert.fail();
			throw new NoSuchElementException(e.getMessage());
		}
	}

	public static void JavaScriptExecutor_Button_Click(By locator) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement button = driver.findElement(locator);
			js.executeScript("arguments[0].click();", button);

		} catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.ERROR, e.getLocalizedMessage());
			Assert.fail();
			throw new NoSuchElementException(e.getMessage());
		}
	}

	public static String getText(By locator) {

//		String elementtext = GetWebElement(locator).getText();
//
//		return elementtext;
		String elementtext = null;
		try {
			elementtext = GetWebElement(locator).getText();
		} catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.ERROR, e.getLocalizedMessage());
			Assert.fail();
			throw new NoSuchElementException(e.getMessage());
		}
		return elementtext;
	}

	public static String getTextBox_Text(By locator) {
		return GetWebElement(locator).getAttribute("value");
	}

	public static void Entertext(By locator, String textvalue) {

		try {
			GetWebElement(locator).clear();
			GetWebElement(locator).sendKeys(textvalue);
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.ERROR, e.getLocalizedMessage());
			Assert.fail();
			throw new NoSuchElementException(e.getMessage());
		}
	}

	public static void JavaScriptExecutor_Entertext(By locator, String textvalue) {

		try {
			WebElement element = GetWebElement(locator);

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value='" + textvalue + "';", element);
		//	test.log(LogStatus.INFO, "Enter :" + textvalue + " in textbox");
		} catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.ERROR, e.getLocalizedMessage());
			Assert.fail();
			throw new NoSuchElementException(e.getMessage());
		}
	}

	public static void MoveToElementAndClick(By locator) {
		WebElement element = GetWebElement(locator);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public static void HoverOver(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(GetWebElement(locator)).build().perform();

	}

	public static List<WebElement> getElementsList(By locator) {
		List<WebElement> elements = null;
		try {
			Thread.sleep(5000);
			elements = driver.findElements(locator);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elements;

	}

	public static void ClickEnter(By locator) {
		GetWebElement(locator).sendKeys(Keys.ENTER);
	}
	public static void WaitForElementAndClick(By locator) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element.click();
			test.log(LogStatus.INFO, "Clicked on " + getText(locator));
		} catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.ERROR, e.getLocalizedMessage());
			Assert.fail();
			throw new NoSuchElementException(e.getMessage());
		}

	}

	public static String WaitForElementAndGetText(By locator) {
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		WebElement element = GetWebElement(locator);
//		String gettext = wait.until(ExpectedConditions.visibilityOf(element)).getText();
//		return gettext;

		String gettext = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement element = GetWebElement(locator);
			gettext = wait.until(ExpectedConditions.visibilityOf(element)).getText();

		} catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.ERROR, e.getLocalizedMessage());
			Assert.fail();
			throw new NoSuchElementException(e.getMessage());
		}
		return gettext;
	}

	public static int getRandomNumber(int max) {
		Random randnumber = new Random();
		max = max + 1;
		int randomnumber = 0;
		int Number = randnumber.nextInt(max);
		if (Number == 0) {
			randomnumber = Number + 1;
		} else {
			randomnumber = Number;
		}
		return randomnumber;

	}
}
