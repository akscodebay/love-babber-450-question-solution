package main;

import java.util.HashSet;
import java.util.Set;

public class WordInDictionary {
	
	private static boolean checkWord(String word) {
		boolean[] dp = new boolean[word.length()+1];
		dp[0] = true;
		
		for (int i = 1; i <= word.length(); i++) {
			for (int j = i-1; j >= 0; j--) {
				if(dp[j] && set.contains(word.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[word.length()];
	}
	
	private static Set<String> set = new HashSet<String>(); 
	
	private static int wordBreak(String word, String[] dict) {
		
		for(String i: dict)
			set.add(i);
		
		return checkWord(word)?1:0;
	}

	public static void main(String[] args) {
		
		String[] dict = { "i", "like", "sam", "sung", "samsung", "mobile",
				"ice","cream", "icecream", "man", "go", "mango" };
		
		String word = "ilikesamsung";
		
		System.out.println(wordBreak(word, dict));
	}

}
