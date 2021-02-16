package main;

import java.util.ArrayList;
import java.util.List;

public class NextPermutationNumber {
	
	private static void swap(int[] arr,int i,int j) {
		int temp = arr[j];
    	arr[j] = arr[i];
    	arr[i] = temp;
	}
	
	private static List<Integer> nextPermutation(int N, int arr[]){
        List<Integer> ar = new ArrayList<Integer>();
        
        int i = arr.length-2;
        
        while(i>=0 && arr[i+1]<=arr[i])
        	i--;
        
        if(i>=0) {
        	int j=arr.length-1;
        	while(j>=0 && arr[j]<=arr[i]) {
        		j--;
        	}
        	swap(arr, i, j);
        }
        i=i+1;
    	int j=arr.length-1;
    	while(i<j) {
    		swap(arr, i, j);
    		i++;
    		j--;
    	}
        
        for(int x: arr)
        	ar.add(x);
        
        return ar;
    }

	public static void main(String[] args) {
		int[] arr = {1,2,3,2,2,2};
		List<Integer> list = nextPermutation(6, arr);
		for(int i: list) {
			System.out.print(i+" ");
		}
	}

}
