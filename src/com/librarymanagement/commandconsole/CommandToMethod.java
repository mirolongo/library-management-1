package com.librarymanagement.commandconsole;

import com.librarymanagement.MainProduct;
import com.librarymanagement.products.Book;
import com.librarymanagement.products.Movie;
import com.librarymanagement.products.Product;
import com.librarymanagement.products.ProductManagement;
import com.librarymanagement.products.ProductManagementImpl;

/**
 * This Class This class transforms commands to methods
 */

public class CommandToMethod {

	public void MethodCalling(ParsedCommand parsedCommand, ProductManagement productsMgr) {

		switch (parsedCommand.getCommand()) {
		case LIST:
			MainProduct.showInitialState(productsMgr.list());
			break;
		case CHECKOUT:
			checkout(productsMgr, parsedCommand);
			break;
		case CHECKIN:
			checkin(productsMgr, parsedCommand.parseParamToInt());
			break;
		case REGISTER:
			register(productsMgr, parsedCommand);
			break;
		case DEREGISTER:
			deregister(productsMgr, parsedCommand.parseParamToInt());
			break;
		case INFO:
			Product product = productsMgr.info(parsedCommand.parseParamToInt());
			System.out.println(product.info());
			break;
		case QUIT:
			System.out.println("Good bye!");
			System.exit(0);
		case NOTALLOWED:
		default:
			throw new IllegalArgumentException("Unknown command");
		}
	}

	// Method that removes a product's association with a customer
	private void checkin(ProductManagement productsMgr, int productId) {
		Product product = productsMgr.findByIdOrThrow(productId);
		String name = product.getCustomer().getName();
		productsMgr.checkIn(productId);
		System.out.println("Succesfully returned " + product.getTitle() + " from " + name);

	}

//Method of associating a product with a customer
	private void checkout(ProductManagement productsMgr, ParsedCommand parsedCommand) {
		Product product = productsMgr.findByIdOrThrow(parsedCommand.parseParamToInt());
		System.out.println("Enter customer name:");
		String name = CommandInput.Input();
		System.out.println("Enter customer phone number:");
		String phone = CommandInput.Input();
		productsMgr.checkOut(parsedCommand.parseParamToInt(), name, phone);

		System.out.println("Successfully lended " + product.getTitle() + " to " + product.getCustomer().getName());
	}

	// New product registration class (common book and movie registrations)
	private void register(ProductManagement productsMgr, ParsedCommand parsedCommand) {
		System.out.println("What are you registering? Book (b), Movie (m)");
		System.out.print(">");
		String input = CommandInput.Input();
		if (input.equals("b")) {
			Product product = createBook();
			register(productsMgr, product);
		} else if (input.equals("m")) {
			Product product = createMovie();
			register(productsMgr, product);
		} else {
			throw new IllegalArgumentException("Unknown command");
		}

	}

	// This method register a new product (book or Movie)
	private void register(ProductManagement productsMgr, Product product) {
		productsMgr.insert(product);
		System.out.println("Successfully registered " + product.getTitle());
		System.out.print(">");

	}

	// This method deregister a new product (book or Movie)
	private void deregister(ProductManagement productsMgr, int productId) {
		String title = productsMgr.findByIdOrThrow(productId).getTitle();
		productsMgr.deleteProduct(productId);
		System.out.println("Successfully deregistered " + title);
	}

	// This method create a new product of type Book
	private Product createBook() {
		BasicProductInfo basicInfo = askForProductInfo();
		System.out.println("Enter number of pages: ");
		System.out.print(">");
		int inputPages = CommandInput.InputNumber();
		System.out.println("Enter publisher: ");
		System.out.print(">");
		String publisher = CommandInput.Input();
		Book book = new Book(basicInfo.id, basicInfo.value, basicInfo.title, inputPages, publisher);
		return book;
	}

	// This method create a new product of type Movie
	private Product createMovie() {
		BasicProductInfo basicInfo = askForProductInfo();
		System.out.println("Enter length: ");
		System.out.print(">");
		int inputLength = CommandInput.InputNumber();
		System.out.println("Enter rating: ");
		System.out.print(">");
		double inputRating = CommandInput.inputDouble();
		Movie movie = new Movie(basicInfo.id, basicInfo.value, basicInfo.title, inputLength, inputRating);
		return movie;
	}

	// This method create a product with the common fields of book and movie
	private BasicProductInfo askForProductInfo() {
		BasicProductInfo product = new BasicProductInfo();
		System.out.println("Enter product ID:");
		System.out.print(">");
		product.setId(CommandInput.Input());
		System.out.println("Enter title: ");
		System.out.print(">");
		product.title = CommandInput.Input();
		System.out.println("Enter value: ");
		System.out.print(">");
		product.setValue(CommandInput.Input());
		return product;
	}

	// This class create the Setters and Getters to the basic field of products
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
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Unknown command");
			}
		}
	}
}
