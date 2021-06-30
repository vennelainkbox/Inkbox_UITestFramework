package Helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshots {
	public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		String screenshotName = fileName.replaceAll(" ", "_");
		screenshotName = screenshotName
				+ df.format(dateobj).replaceAll(" ", "_").replaceAll("/", "_").replace(":", "_");
		// fileName = fileName + ".png";
		fileName = screenshotName + ".png";
		String path = System.getProperty("user.dir");
		path = path + "/test-output/screenshots";
		String directory = path;
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		String destination = directory + fileName;
		return destination;
	}

	public static String getreportName() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		String reportname = "SmokeTest"
				+ df.format(dateobj).replaceAll(" ", "_").replaceAll("/", "_").replace(":", "_");

		String Path = System.getProperty("user.dir");
		Path = Path + "/Reports";
		Path = Path + "/" + reportname + ".html";
		return Path;

	}
}
