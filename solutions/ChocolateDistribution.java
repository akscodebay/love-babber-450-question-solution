package main;

import java.util.Arrays;
import java.util.Scanner;

public class ChocolateDistribution {
	
	private static int minDiff(int n, int[] arr, int students) {
		int difference = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for(int i=0;i<=n-students;i++) {
			if(arr[i+students-1] - arr[i] < difference)
				difference = arr[i+students-1] - arr[i];
		}
		return difference;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] arr_sizes = new int[t];
		int[] students = new int[t];
		int[][] arr = new int[t][];
		for(int i=0;i<t;i++) {
			arr_sizes[i] = sc.nextInt();
			arr[i] = new int[arr_sizes[i]];
			for(int j=0;j < arr_sizes[i];j++) {
				arr[i][j] = sc.nextInt();
			}
			students[i] = sc.nextInt();
		}
		
		for(int i=0;i<t;i++) {
			System.out.println(minDiff(arr_sizes[i], arr[i], students[i]));
		}
		sc.close();

	}

}
