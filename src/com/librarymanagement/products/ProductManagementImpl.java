package com.librarymanagement.products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductManagementImpl implements ProductManagement, Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7587761306422491402L;
	protected ArrayList<Product> products = new ArrayList<Product>();
	
	
	@Override
	public void deleteProduct(int productId) throws IllegalArgumentException {
		if(checkIfProductExists(productId)==true) {
			Product productToRemove = null;
			for (Product product : products) {
			  if (product.productId == productId) {
			    productToRemove = product;
			    break;
			  }
			}
			products.remove(productToRemove);
		}	
			throw new IllegalArgumentException("Product " + productId + " doesn't exists in database, try again");
	}	

	@Override
	public void checkOut(int productId, String name, String phoneNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkIn(int productId) {
		// TODO Auto-generated method stub
		
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
				throw new IllegalArgumentException("The product Id " + productId + " doesn't exists in database, try again.");
			}
		}
	}
	private Product Product(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> list() {
		// TODO Auto-generated method stub
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
	
	//Insert a new product in the file "Product_Library.txt"
	@Override
	public void insert(Product newProduct) throws IllegalArgumentException {
		if (checkIfProductExists(newProduct.productId)) {
			throw new IllegalArgumentException("Error: Product with " + newProduct.productId + " is already registered.");
		}
		products.add(newProduct);
		
	}
}
