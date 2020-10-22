package com.librarymanagement.products;

import java.io.Serializable;

public class Book extends Product implements Serializable {

	private int numberOfPages;
	private String publisher;

	public Book(int productId, int value, String title, int numberOfPages, String publisher) {
		super(productId, value, title);
		this.numberOfPages = numberOfPages;
		this.publisher = publisher;
	}
}
