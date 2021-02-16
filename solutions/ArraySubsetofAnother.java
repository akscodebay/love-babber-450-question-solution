package main;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ArraySubsetofAnother {
	
	private static void checkSubset(int m, int n, int arr1[], int arr2[]) {
		Set<Integer> set = new HashSet<>();
		for(int i: arr1) {
			if(!set.contains(i)) {
				set.add(i);
			}
		}
		for(int i: arr2) {
			if(set.contains(i)) {
				n--;
			}
		}
		if(n == 0) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] mn = new int[t][2];
		int[][] arr1  = new int[t][];
		int[][] arr2  = new int[t][];
		for(int i=0;i < t; i++) {
			mn[i][0] = sc.nextInt();
			mn[i][1] = sc.nextInt();
			arr1[i] = new int[mn[i][0]];
			arr2[i] = new int[mn[i][1]];
			for(int j=0;j<mn[i][0];j++) {
				arr1[i][j] = sc.nextInt();
			}
			for(int j=0;j<mn[i][1];j++) {
				arr2[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<t;i++) {
			checkSubset(mn[i][0], mn[i][1], arr1[i], arr2[i]);
		}
		
		sc.close();
	}

}
