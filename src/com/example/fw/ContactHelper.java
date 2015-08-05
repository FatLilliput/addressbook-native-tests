package com.example.fw;
import static com.example.fw.Constants.*;

import java.io.File;

public class ContactHelper extends BaseHelper {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void addContact(Contact contact, boolean confirm) {
		clickAddButton();
		fillForm(contact);
		if (contact.getPhoto() != null)
			uploadPhoto(contact.getPhoto());
		if (confirm) {
			clickSave();
		} else {
			clickCancel();
		}
		
	}

	private void fillForm(Contact contact) {
		manager.getAutoItHelper()
			.send(INPUT_FIRST_NAME,  contact.getFirstName())
			.send(INPUT_LAST_NAME,   contact.getLastName())
			.send(INPUT_STREET,      contact.getStreet())
			.send(INPUT_CITY,        contact.getCity())
			.send(INPUT_POSTAL_CODE, contact.getPostalCode())
			.send(INPUT_COUNTRY,     contact.getCountry())
			.send(INPUT_PHONE,       contact.getPhone())
			.send(INPUT_FAX,         contact.getFax())
			.send(INPUT_MOBILE,      contact.getMobile())
			.send(INPUT_EMAIL,       contact.getEmail())
			.send(INPUT_WEBPAGE,     contact.getWebpage())
			.send(INPUT_ACCOUNT,     contact.getAccount())
			.send(INPUT_NOTES,       contact.getNotes());
	}

	
	private void uploadPhoto(String photo) {
		manager.getAutoItHelper()
			.click(BUTTON_LOAD_PHOTO).winWaitAndActivate(SELECT_PHOTO, "", 5000)
			.send("EDIT1", new File(photo).getAbsolutePath())
			.send(BUTTON_SELECT_PHOTO, "{ENTER}").winWaitAndActivate(ADD_CONTACT, "", 5000);
	}
	
	private void clickSave() {
		manager.getAutoItHelper().click(BUTTON_SAVE).winWaitAndActivate(ADDRESSBOOK, "", 5000);
	}
	
	private void clickCancel() {
		manager.getAutoItHelper().click(BUTTON_NOT_SAVE).winWaitAndActivate(ADDRESSBOOK, "", 5000);
	}

	private void clickAddButton() {
		manager.getAutoItHelper()
			.winWaitAndActivate(ADDRESSBOOK, "", 5000)
			.click(BUTTON_ADD)
			.winWaitAndActivate(ADD_CONTACT, "", 5000);
	}

	public Contact getSavedContact() {
		Contact contact = new Contact();
		manager.getAutoItHelper()
			.focus(CONTACTS_LIST).send("{UP}").send("{SPACE}").click(BUTTON_EDIT)
			.winWaitAndActivate(UPDATE_CONTACT, "", 5000);
		contact
			.setFirstName (manager.getAutoItHelper().getText(INPUT_FIRST_NAME))
			.setLastName  (manager.getAutoItHelper().getText(INPUT_LAST_NAME))
			.setStreet    (manager.getAutoItHelper().getText(INPUT_STREET))
			.setCity	  (manager.getAutoItHelper().getText(INPUT_CITY))
			.setPostalCode(manager.getAutoItHelper().getText(INPUT_POSTAL_CODE))
			.setCountry   (manager.getAutoItHelper().getText(INPUT_COUNTRY))
			.setPhone	  (manager.getAutoItHelper().getText(INPUT_PHONE))
			.setFax		  (manager.getAutoItHelper().getText(INPUT_FAX))
			.setMobile    (manager.getAutoItHelper().getText(INPUT_MOBILE))
			.setEmail     (manager.getAutoItHelper().getText(INPUT_EMAIL))
			.setWebpage   (manager.getAutoItHelper().getText(INPUT_WEBPAGE))
			.setAccount   (manager.getAutoItHelper().getText(INPUT_ACCOUNT))
			.setNotes     (manager.getAutoItHelper().getText(INPUT_NOTES));
		clickCancel();
		return contact;
	}

	public void clickDelete(boolean deleteContact) {
		manager.getAutoItHelper().click(BUTTON_DELETE).winWaitAndActivate(CONFIRM, "", 5000);
		if (deleteContact) {
			manager.getAutoItHelper().click(BUTTON_CONFIRM_DELETE).winWaitAndActivate(ADDRESSBOOK, "", 5000);
		} else {
			manager.getAutoItHelper().click(BUTTON_NOT_DELETE).winWaitAndActivate(ADDRESSBOOK, "", 5000);
		}
	}

	public void selectOneContact() {
		manager.getAutoItHelper().winWaitAndActivate(ADDRESSBOOK, "", 5000)
		.focus(CONTACTS_LIST).send("{DOWN}").send("{DOWN}").send("{SPACE}");
	}

	public void selectSeveralContacts() {
		selectOneContact();
		manager.getAutoItHelper().send("{DOWN}").send("{SPACE}");
	}
	
	public void selectAllContacts() {
		manager.getAutoItHelper().winWaitAndActivate(ADDRESSBOOK, "", 5000)
		.click(BUTTON_SELECT_ALL);
	}
	
	public void exit() {
		manager.getAutoItHelper().click(BUTTON_EXIT).winWaitClose(ADDRESSBOOK);
	}

}
