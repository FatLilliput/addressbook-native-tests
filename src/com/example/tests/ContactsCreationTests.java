package com.example.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.example.fw.Constants.SAVE_CONTACT;
import static com.example.fw.Constants.CANCEL_SAVE_CONTACT;

import com.example.fw.Contact;

public class ContactsCreationTests extends TestBase {

	@BeforeMethod
	public void setUp() throws Exception {
		TestBase setUp = new TestBase();
		setUp.setUp();
		app.getDataHelper().loadDb(app.getProperties("clearDb"));
		app.start();
	}
	
	@Test
	public void testValidContactCreation() throws IOException {
		Contact contact = new Contact().defaultContact().setPhoto(app.getProperties("picture"));
		app.getContactHelper().addContact(contact, SAVE_CONTACT);
		Assert.assertEquals(contact, app.getContactHelper().getSavedContact());
		app.getContactHelper().exit();
		Assert.assertTrue(app.getDataHelper().isDataBase(app.getProperties("testDbOneContact")));	
	}
	
	@Test
	public void testEmptyContactCreation() throws IOException {
		Contact contact = new Contact();
		app.getContactHelper().addContact(contact, SAVE_CONTACT);
		Assert.assertEquals(contact, app.getContactHelper().getSavedContact());
		app.getContactHelper().exit();
		Assert.assertTrue(app.getDataHelper().isDataBase(app.getProperties("testDbEmptyContact")));
	}
	
	@Test
	public void testNoContactCreation() throws IOException {
		Contact contact = new Contact().defaultContact().setPhoto(app.getProperties("picture"));
		app.getContactHelper().addContact(contact, CANCEL_SAVE_CONTACT);
		app.getContactHelper().exit();
		Assert.assertTrue(app.getDataHelper().isDataBase(app.getProperties("clearDb")));	
	}
	
	/*
	 * TODO: This test fails. Right now Addressbook lets you add contact with invalid parameters,
	 * but it can't read it. An error message appears when you try to edit or delete this contact
	 * So there should be validator for invalid contacts parameters
	 * 
	 */
	@Test
	public void testInvalidContactCreation() throws IOException {
		Contact contact = new Contact().setFirstName("'");
		app.getContactHelper().addContact(contact, SAVE_CONTACT);
		//TODO: There should be some message
		app.getContactHelper().exit();
		Assert.assertTrue(app.getDataHelper().isDataBase(app.getProperties("clearDb")));	
	}
	
	//TODO: Not sure its permitted to add two similar contacts cause there are problems in modifying them
	@Test
	public void testSimilarContactsCreation() throws IOException {
		Contact contact = new Contact().setFirstName("SimilarName").setLastName("SimilarSurname");
		app.getContactHelper().addContact(contact, SAVE_CONTACT);
		app.getContactHelper().addContact(contact, SAVE_CONTACT);
		app.getContactHelper().exit();
		Assert.assertTrue(app.getDataHelper().isDataBase(app.getProperties("testDbSimilarContacts")));	
	}
}
