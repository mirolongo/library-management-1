package com.librarymanagement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.librarymanagement.customers.Customer;
import com.librarymanagement.products.*;
public class MainProduct {

	
	public static void main(String[] args) {
		ProductManagement productsMgr = new ProductManagementSerializeble();
		Product book = new Book(22, 100, "Java Begginer", 1000, "Herbert");
		book.checkOut(new Customer("Miro", "123-456-7890"));
		Product movie = new Movie(21, 100, "Terminator", 150 , 9.5);
		productsMgr.insert(book);
		productsMgr.insert(movie);
		for(Product product:productsMgr.list()) {
			System.out.println(product.toString());
		}
		
		/**
		book.checkOut(new Customer("Miro", "123-456-7890"));
		Product movie = new Movie(2, 100, "Terminator", 150 , 9.5);
		movie.checkOut(new Customer("Joao", "444-686-6666"));
		System.out.println(book);
		System.out.println(movie);
		movie.checkIn();
		book.checkIn();
		System.out.println();
		System.out.println(movie);
		System.out.println(book);
		Product book1 = new Book(2, 100, "E o Vento Levou", 500, "BenHur");
		Product movie1 = new Movie(4, 150, "A volta dos que nao foram",150, 9.99);
		book1.checkOut(new Customer("Jose", "333-333-3333"));
		movie1.checkOut(new Customer("Maria", "000-000-0001"));
		System.out.println();
		System.out.println(book1);
		System.out.println(movie1);
		book1.checkIn();
		movie1.checkIn();
		System.out.println();
		System.out.println(book1);
		System.out.println(movie1);
		**/
	}
}
