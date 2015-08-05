package com.example.tests;

import static com.example.fw.Constants.DELETE_CONTACT;
import static com.example.fw.Constants.CANCEL_DELETE_CONTACT;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ContactsDeletingTests extends TestBase {
	
	@BeforeMethod
	public void setUp() throws Exception {
		TestBase setUp = new TestBase();
		setUp.setUp();
		app.getDataHelper().loadDb(app.getProperties("testDb"));
		app.start();
	}
	
	@Test
	public void testOneContactRemoving() throws IOException {
		app.getContactHelper().selectOneContact();
		app.getContactHelper().clickDelete(DELETE_CONTACT);
		app.getContactHelper().exit();
		Assert.assertTrue(app.getDataHelper().isDataBase(app.getProperties("testDbThreeContacts")));	
	}
	
	@Test
	public void testTwoContactRemoving() throws IOException {
		app.getContactHelper().selectSeveralContacts();
		app.getContactHelper().clickDelete(DELETE_CONTACT);
		app.getContactHelper().exit();
		Assert.assertTrue(app.getDataHelper().isDataBase(app.getProperties("testDbTwoContacts")));	
	}
	
	@Test
	public void testAllContactRemoving() throws IOException {
		app.getContactHelper().selectAllContacts();
		app.getContactHelper().clickDelete(DELETE_CONTACT);
		app.getContactHelper().exit();
		Assert.assertTrue(app.getDataHelper().isDataBase(app.getProperties("testDbAfterClean")));	
	}
	
	@Test
	public void testNoContactRemoving() throws IOException {
		app.getContactHelper().selectOneContact();
		app.getContactHelper().clickDelete(CANCEL_DELETE_CONTACT);
		app.getContactHelper().exit();
		Assert.assertTrue(app.getDataHelper().isDataBase(app.getProperties("testDb")));	
	}

}
