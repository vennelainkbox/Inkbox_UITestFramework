package Helpers;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class LaunchDriver {

	String reportPath;
	public ExtentReports report;
	
	 static public String password=null;
	// ExtentTest test;

	

	public String getReportPath() {
		return reportPath;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		LaunchDriver.password = password;
	}

	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

//	@BeforeTest
//	@Parameters({ "browser", "URL" })
//	public void beforeTest(String browser, String URL) {
//		driver = WebdriverFactory.getDriverInstance(browser, URL);
//		ControlHelpers controlHelpers = new ControlHelpers(driver);
//		reportPath = Screenshots.getreportName();
//		setReportPath(reportPath);
//
//		report = ExtentFactory.getInstance();
//	}
//
//	@AfterTest
//	public void afterSuite() {
//		report.flush();
//
//		driver.close();
//		driver.quit();
//
//	}
	
	@BeforeTest
	public void beforeTest() {

		report = ExtentFactory.getInstance();
	}

	@Parameters({ "browser", "URL" })
	@BeforeMethod
	public void beforeMethod(String browser, String URL) {
		driver = WebdriverFactory.getDriverInstance(browser, URL);
		ControlHelpers controlHelpers = new ControlHelpers(driver);
		reportPath = Screenshots.getreportName();
		setReportPath(reportPath);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();

	}

	@BeforeSuite
	public void beforeSuite() throws IOException {
		Move_Report_To_OldReport();
		getpassword_configFile();
	}

	public static void Move_Report_To_OldReport() throws IOException {
		Path path = Paths.get(System.getProperty("user.dir") + "//OldReports");
		Path path2 = Paths.get(System.getProperty("user.dir") + "//test-output//screenshots");
		if (!Files.exists(path)) {

			Files.createDirectory(path);
			System.out.println("Old Reports folder is added created");
		}
		if (!Files.exists(path2)) {
			Files.createDirectory(path2);
			System.out.println("screenshots folder is added created");
		}

		Path report_path = Paths.get(System.getProperty("user.dir") + "//Reports//report.html");
		if (Files.exists(report_path)) {
			String fileName = System.getProperty("user.dir") + "//Reports//report.html";
			File file = new File(fileName);
			String time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(getCreationTime(file).toMillis());
			time = time.replaceAll(" ", "_").replaceAll("/", "_").replace(":", "_");
			File oldName = new File(fileName);
			File newName = new File(path + "/Report" + time + ".html");
			oldName.renameTo(newName);
		}

	}

	public static FileTime getCreationTime(File file) throws IOException {
		Path p = Paths.get(file.getAbsolutePath());
		BasicFileAttributes view = Files.getFileAttributeView(p, BasicFileAttributeView.class).readAttributes();
		FileTime fileTime = view.lastModifiedTime();
		return fileTime;
	}

	
	
	public void getpassword_configFile() throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//config.properties");
		Properties prop=new Properties();
		prop.load(file);
		
		setPassword(prop.getProperty("password"));
		System.out.println(prop.getProperty("password"));
		
	}
	
	public static void setpassword_configFile(String password) {
		Properties props = new Properties();
		try {
		      //first load old one:
		      FileInputStream configStream = new FileInputStream(System.getProperty("user.dir")+"//config.properties");
		      props.load(configStream);
		      configStream.close();

		      //modifies existing or adds new property
		      props.setProperty("password", password);

		      //save modified property file
		      FileOutputStream output = new FileOutputStream(System.getProperty("user.dir")+"//config.properties");
		      props.store(output, "This description goes to the header of a file");
		      output.close();
		      System.out.println("password changed to :"+password);

		    } catch (IOException ex) {}
	}
}
