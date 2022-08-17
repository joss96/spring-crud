package com.example.crud.util;

public class IntegerUtils {
	
	private IntegerUtils() {
	    throw new IllegalStateException("Utility class");
	  }

	
	public static boolean isNumber(String value) {
		boolean isNumber = false;
		try {
			Integer.parseInt(value);
			isNumber = true;
		} catch (NumberFormatException e) {
			return isNumber;
		}
		return isNumber;
	}

}
