package main;

public class LongestPrefixSuffix_KMP {
	
	private static int lps(char[] pattern) {
		int[] lps = new int[pattern.length];
		
		int j = 0;
		
		for(int i=1;i<pattern.length;) {
			if(pattern[i]==pattern[j]) {
				lps[i] = j+1;
				j++;
				i++;
			}
			else {
				if(j!=0) {
					j = lps[j-1];
				}
				else {
					lps[i] = 0;
					i++;
				}
			}
		}
		
		return lps[pattern.length-1];
	}

	public static void main(String[] args) {
		String s = "abab";
		System.out.println(lps(s.toCharArray()));
	}

}
