
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Base {

	public static void main(String[] args) throws IOException, ConfigurationException {

		String[] headerArray = { "SHOP", "TATTOO QUIZ", "CUSTOM", "COLLABS", "TRENDING", "FREEHAND INK", "SALE",
				"HOW IT WORKS", "BTS | INKBOX" };

		for (int i = 0; i < headerArray.length; i++) {
        System.out.println(headerArray[i]);
		}

	}

}
