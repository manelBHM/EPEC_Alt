package com.palindrom;

public class Palindrom {
	
	public static boolean isPalindrome(String a) {
		String reverse = new StringBuffer(a).reverse().toString();
		
		if(reverse.equals(a)) {
			return true;
		} 
		
		return false;
	}

}
