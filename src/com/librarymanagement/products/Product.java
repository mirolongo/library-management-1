package com.librarymanagement.products;

import com.librarymanagement.customers.Customer;
import com.librarymanagement.validators.DataValidator;

public abstract class Product {
public int productId;
public int value;
public String title;
private Customer customer;
private String status =  "(in stock)";
	public Product(int productId, int value, String title) {
		DataValidator dataValidator = new DataValidator();
		dataValidator.isPositiveOrThrows(productId, "product ID");
		dataValidator.isPositiveOrThrows(value, "product value");
		dataValidator.stringHasDataOrThrows(title, "product title");
		this.productId = productId;
		this.value = value;
		this.title = title;
	}
	public void checkOut(Customer customer) {
		this.customer = customer;
		status = "\n Borrowed by: " + customer.toString();
		
	}
	public void checkIn() {
		customer = null;
		status = "(in stock)";
	}
	@Override
	public String toString() {
		String message = productId + "(" +this.getClass().getSimpleName() +"): " + title + ". " + status;
		return message;
		}
	public boolean isAvaliable() {
		return customer == null;
	}
	//12345 (Book): To Kill a Mockingbird.
   // Borrowed by: Alice Doe, 832-337-2959
   // 12346 (Book): The Great Gatsby. (in stock)
}
