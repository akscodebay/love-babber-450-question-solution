package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PermutationOfString {
	
	private static void permute(String str,ArrayList<String> al, String out) {
		if(str.length()==0) {
			if(!al.contains(out))
				al.add(out);
			return;
		}
		for(int i=0;i<str.length();i++) {
			String s = str.substring(1);
			permute(s, al, out+str.charAt(0));
			str = s+str.charAt(0);
			
		}
	}
	
	private static void print(ArrayList<String> al) {
		for(String i:al) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		String[] str = new String[t];
		
		for(int i=0;i<t;i++) {
			str[i] = sc.next();
		}
		
		ArrayList<String> al;
		
		for(String i: str) {
			al = new ArrayList<String>();
			permute(i, al, "");
			Collections.sort(al);
			print(al);
		}
		
		sc.close();
	}

}
