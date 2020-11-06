package com.librarymanagement.customers;

import java.io.Serializable;

import com.librarymanagement.validators.DataValidator;

public class Customer implements Serializable {

	/**
	 * Customer object creation
	 */
	private static final long serialVersionUID = -4229408856710300693L;
	private String name = "";
	private String phoneNumber = "";

	public Customer(String name, String phoneNumber) {
		DataValidator dataValidator = new DataValidator();
		dataValidator.stringHasDataOrThrows(name, "customer name");
		dataValidator.PhoneNumberValidOrThrows(phoneNumber, "phone number");
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return name + ", " + phoneNumber;
	}

	public String getName() {

		return this.name;
	}
}