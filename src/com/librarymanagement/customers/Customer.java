package com.librarymanagement.customers;

import com.librarymanagement.validators.DataValidator;

public class Customer {
	private String name = "";
	private String phoneNumber = "";

	public Customer(String name, String phoneNumber){
		DataValidator dataValidator = new DataValidator();
		dataValidator.stringHasDataOrThrows(name, "customer name");
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return name + ", " + phoneNumber;
	}
}