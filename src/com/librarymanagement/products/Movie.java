package com.librarymanagement.products;

import java.io.Serializable;

import com.librarymanagement.validators.DataValidator;

public class Movie extends Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2438096678377822638L;
	private int length;
	private double rating;

	public Movie(int productId, int value, String title, int length, double rating) {
		super(productId, value, title);
		this.length = length; 
		this.rating = rating;
		DataValidator dataValidator = new DataValidator(); 
		dataValidator.ratingIsValidNumberOrThrows(rating, "rating");
		dataValidator.isPositiveOrThrows(length, "length");
	}
}
