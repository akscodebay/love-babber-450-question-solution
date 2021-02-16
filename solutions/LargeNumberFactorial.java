package main;

import java.util.ArrayList;
import java.util.Scanner;

public class LargeNumberFactorial {
	
	private static String factorial(int x, ArrayList<Integer> arr){
		for(int i = 2; i<=x; i++) {
			multiply(i, arr, arr.size());
		}
		String factorial = "";
		for(int i:arr) {
			factorial = i+factorial;
		}
		return factorial;
		
	}
	
	private static void multiply(int num, ArrayList<Integer> arr, int size) {
		int carry = 0;
		for(int i = 0; i< size; i++) {
			int product = (arr.get(i)*num) + carry;
			arr.remove(i);
			arr.add(i, product % 10);
			carry = product / 10;
		}
		
		while(carry != 0) {
			arr.add(carry % 10);
			carry = carry / 10;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] input = new int[t];
		for(int i=0;i<t;i++) {
			input[i] = sc.nextInt();
		}
		
		ArrayList<Integer> arr;
		
		for(int i: input) {
			arr = new ArrayList<>();
			arr.add(1);
			System.out.println(factorial(i, arr));
		}
		sc.close();
	}
}
