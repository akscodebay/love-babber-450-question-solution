package main;

import java.util.Scanner;

public class BinaryStringAlternating {
	
	private static int numberOfFlips(String str) {
		int flipCount_0 = 0;
		int flipCount_1 = 0;
		
		char expected_0='0';
		char expected_1='1';
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c!=expected_0)
				flipCount_0++;
			if(c!=expected_1)
				flipCount_1++;
			
			expected_0 = expected_0=='0'?'1':'0';
			expected_1 = expected_1=='0'?'1':'0';
		}
		
		
		return flipCount_0<flipCount_1?flipCount_0:flipCount_1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String[] strs = new String[t];
		
		for (int i = 0; i < t; i++) {
			strs[i] = sc.next();
		}
		
		for (String string : strs) {
			System.out.println(numberOfFlips(string));
		}
		
		sc.close();
	}

}
