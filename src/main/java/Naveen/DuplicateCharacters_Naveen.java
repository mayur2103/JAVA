package Naveen;

import java.util.HashMap;
import java.util.Set;


public class DuplicateCharacters_Naveen {

	public static void main(String[] args) {
		printDuplicateCharacters("A");
		printDuplicateCharacters("");
		printDuplicateCharacters(null);
		printDuplicateCharacters("java");
		printDuplicateCharacters("TTI");
		printDuplicateCharacters("tesla");
		printDuplicateCharacters("1000");
		printDuplicateCharacters("007 james bond");
		printDuplicateCharacters(" ");
		
	}
	
	public static void printDuplicateCharacters(String str) {
		if (str == null) {
			System.out.println("NULL String");
			return;
		}
		
		if (str.isEmpty()) {
			System.out.println("Empty String");
			return;
		}
		
		if (str.length() == 1) {
			System.out.println("Single Char String");
			return;
		}
		
		char words[] = str.toCharArray();
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		
		for (Character ch : words) {
			if (charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch) + 1);
			}
			else {
				charMap.put(ch, 1);
			}
		}
		
		//print the map:
		Set<HashMap.Entry<Character, Integer>> entrySet = charMap.entrySet();
		
		for (HashMap.Entry<Character, Integer> entry : entrySet) {
			if(entry.getValue() > 1) {
				System.out.println(entry.getKey() +":" + entry.getValue());
			}
		}
	}


}
