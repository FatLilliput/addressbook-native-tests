/*
 * This class contains methods needed for correctly auto-tests work 
 * and common methods for all application's modules
 */
package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.example.fw.ApplicationManager;

public class TestBase {
	public static ApplicationManager app;
	
	@BeforeMethod
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = ApplicationManager.getInstance(properties);
//		app.getDataHelper().loadDb(app.getProperties("clearDb"));
//		app.start();
	  }

	@AfterMethod
	public void tearDown() throws Exception {
		app.stop();
	}

}
