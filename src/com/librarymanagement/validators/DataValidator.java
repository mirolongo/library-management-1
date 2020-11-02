package com.librarymanagement.validators;

//This class validates all fields of the Product, Movie and Book classes.

public class DataValidator {
	//Validate if number is positive
	public void isPositiveOrThrows(int value, String name) throws IllegalArgumentException {
		if (value < 1) {
			throw new IllegalArgumentException(name + " is in incorrect format");
		}
		
	}
	//Validate if the field is not empty
	public void stringHasDataOrThrows(String value, String name) throws IllegalArgumentException {
		if (value == null || value.isEmpty()){
			throw new IllegalArgumentException(name + " is in incorrect format");
		}
	}
	//Validate if the phone number of customer is valid (right syntax)
	public void PhoneNumberValidOrThrows(String value, String name) {
		if (value.length() != 12) {
			throw new IllegalArgumentException(name + " enter 12 characters with syntax 999-999-9999");
		}
		String[] valueConfirm = value.split("-");
		int size = valueConfirm.length;
		int[] valueConfirm1 = new int[size];
		for (int i =0; i < size; i++) {
			valueConfirm1[i] = Integer.parseInt(valueConfirm[i]);
			if (valueConfirm1[0] < 0 || valueConfirm1[1] < 0 || valueConfirm1[2]< 0 ) {
				throw new IllegalArgumentException(name + " is in incorrect format, the systax of phone number is 999-999-9999");
			}
			if (valueConfirm[0].length() > 3 || valueConfirm[1].length() > 3 || valueConfirm[2].length() > 4) {
				throw new IllegalArgumentException(name + " is in incorrect format, the syntax of phone number is (999-999-9999)");
			}
		}
	}
	//Validate if the rating of movies is double between 0 and 10
	public void ratingIsValidNumberOrThrows(double value, String name) throws IllegalArgumentException {
		if (value < 0 || value > 10) {
			throw new IllegalArgumentException(name + " enter a rating between 0 and 10");
		}
	}

}
