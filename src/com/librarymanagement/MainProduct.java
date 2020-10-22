package com.librarymanagement;
import com.librarymanagement.customers.Customer;
import com.librarymanagement.products.*;
public class MainProduct {

	public static void main(String[] args) {
		Product book = new Book(1, 1, "Java Begginer", 10, "Herbert");
		book.checkOut(new Customer("Miro", "111111"));
		Product movie = new Movie(1, 1, "Terminator", 10 , 1);
		System.out.println(book);
		System.out.println(movie);
	}
}
