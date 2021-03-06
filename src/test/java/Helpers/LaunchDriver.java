package Helpers;

import org.testng.annotations.Test;

import com.opencsv.CSVWriter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
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

	 static	String gmail_Facebook_Username;

	

	public static String getGmail_Facebook_Username() {
		return gmail_Facebook_Username;
	}

	public static void setGmail_Facebook_Username(String gmail_Facebook_Username) {
		LaunchDriver.gmail_Facebook_Username = gmail_Facebook_Username;
	}

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
	
	static public String gmail_facbook_password = null;
	public static String getGmail_facbook_password() {
		return gmail_facbook_password;
	}

	public static void setGmail_facbook_password(String gmail_facbook_password) {
		LaunchDriver.gmail_facbook_password = gmail_facbook_password;
	}

	static public String username = null;
	// ExtentTest test;

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		LaunchDriver.username = username;
	}


	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	
	@BeforeTest(alwaysRun = true)
	public void beforeTest() {

		report = ExtentFactory.getInstance();
	}

	@Parameters({ "browser", "URL" })
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(String browser, String URL) {
		driver = WebdriverFactory.getDriverInstance(browser, URL);
		ControlHelpers controlHelpers = new ControlHelpers(driver);
		reportPath = Screenshots.getreportName();
		setReportPath(reportPath);
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
//		driver.close();
//		driver.quit();

	}

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() throws IOException {
		Move_Report_To_OldReport();
		getusername_configFile();
		getpassword_configFile();
		get_gmail_facebok_password_configFile();
		get_gmailFacebookusername_configFile();
	}
	public void getusername_configFile() throws IOException
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
		Properties prop = new Properties();
		prop.load(file);

		setUsername(prop.getProperty("username"));
		System.out.println("Username :"+prop.getProperty("username"));
	}
	public void get_gmailFacebookusername_configFile() throws IOException
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
		Properties prop = new Properties();
		prop.load(file);

		setGmail_Facebook_Username(prop.getProperty("gmail_facebook_username"));
		System.out.println("Gmail  Username :"+prop.getProperty("gmail_facebook_username"));
	}
	public void get_gmail_facebok_password_configFile() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
		Properties prop = new Properties();
		prop.load(file);

		setGmail_facbook_password(prop.getProperty("gmail_facebookpassword"));
		System.out.println("gmail_facebook_password :"+prop.getProperty("gmail_facebookpassword"));

	}

	public static void Move_Report_To_OldReport() throws IOException {
		Path path = Paths.get(System.getProperty("user.dir") + "//OldReports");
		Path path2 = Paths.get(System.getProperty("user.dir") + "//test-output//screenshots");
		Path testng_OldReports = Paths.get(System.getProperty("user.dir") + "//test-output//Testng_OldReports");
		if (!Files.exists(path)) {

			Files.createDirectory(path);
			System.out.println("Old Reports folder is added created");
		}
		if (!Files.exists(path2)) {
			Files.createDirectory(path2);
			System.out.println("screenshots folder is added created");
		}
		if (!Files.exists(testng_OldReports)) {
			Files.createDirectory(testng_OldReports);
			System.out.println("Testng_OldReports folder is added created");
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
		
		// move Emaillable to testng_OldReports under test-output folder
		Path Emaillable_report_path = Paths
				.get(System.getProperty("user.dir") + "//test-output//emailable-report.html");
		if (Files.exists(Emaillable_report_path)) {
			String fileName = System.getProperty("user.dir") + "//test-output//emailable-report.html";
			File file = new File(fileName);
			String time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(getCreationTime(file).toMillis());
			time = time.replaceAll(" ", "_").replaceAll("/", "_").replace(":", "_");
			File oldName = new File(fileName);
			File newName = new File(testng_OldReports + "/emailable-report" + time + ".html");
			oldName.renameTo(newName);
			System.out.println(testng_OldReports + "/emailable-report" + time + ".html");
		}

		// move index.html to testng_OldReports under test-output folder
		Path index_report_path = Paths.get(System.getProperty("user.dir") + "//test-output//index.html");
		if (Files.exists(index_report_path)) {
			String fileName = System.getProperty("user.dir") + "//test-output//index.html";
			File file = new File(fileName);
			String time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(getCreationTime(file).toMillis());
			time = time.replaceAll(" ", "_").replaceAll("/", "_").replace(":", "_");
			File oldName = new File(fileName);
			File newName = new File(testng_OldReports + "/index" + time + ".html");
			oldName.renameTo(newName);
			// System.out.println(testng_OldReports + "/index" + time + ".html");
		}
		
		// move testng-results.xml to testng_OldReports under test-output folder
				Path testng_results_path = Paths.get(System.getProperty("user.dir") + "//test-output//testng-results.xml");
				if (Files.exists(testng_results_path)) {
					String fileName = System.getProperty("user.dir") + "//test-output//testng-results.xml";
					File file = new File(fileName);
					String time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(getCreationTime(file).toMillis());
					time = time.replaceAll(" ", "_").replaceAll("/", "_").replace(":", "_");
					File oldName = new File(fileName);
					File newName = new File(testng_OldReports + "/testng-results" + time + ".html");
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
	public static void setUsername_configFile(String username) {
		Properties props = new Properties();
		try {
			// first load old one:
			FileInputStream configStream = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
			props.load(configStream);
			configStream.close();

			// modifies existing or adds new property
			props.setProperty("username", username);

			// save modified property file
			FileOutputStream output = new FileOutputStream(System.getProperty("user.dir") + "//config.properties");
			props.store(output, "This description goes to the header of a file");
			output.close();
			// System.out.println("password changed to :"+password);

		} catch (IOException ex) {
		}
	}

	public static String GenerateRandomString(int n) {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}
	
	public static void SaveUsernameToCsvFile(String username) throws IOException {
		
		String csv =System.getProperty("user.dir") + "//Resources//usernames.csv";
		CSVWriter writer = new CSVWriter(new FileWriter(csv, true));

		String[] record = username.split(",");

		writer.writeNext(record);

		writer.close();
	}
}
