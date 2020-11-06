package com.librarymanagement.commandconsole;

import java.util.Scanner;

// This class manipulate inputs of system
public class CommandInput {

	public static String Input() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static int InputNumber() {
		Scanner scanner = new Scanner(System.in);
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			throw new IllegalArgumentException("Unknown command");
		}
	}

	public static double inputDouble() {
		Scanner scanner = new Scanner(System.in);
		try {
			return scanner.nextDouble();
		} catch (Exception e) {
			throw new IllegalArgumentException("Unknown command");
		}
	}
}