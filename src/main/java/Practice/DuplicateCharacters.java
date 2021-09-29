package Practice;

public class DuplicateCharacters {

	/*
	 * https://www.javatpoint.com/program-to-find-the-duplicate-characters-in-a-string

	To find the duplicate character from the string, we count the occurrence of each character in the string. If count is greater than 1, it implies that a character has a duplicate entry in the string. In above example, the characters highlighted in green are duplicate characters.

	Algorithm
	1. Define a string.
	2. Two loops will be used to find the duplicate characters. Outer loop will be used to select a character and initialize variable count by 1.
	3. Inner loop will compare the selected character with rest of the characters present in the string.
	4. If a match found, it increases the count by 1 and set the duplicates of selected character by '0' to mark them as visited.
	5. After inner loop, if count of character is greater than 1, then it has duplicates in the string.

	 */
	
	public static void main(String[] args) {
		
		String string1 = "Great responsibility";
		int count;
         
	    //Converts given string into character array  
	    char string[] = string1.toCharArray();  
	    
        //Counts each character present in the string  
		for(int i = 0; i <string.length; i++) {  
            count = 1;  
            for(int j = i+1; j <string.length; j++) {  
                if(string[i] == string[j] && string[i] != ' ') {  
                    count++;  
                    //Set string[j] to 0 to avoid printing visited character  
                    string[j] = '0';  
                }  
            }  
            //A character is considered as duplicate if count is greater than 1  
            if(count > 1 && string[i] != '0')  
                System.out.println(string[i]);  
        }  
    }  
}  