package Helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverFactory {
//	static WebDriver driver;
//	static String URL = "https://beta.inkbox.com/";

	public static WebDriver getDriverInstance(String browser,String URL) {
		WebDriver driver=null;
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);

		}
		else if (browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "Resources/geckodriver.exe");
//			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();

		}
		else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();

		}
		else if (browser.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();

		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

}
