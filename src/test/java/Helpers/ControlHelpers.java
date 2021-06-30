package Helpers;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helpers.WebdriverFactory;

public class ControlHelpers extends LaunchDriver {
	static WebDriver driver;

	public ControlHelpers(WebDriver webdriver) {
		// LaunchDriver launchdriver=new LaunchDriver();
		ControlHelpers.driver = webdriver;
	}

	public static boolean IsElementVisible(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	public static WebElement GetWebElement(By loactor) {
		WebElement element = null;
//		if (IsElementVisible(loactor)) {
//			element = driver.findElement(loactor);
//		}
//		return element;
		return element = driver.findElement(loactor);
	}

	public static void ButtonClick(By locator) {
		GetWebElement(locator).click();
	}

	public static void ButtonClickJavaScriptExecutor_AddButton(By locator) {

		driver.switchTo().frame(driver.findElement(By.id("attentive_creative")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(locator);
		js.executeScript("arguments[0].click();", button);
		driver.switchTo().defaultContent();

	}

	public static void JavaScriptExecutor_Button_Click(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(locator);
		js.executeScript("arguments[0].click();", button);
	}

	public static String getText(By locator) {
		return GetWebElement(locator).getText();
	}

	public static void Entertext(By locator, String textvalue) {

		GetWebElement(locator).sendKeys(textvalue);
	}

	public static void JavaScriptExecutor_Entertext(By locator, String textvalue) {

		WebElement element = GetWebElement(locator);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='" + textvalue + "';", element);
	}

	public static void MoveToElementAndClick(By locator)  {
		WebElement element = GetWebElement(locator);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
		
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

	public static void WaitForElementAndClick(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();

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
