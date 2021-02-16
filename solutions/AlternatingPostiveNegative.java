package main;

import java.util.Arrays;
import java.util.Scanner;

public class AlternatingPostiveNegative {
	
	public void rightRotate(int[] arr, int outPlace, int cur) {
		int temp = arr[cur];
		for(int i=cur; i>outPlace;i--) {
			arr[i] = arr[i-1];
		}
		arr[outPlace] = temp; 
	}
	
	public void alternatingPostiveNegative(int[] arr, int n) {
		int outPlace = -1;
		for(int i=0; i<n; i++) {
			if(outPlace >=0) {
				if(((arr[i] < 0) && (arr[outPlace]>=0)) 
						|| ((arr[i] >= 0) && (arr[outPlace]<0))) {
					rightRotate(arr, outPlace, i);
					if(i - outPlace >=2) {
						outPlace +=2;
					}
					else
						outPlace = -1;
				}
			}
			if(outPlace == -1) {
				if(((arr[i] < 0) && ((i & 0x01) == 1))
						|| ((arr[i]>=0) && ((i & 0x01) ==0))) {
					outPlace = i;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		new AlternatingPostiveNegative().alternatingPostiveNegative(arr, n);
		System.out.println(Arrays.toString(arr));
		sc.close();
	}

}
