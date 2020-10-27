package com.librarymanagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.librarymanagement.products.Product;
import com.librarymanagement.products.ProductManagement;
import com.librarymanagement.products.ProductManagementImpl;

public class ProductManagementSerializeble implements ProductManagement {

	/**
	 * 
	 */
	ProductManagement productManagement = new ProductManagementImpl();
	private static final long serialVersionUID = -623012340337380129L;

	public ProductManagementSerializeble() {
		ProductManagement product = read();
		if (product != null) {
			productManagement = product;
		}
	}

	private void save() {
		try {
			FileOutputStream fileOut = new FileOutputStream("Test1.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(productManagement);
			out.close();
			fileOut.close();
		} catch (Exception e) {
		}
	}
	static ProductManagement read() {
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		ProductManagement p = null;
		try {
			 fileIn = new FileInputStream("Test1.txt");
			 in = new ObjectInputStream(fileIn);
			p = (ProductManagement)in.readObject();
			in.close();
			fileIn.close();
		} catch (Exception e) {
			
		
		}
		return p;
	
	}

	@Override
	public void insert(Product product) {
		productManagement.insert(product);
		save();
	}

	@Override
	public void deleteProduct(int productId) {
		productManagement.deleteProduct(productId);
		save();
		
	}

	@Override
	public void checkOut(int productId, String name, String phoneNumber) {
		productManagement.checkOut(productId, name, phoneNumber);
		save();
	}

	@Override
	public void checkIn(int productId) {
		productManagement.checkIn(productId);
		save();
	}

	@Override
	public Product info(int productId) {
		return productManagement.info(productId);
	}

	@Override
	public ArrayList<Product> list() {
		return productManagement.list();
	}
}
