package com.librarymanagement.products;
import java.util.ArrayList;

public interface ProductManagement {
	
	 void insert(Product product);
	 void deleteProduct(int productId);
	 void checkOut(int productId, String name, String phoneNumber);
	 void checkIn(int productId);
	 void info(int productId);
	 ArrayList<Product> list();
}
