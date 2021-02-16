package main;

import java.util.Scanner;

public class LongestPalindromeSubstring {
	
	private static void longestPalindromeSubstring(String str, int n) {
		int left = 0;
		int right = 0;
		
		for(int i=0;i<n;i++) {
			int l = i-1;
			int r = i+1;
			while(l>-1 && r < n) {
				if(str.charAt(l)!=str.charAt(r)) {
					break;
				}
				l--;
				r++;
			}
			if(right-left-1 < r-l-1) {
				right = r;
				left = l;
			}
			l = i;
			r = i+1;
			while(l>-1 && r < n) {
				if(str.charAt(l)!=str.charAt(r)) {
					break;
				}
				l--;
				r++;
			}
			if(right-left-1 < r-l-1) {
				right = r;
				left = l;
			}
		}
		System.out.println(str.substring(left+1, right));
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String[] s = new String[t];
		
		for(int i=0;i<t;i++)
		{
			s[i] = sc.next();
		}
		for(int i=0;i<t;i++) {
			longestPalindromeSubstring(s[i], s[i].length());
		}
		sc.close();
	}

}
