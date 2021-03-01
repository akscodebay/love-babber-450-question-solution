package main;

public class BoyerMooreBadCharacter {
	
	static int[] patternChar = new int[256];
	
	private static void patternSearch(char[] text, char[] pattern) {
		for(int i=0;i<256;i++) {
			patternChar[i] = -1;
		}
		
		for(int i=0;i<pattern.length;i++) {
			patternChar[pattern[i]] = i;
		}
		
		int i=0;
		int n = text.length;
		int m = pattern.length;
		
		while(i<=(n-m)) {
			int j = m-1;
			
			while(j>=0 && pattern[j]==text[i+j])
				j--;
			
			if(j<0) {
				System.out.println("Pattern found at: "+i);
				i+=(i+m)<n?m-patternChar[text[i+m]]:1;
			}
			else {
				i+=Math.max(1, j-patternChar[text[i+j]]);
			}
		}
	}

	public static void main(String[] args) {
		char[] text = "CODEABAAABCDABC".toCharArray();
		char[] pattern = "ABC".toCharArray();
		patternSearch(text, pattern);
	}

}
