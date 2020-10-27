package com.librarymanagement.products;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductManagementImpl implements ProductManagement, Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7587761306422491402L;
	protected ArrayList<Product> products = new ArrayList<Product>();
	
	
	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkOut(int productId, String name, String phoneNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkIn(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product info(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> list() {
		// TODO Auto-generated method stub
		return products;
	}
	
	private boolean checkIfProductExists(int id) {
		for(Product product:products ) {
			if (product.productId == id) {
				return true;
			}
		}
		return false;
	}
	

	@Override
	public void insert(Product newProduct) throws IllegalArgumentException {
		if (checkIfProductExists(newProduct.productId)) {
			throw new IllegalArgumentException("Error: Product with " + newProduct.productId + " is already registered.");
		}
		products.add(newProduct);
		
	}
}
