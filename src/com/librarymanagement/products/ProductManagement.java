package com.librarymanagement.products;
import java.util.ArrayList;

public interface ProductManagement {
	
	 void insertBook(Book aBook);
	 void insertMovie(Movie aMovie);
	 void deleteProduct(int productId);
	 void checkOut(int productId, String name, String phoneNumber);
	 void checkIn(int productId);
	 Product info(int productId);
	 ArrayList<Product> list();
}
