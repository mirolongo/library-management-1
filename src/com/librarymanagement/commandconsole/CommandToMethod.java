package com.librarymanagement.commandconsole;

import com.librarymanagement.MainProduct;
import com.librarymanagement.products.Book;
import com.librarymanagement.products.Movie;
import com.librarymanagement.products.Product;
import com.librarymanagement.products.ProductManagement;

/**
 * This Class This class transforms commands to methods
 */

public class CommandToMethod {

	public void MethodCalling (ParsedCommand parsedCommand, ProductManagement productsMgr) {

		switch (parsedCommand.getCommand()) {
			case LIST:
				MainProduct.showInitialState(productsMgr.list());
				break;
			case CHECKOUT:
				System.out.println("Method under construction");
				break;
			case CHECKIN:
				productsMgr.checkIn(parsedCommand.parseParamToInt());
				break;
			case REGISTER:
				System.out.println("What are you registering? Book (b), Movie (m)");
				System.out.print(">");
				String input = CommandInput.Input();
				if (input.equals("b")) {
					Product product = createBook();
					register(productsMgr, product);
				}else if (input.equals("m")) {
					Product product = createMovie();
					register(productsMgr, product);
				}else {
					throw new IllegalArgumentException("Unknown command");
				}
				break;
			case DEREGISTER:
				System.out.println("Method under construction");
				break;
				//productsMgr.deleteProduct(parsedCommand.parseParamToInt());
				//int productId = CommandInput.InputNumber();
				//Product product = null;
				//deregister(productsMgr,productId, product);
			case INFO:
				productsMgr.info(parsedCommand.parseParamToInt());
				break;
			case QUIT:
				System.out.println("Good bye!");
				System.exit(0);
			case NOTALLOWED:
				throw new IllegalArgumentException("Unknown command");
		}
	}
	//This method register a new product (book or Movie)
	private void register(ProductManagement productsMgr, Product product) {
		productsMgr.insert(product);
		System.out.println("Successfully registered " + product.title);
	}
	//Method under construction
	private void deregister(ProductManagement productsMgr, int productId, Product product) {
		productsMgr.deleteProduct(productId);
		System.out.println("Successfully deregistered " + product.title);
	}
	//This method create a new product of type Book
	private Product createBook() {
		BasicProductInfo basicInfo = askForProductInfo();
		System.out.println("Enter number of pages: ");
		int inputPages = CommandInput.InputNumber();
		System.out.println("Enter publisher: ");
		String publisher = CommandInput.Input();
		Book book = new Book(basicInfo.id, basicInfo.value, basicInfo.title, inputPages, publisher);
		return book;
	}
	//This method create a new product of type Movie
	private Product createMovie() {
		BasicProductInfo basicInfo = askForProductInfo();
		System.out.println("Enter length: ");
		int inputLength = CommandInput.InputNumber();
		System.out.println("Enter rating: ");
		double inputRating = CommandInput.inputRating();
		Movie movie = new Movie(basicInfo.id, basicInfo.value, basicInfo.title, inputLength, inputRating);
		return movie;
	}
	//This method create a product with the common fields of book and movie
	private BasicProductInfo askForProductInfo() {
		BasicProductInfo product = new BasicProductInfo();
		System.out.println("Enter product ID:");
		product.setId(CommandInput.Input());
		System.out.println("Enter title: ");
		product.title = CommandInput.Input();
		System.out.println("Enter value: ");
		product.setValue(CommandInput.Input());
		return product;
	}
	// This class create the setters and Getters to the basic field of products
	private class BasicProductInfo {
		int id;
		String title;
		int value;
		void setId(String inputId) {
			id = parse(inputId);
		}
		void setValue(String inputValue) {
			value = parse(inputValue);
		}
		void setTitle(String title) {
			this.title = title;
		}
		private int parse(String input) {
			try {
				
				return Integer.parseInt(input);
				} 
				catch (NumberFormatException e) {
					throw new IllegalArgumentException("Unknown command");
				}
		}
	}
}
