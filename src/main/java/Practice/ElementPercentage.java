package Practice;

import java.text.DecimalFormat;

/*
 * Find Percentage Of Uppercase Letters, Lowercase Letters, Digits And Special Characters In String
 * 
 */

public class ElementPercentage {

	public static void main(String[] args) {
		getCharPercentage("Mayur Patel");
		getCharPercentage("This is a Code to find Percentage of Letters 123 %#");
		getCharPercentage("12345");
		getCharPercentage("@#$%^&*");
	}
	
	public static void getCharPercentage(String str) {
		
		int len = str.length();
		
		int upperCaseCount = 0;
		int lowerCaseCount = 0;
		int digits = 0;
		int specChars = 0;
		
		for (int i=0; i<len; i++) {
			
			char ch = str.charAt(i);
			
			if(Character.isUpperCase(ch)) {
				upperCaseCount++;
			}
			else if(Character.isLowerCase(ch)) {
				lowerCaseCount++;
			}
			else if(Character.isDigit(ch)) {
				digits++;
			}
			else {
				specChars++;
			}
			
		}
		
		double upperCasePercentage = (upperCaseCount * 100.0)/len;
		double lowerCasePercentage = (lowerCaseCount * 100.0)/len;
		double digitPercentage = (digits * 100.0)/len;
		double specCharsPercentage = (specChars * 100.0)/len;
		
		System.out.println("In the given String: " + str);
		
		DecimalFormat formatter = new DecimalFormat("##.##");
		
		System.out.println("upper case % ---> " + formatter.format(upperCasePercentage));
		System.out.println("lower case % ---> " + formatter.format(lowerCasePercentage));
		System.out.println("digits % ---> " + formatter.format(digitPercentage));
		System.out.println("special char % ---> " + formatter.format(specCharsPercentage));
		
		System.out.println(upperCasePercentage+lowerCasePercentage+digitPercentage+specCharsPercentage);
		
		System.out.println("-----------------------------");
		
	
	}

}
