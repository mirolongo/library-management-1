package com.librarymanagement.products;

import java.io.Serializable;
import java.util.ArrayList;

import com.librarymanagement.customers.Customer;

public class ProductManagementImpl implements ProductManagement, Serializable {
	

	/**
	 * This class implements interface and Serialized the objects
	 */
	private static final long serialVersionUID = 7587761306422491402L;
	protected ArrayList<Product> products = new ArrayList<Product>();
	
	//Delete a product from file
	@Override
	public void deleteProduct(int productId) throws IllegalArgumentException {
			findByIdOrThrow(productId);
			Product productToRemove = null;
			for (Product product : products) {
			  if (product.productId == productId) {
			    productToRemove = product;
			    break;
			  }
			}
			products.remove(productToRemove);
			System.out.println("Successfully deregistered "); ///TODO
	}	
	// Borrowed a product to customer
	@Override
	public void checkOut(int productId, String name, String phoneNumber) {
		Product product = findByIdOrThrow(productId);
		product.checkOut(new Customer(name, phoneNumber));
	}
	//Confirm if the product is borrowed
	private Product findByIdOrThrow(int productId) throws IllegalArgumentException{
		Product product = findById(productId);
		if (product == null) {
			throw new IllegalArgumentException("Error: No product with id  " + productId + " registered.");
		}
		return product;
	}
	//Return a product and unlink product of a customer 
	@Override
	public void checkIn(int productId) {
		Product product = findByIdOrThrow(productId);
		product.checkIn();
	}
	
	 public boolean equals(Product product) {
	        if (!(product instanceof Product)) {
	            return false;
	        }
	        final Product other = (Product) product;
	        return this.getName(products).equals(other.getNome(products));
	    }
	
	

	private Object getName(ArrayList<com.librarymanagement.products.Product> products2) {
		// TODO Auto-generated method stub
		return null;
	}

	// Command info, returns a product with a product parameter (info 999999)
	@Override
	public void info(int productId) throws IllegalArgumentException {
		checkIfProductExists(productId);
		for (Product product : products) {
			if (product.productId == productId) {
	            System.out.println(product);
	        }
			if (checkIfProductExists(productId) == false) {
				throw new IllegalArgumentException("Error: No product with id  " + productId + " registered.");
				
			}
		}
	}
	// Create a list of products
	@Override
	public ArrayList<Product> list() {
		return products;
	}
	//Check if exists a product in the file "Product_Library.txt"
	private boolean checkIfProductExists(int id) {
		for(Product product:products ) {
			if (product.productId == id) {
				return true;
			}
		}
		return false;
	}
	//Confirm if productId exists
	private Product findById(int id) {
		for(Product product:products ) {
			if (product.productId == id) {
				return product;
			}
		}
		return null;
	}
	
	//Insert a new product in the file "Product_Library.txt"
	@Override
	public void insert(Product newProduct) throws IllegalArgumentException {
		if (checkIfProductExists(newProduct.productId)) {
			throw new IllegalArgumentException("Error: Product with " + newProduct.productId + " is already registered.");
		}
		products.add(newProduct);
		
	}
}
