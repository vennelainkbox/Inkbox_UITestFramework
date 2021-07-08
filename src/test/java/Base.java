
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Base {

	public static void main(String[] args) throws IOException, ConfigurationException {

//		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//config.properties");
//		Properties prop=new Properties();
//		prop.load(file);
//		
//		System.out.println(prop.getProperty("username"));
//		System.out.println(prop.getProperty("password"));
//		
//		prop.setProperty("password", "Test@1234");
//		
//
//		System.out.println(prop.getProperty("password"));
		
//		PropertiesConfiguration config=null;
//		
//		try {
//			 config = new PropertiesConfiguration(System.getProperty("user.dir")+"//config.properties");
//			config.setProperty("password", "Test@123");
//			config.save();
//		} catch (ConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(config.getProperties("password"));
		

//		//to update properties file
//		Properties props = new Properties();
//		try {
//		      //first load old one:
//		      FileInputStream configStream = new FileInputStream(System.getProperty("user.dir")+"//config.properties");
//		      props.load(configStream);
//		      configStream.close();
//
//		      //modifies existing or adds new property
//		      props.setProperty("password", "Test@1234");
//
//		      //save modified property file
//		      FileOutputStream output = new FileOutputStream(System.getProperty("user.dir")+"//config.properties");
//		      props.store(output, "This description goes to the header of a file");
//		      output.close();
//
//		    } catch (IOException ex) {}
//
//		//to get value in properties file
//		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//config.properties");
//		Properties prop=new Properties();
//		prop.load(file);
//		
//		System.out.println(prop.getProperty("username"));
//		System.out.println(prop.getProperty("password"));
		
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		System.out.println(path);
		System.out.println(System.getProperty("user.dir"));
		

	}
	
}
