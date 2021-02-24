package main;

public class WordInA2dCharacterArray {
	
	private static int search(char[][] str, int i, int j, int matched, String word) {
		int found = 0;
		
		if(i<0 || i>str.length-1 || j<0 || j>str[i].length-1 
				|| str[i][j]!=word.charAt(matched))
			return found;
		
		char temp = str[i][j];
		str[i][j] = ' ';
		matched++;
		
		if(matched==word.length())
			return 1;
		
		found+=search(str, i+1, j, matched, word);
		found+=search(str, i, j+1, matched, word);
		found+=search(str, i-1, j, matched, word);
		found+=search(str, i, j-1, matched, word);
		
		str[i][j] = temp;
		
		return found;
		
	}
	
	private static int searchWord(char[][] str, String word) {
		int found = 0;
		
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length; j++) {
				if(word.charAt(0)==str[i][j])
					found+=search(str, i, j, 0, word);
			}
		}
		
		return found;

	}

	public static void main(String[] args) {
		char[][] str = { {'B','B','A','B','B','M'},  
				{'C','B','M','B','B','A'},  
				{'I','B','A','B','B','G'},  
				{'G','O','Z','B','B','I'},  
				{'A','B','B','B','B','C'},  
				{'M','C','I','G','A','M' }};
		
		char[][] board = {"GEEKSFORGEEKS".toCharArray(),
            "GEEKSQUIZGEEK".toCharArray(),
            "IDEQAPRACTICE".toCharArray()};
		
		String word = "MAGIC";
		
		System.out.println(searchWord(str, word));
		System.out.println(searchWord(board, "GEEK"));

	}

}

