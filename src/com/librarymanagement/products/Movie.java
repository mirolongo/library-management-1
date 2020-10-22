package com.librarymanagement.products;

import java.io.Serializable;

public class Movie extends Product implements Serializable {

	private int length;
	private double rating;

	public Movie(int productId, int value, String title, int length, double rating) {
		super(productId, value, title);
		this.length = length;
		this.rating = rating;
		
	}
}
