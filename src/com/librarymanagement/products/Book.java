package com.librarymanagement.products;

import java.io.Serializable;

import com.librarymanagement.validators.DataValidator;

public class Book extends Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2805419811155607162L;
	private int numberOfPages;
	private String publisher;
	
	//Book Constructor
	//Fields: value, title,  numberOfPages and publisher
	public Book(int productId, int value, String title, int numberOfPages, String publisher) {
		super(productId, value, title);
		this.numberOfPages = numberOfPages;
		this.publisher = publisher;
		DataValidator dataValidator = new DataValidator();
		dataValidator.isPositiveOrThrows(numberOfPages, "Number of pages");
		dataValidator.stringHasDataOrThrows(publisher, "publisher");
	}
	private Book() {
		super();
	}
}
