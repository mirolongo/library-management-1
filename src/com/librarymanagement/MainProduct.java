package com.librarymanagement;
import java.util.ArrayList;

import com.librarymanagement.commandconsole.Command;
import com.librarymanagement.commandconsole.CommandInput;
import com.librarymanagement.commandconsole.CommandToMethod;
import com.librarymanagement.commandconsole.ParsedCommand;
import com.librarymanagement.customers.Customer;
import com.librarymanagement.products.*;
public class MainProduct {

	public static void main(String[] args) {
		
		ProductManagement productsMgr = new ProductManagementSerializeble();
		ParsedCommand parsedCommand = new ParsedCommand();
		CommandToMethod commandToMethod = new CommandToMethod();
		showInitialState(productsMgr.list());
		Command command = Command.NONE;
		
		while (command != command.QUIT) {
			try {
			String commandLine = CommandInput.Input();
			parsedCommand.Command(commandLine);
			commandToMethod.MethodCalling(parsedCommand, productsMgr);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void showInitialState(ArrayList<Product> products) {
		System.out.println("Current inventory:");
		for(Product product:products) {
			System.out.println(product.toString());
			
		}
		System.out.print(">");
	}

}
