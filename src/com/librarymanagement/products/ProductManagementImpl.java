package com.librarymanagement.products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import com.librarymanagement.customers.Customer;

public class ProductManagementImpl implements ProductManagement, Serializable {

	/**
	 * This class implements interface and Serialized the objects
	 */
	private static final long serialVersionUID = 7587761306422491402L;
	protected ArrayList<Product> products = new ArrayList<Product>();

	// Delete a product from file
	@Override
	public void deleteProduct(int productId) throws IllegalArgumentException {
		findByIdOrThrow(productId);
		Product productToRemove = null;
		for (Product product : products) {
			if (product.getProductId() == productId) {
				productToRemove = product;
				break;
			}
		}
		products.remove(productToRemove);
	}

	// Borrowed a product to customer
	@Override
	public void checkOut(int productId, String name, String phoneNumber) {
		Product product = findByIdOrThrow(productId);
		product.checkOut(new Customer(name, phoneNumber)); 
	}

	// Confirm if the product exists
	@Override
	public Product findByIdOrThrow(int productId) throws IllegalArgumentException {
		Product product = findById(productId);
		if (product == null) {
			throw new IllegalArgumentException("Error: No product with id  " + productId + " registered.");

		}
		return product;
	}

	// Return a product and unlink product of a customer
	@Override
	public void checkIn(int productId) {
		Product product = findByIdOrThrow(productId);
		product.checkIn();
	}

	// Command info, returns a product with a product parameter
	@Override
	public Product info(int productId) throws IllegalArgumentException {
		checkIfProductExists(productId);
		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		throw new IllegalArgumentException("Error: No product with id  " + productId + " registered.");
	}

	// Create a list of products
	@Override
	public ArrayList<Product> list() {
		Collections.sort(products, new Comparator<Product>() {
			@Override
			public int compare(Product z1, Product z2) {
				if (z1.getProductId() > z2.getProductId())
					return 1;
				if (z1.getProductId() < z2.getProductId())
					return -1;
				return 0;
			}
		});
		return products;
	}

	// Check if exists a product in the file "Product_Library.txt"
	private boolean checkIfProductExists(int id) {
		for (Product product : products) {
			if (product.getProductId() == id) {
				return true;
			}
		}
		return false;
	}

	// Confirm if productId exists
	private Product findById(int id) {
		for (Product product : products) {
			if (product.getProductId() == id) {
				return product;
			}
		}
		return null;
	}

	// Insert a new product in the file "Product_Library.txt"
	@Override
	public void insert(Product newProduct) throws IllegalArgumentException {
		if (checkIfProductExists(newProduct.getProductId())) {
			throw new IllegalArgumentException(
					"Error: Product with " + newProduct.getProductId() + " is already registered.");
		}
		products.add(newProduct);

	}
}
