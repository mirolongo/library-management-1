package com.librarymanagement.commandconsole;

import java.util.Scanner;

public class CommandInput {
	
	public static String Input() {
		Scanner scanner = new Scanner(System.in);
		String toString = scanner.nextLine();
		System.out.println(toString);
		return toString;
		
	}
}
