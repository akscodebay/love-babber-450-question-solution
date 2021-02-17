package main;

import java.util.Scanner;
import java.util.Stack;

public class MinimumBracketReversals {
	
	private static int minReversals(String s){
		if(s.length()%2!=0) {
			return -1;
		}
		Stack<Character> st = new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='}' && !st.isEmpty()) {
				if(st.peek()=='{') {
					st.pop();
				}
				else {
					st.push(s.charAt(i));
				}
			}
			else
				st.push(s.charAt(i));
		}
		int redlen = st.size();
		int n=0;
		while(!st.empty() && st.peek()=='{') {
			st.pop();
			n++;
		}
		
		return redlen/2 + n%2;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String[] str = new String[t];
		for(int i=0;i<t;i++) {
			str[i] = sc.next();
		}
		
		for(int i=0;i<t;i++) {
			System.out.println(minReversals(str[i]));
		}
		
		sc.close();
	}

}
