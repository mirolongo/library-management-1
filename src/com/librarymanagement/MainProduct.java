package com.librarymanagement;
import com.librarymanagement.customers.Customer;
import com.librarymanagement.products.*;
public class MainProduct {

	
	public static void main(String[] args) {
		
		ProductManagement productsMgr = new ProductManagementSerializeble();
		//productsMgr.info(100);
		//productsMgr.deleteProduct(208);
		Product book = new Book(203, 100, "Java Begginer", 1000, "Herbert");
		book.checkOut(new Customer("Miro", "123-456-7890"));
		Product movie = new Movie(208, 100, "Terminator", 150 , 9.5);
		productsMgr.insert(book);
		productsMgr.insert(movie);
		for(Product product:productsMgr.list()) {
			System.out.println(product.toString());
		}
	}
}
