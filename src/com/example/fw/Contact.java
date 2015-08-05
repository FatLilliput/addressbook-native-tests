package com.example.fw;

public class Contact {

	private String firstName = "";
	private String lastName = "";
	private String street = "";
	private String city = "";
	private String postalCode = "";
	private String country = "";
	private String phone = "";
	private String fax = "";
	private String mobile = "";
	private String email = "";
	private String webpage = "";
	private String account = "";
	private String notes = "";
	private String photo;
	
	public  Contact() {
	}

	public String getFirstName() {
		return firstName;
	}

	public Contact setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Contact setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getStreet() {
		return street;
	}

	public Contact setStreet(String street) {
		this.street = street;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Contact setCity(String city) {
		this.city = city;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public Contact setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public Contact setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Contact setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getFax() {
		return fax;
	}

	public Contact setFax(String fax) {
		this.fax = fax;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public Contact setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Contact setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getWebpage() {
		return webpage;
	}

	public Contact setWebpage(String webpage) {
		this.webpage = webpage;
		return this;
	}

	public String getAccount() {
		return account;
	}

	public Contact setAccount(String account) {
		this.account = account;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public Contact setNotes(String notes) {
		this.notes = notes;
		return this;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public Contact setPhoto(String photo) {
		this.photo = photo;
		return this;
	}
	public Contact defaultContact() {
		return new Contact()
			.setFirstName("testerName")
			.setLastName("testerSurname")
			.setStreet("tester Street")
			.setCity("Tester-City")
			.setPostalCode("123 456")
			.setCountry("TesterCountry")
			.setPhone("123-45-67")
			.setFax("678 99")
			.setMobile("(921)7885432")
			.setEmail("e@mail.com")
			.setWebpage("localhost")
			.setAccount("skype.name")
			.setNotes("Note note")
		;
//		return contact;
	}
	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName
				+ ", street=" + street + ", city=" + city + ", postalCode="
				+ postalCode + ", country=" + country + ", phone=" + phone
				+ ", fax=" + fax + ", mobile=" + mobile + ", email=" + email
				+ ", webpage=" + webpage + ", account=" + account + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((webpage == null) ? 0 : webpage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (webpage == null) {
			if (other.webpage != null)
				return false;
		} else if (!webpage.equals(other.webpage))
			return false;
		return true;
	}

}
