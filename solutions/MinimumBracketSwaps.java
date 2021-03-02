package main;

import java.util.Scanner;

public class MinimumBracketSwaps {
	
	private static int minSwaps(String str) {
		if(str.length()%2!=0) {
			return -1;
		}
		int rightCount = 0;
		int leftCount = 0;
		int imbalances = 0;
		int swaps = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='[') {
				leftCount++;
				
				if(imbalances>0) {
					swaps+=imbalances;
					imbalances--;
				}
			}
			else {
				rightCount++;
				imbalances = rightCount-leftCount;
			}
		}
		
		return swaps;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] sizes = new int[t];
		String[] strs = new String[t];
		
		for (int i = 0; i < t; i++) {
			sizes[i] = sc.nextInt();
			strs[i] = sc.next();
		}
		
		for (int i = 0; i < t; i++) {
			System.out.println(minSwaps(strs[i]));
		}
		
		sc.close();
	}

}
