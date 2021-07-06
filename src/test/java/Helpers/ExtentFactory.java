package Helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance() {
//		ExtentReports extent;
//		LaunchDriver launchDriver=new LaunchDriver();
		
		ExtentReports extent;
		String Path=System.getProperty("user.dir")+"//Reports//report.html";
		//String Path = "//Users//atomar//Desktop//report-demo.html";
		extent = new ExtentReports(Path, false);
		

		return extent;
	
//		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
//		Date dateobj = new Date();
//		String reportname="SmokeTest"+ df.format(dateobj).replaceAll(" ", "_").replaceAll("/", "_").replace(":", "_");
//				
//		
//		String Path=System.getProperty("user.dir");
//		Path=Path+"/Reports";
//		 Path=Path+"/"+reportname+".html";
		 
		//String Path = "E:\\Office\\JobSupport\\Inkbox_UITestFramework\\Inkbox_UITestFramework\\Reports\\report-demo.html";
//		extent = new ExtentReports(launchDriver.getReportPath(), false);
//		System.out.println("Report path :"+launchDriver.getReportPath());
//
//		return extent;
	}
}
