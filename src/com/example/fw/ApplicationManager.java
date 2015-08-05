package com.example.fw;

import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
	
	private Properties properties;
	private String application;
	private String picture;
	private String currentDb;
	private String clearDb;
	private String testDb;
	private String testDbOneContact;
	private String testDbEmptyContact;
	private String testDbTwoContacts;
	private String testDbSimilarContacts;
	private String testDbThreeContacts;	
	private String testDbAfterClean;
	
	private ContactHelper contactHelper;
	private AutoItHelper autoItHelper;
	private ProcessHelper processHelper;
	private DataHelper dataHelper;
	

	private static ApplicationManager singleton;

	public static ApplicationManager getInstance(Properties properties) throws IOException {
		if (singleton == null) {
			singleton = new ApplicationManager();
			singleton.setProperties(properties);
		}
		return singleton;
	}
	
	public ApplicationManager() {
	}
	
	private void setProperties (Properties properties) {
		this.properties = properties;
		application     = properties.getProperty("application");
		picture         = properties.getProperty("picture");
		currentDb       = properties.getProperty("currentDb");
		clearDb         = properties.getProperty("clearDb");
		testDb          = properties.getProperty("testDb");
		testDbOneContact      = properties.getProperty("testDbOneContact");
		testDbEmptyContact    = properties.getProperty("testDbEmptyContact");
		testDbSimilarContacts = properties.getProperty("testDbSimilarContacts");
		testDbTwoContacts     = properties.getProperty("testDbTwoContacts");
		testDbThreeContacts   = properties.getProperty("testDbThreeContacts");
		testDbAfterClean      = properties.getProperty("testDbAfterClean");
	}
	
	public String getProperties(String propertie) {
		switch (propertie) {
			case "application" : return application;
			case "picture"     : return picture;
			case "currentDb"   : return currentDb;
			case "clearDb"     : return clearDb;
			case "testDb"      : return testDb;
			case "testDbOneContact"     : return testDbOneContact;
			case "testDbEmptyContact"   : return testDbEmptyContact;
			case "testDbTwoContacts"    : return testDbTwoContacts;
			case "testDbSimilarContacts": return testDbSimilarContacts;
			case "testDbThreeContacts"  : return testDbThreeContacts;
			case "testDbAfterClean"     : return testDbAfterClean;
		}
		return null;
	}

	public void start() throws IOException {
		getProcessHelper().startProcess();
	}
	
	public void stop() {
		getProcessHelper().stopProcess();
		processHelper = null;
	}

	public ContactHelper getContactHelper() {
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}
	
	public AutoItHelper getAutoItHelper() {
		if (autoItHelper == null) {
			autoItHelper = new AutoItHelper(this);
		}
		return autoItHelper;
	}
	
	public ProcessHelper getProcessHelper() {
		if (processHelper == null) {
			processHelper = new ProcessHelper(this);
		}
		return processHelper;
	}

	public DataHelper getDataHelper() {
		if (dataHelper == null) {
			dataHelper = new DataHelper(this);
		}
		return dataHelper;
	}

}
