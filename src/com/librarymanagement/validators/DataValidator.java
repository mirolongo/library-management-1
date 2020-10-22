package com.librarymanagement.validators;

public class DataValidator {
	public void isPositiveOrThrows(int value, String name) throws IllegalArgumentException {
		if (value < 1) {
			throw new IllegalArgumentException(name + " is in incorrect format");
		}
		
	}
	public void stringHasDataOrThrows(String value, String name) throws IllegalArgumentException {
		if (value == null || value.isEmpty()){
			throw new IllegalArgumentException(name + " is in incorrect format");
		}
	}
}
