package com.librarymanagement.products;

import java.io.Serializable;
import java.util.ArrayList;

import com.librarymanagement.customers.Customer;
import com.librarymanagement.validators.DataValidator;

public abstract class Product implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 7452076737395181833L;
public int productId;
public int value;
public String title;
private Customer customer;
private String status =  "(in stock)";
	// Product Constructor
	//Fields: productId, value and title
	public Product(int productId, int value, String title) {
		DataValidator dataValidator = new DataValidator();
		dataValidator.isPositiveOrThrows(productId, " product ID");
		dataValidator.isPositiveOrThrows(value, " product value");
		dataValidator.stringHasDataOrThrows(title, " product title");
		this.productId = productId;
		this.value = value;
		this.title = title;
	}
	protected Product() {
		
	}
	public void checkOut(Customer customer) {
		if (customer != null) {
			throw new IllegalStateException("Cannot lend " + title + " to another customer. It is already borrowed by " + customer.getName() + ".");
		}
		this.customer = customer;
		status = "\n Borrowed by: " + customer.toString();
		
	}
	public void checkIn() {
		if (customer == null) {
			throw new IllegalStateException("Cannot return " + title + " .It is not borrowed by any customer.");
		}
		customer = null;
		status = "(in stock)";
	}
	@Override
	public String toString() {
		String message = productId + " (" +this.getClass().getSimpleName() +"): " + title + ". " + status;
		return message;
		}
	public boolean isAvaliable() {
		return customer == null;
	}
	public Object getNome(ArrayList<Product> products) {
		// TODO Auto-generated method stub
		return null;
	}
}
