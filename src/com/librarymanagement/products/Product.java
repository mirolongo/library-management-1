package com.librarymanagement.products;

import java.io.Serializable;
import com.librarymanagement.customers.Customer;
import com.librarymanagement.validators.DataValidator;

public abstract class Product implements Serializable {
	/**
	 * Base class of business Product
	 */
	private static final long serialVersionUID = 7452076737395181833L;
	private int productId;
	private int value;
	private String title;
	private Customer customer;
	private String status = "(in stock)";

	// Product Constructor
	// Fields: productId, value and title
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
		if (this.customer != null) {
			Customer customerBorrowed = this.customer;
			throw new IllegalStateException("Cannot lend " + title + " to another customer. It is already borrowed by "
					+ customerBorrowed.getName() + ".");
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
		return getInfo() + ". " + status;
	}

	public int getProductId() {
		return productId;
	}

	public int getValue() {
		return value;
	}

	public String getTitle() {
		return title;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getStatus() {
		return status;
	}

	public boolean isAvaliable() {
		return customer == null;
	}

	public String info() {

		return getInfo().concat(": Value " + this.value + "kr");
	}

	protected String getInfo() {
		return productId + " (" + this.getClass().getSimpleName() + "): " + title;
	}
}
