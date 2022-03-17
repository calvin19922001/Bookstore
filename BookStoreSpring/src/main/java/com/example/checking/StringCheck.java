package com.example.checking;


public class StringCheck {
	
	public static String filterNullAndBlank(String theString, String replacement) {
		if (theString == null || theString.trim().length() <= 0) {
			return replacement;
		} 
		else {
			return theString;
		}
	}
	
	public static boolean isNull(String str) {
		return str == null;
	}
	
	public static boolean isEmpty(String str) {
		return "".equals(str.trim());
	}
	
	public static boolean isNotNullOrEmpty(String str) {
		return !isNull(str) || !isEmpty(str);
	}
	
}
