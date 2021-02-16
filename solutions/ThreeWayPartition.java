package main;

import java.util.Arrays;

public class ThreeWayPartition {
	public static void threeWayPartition(int array[], int a, int b)
    {
        int l = 0;
        int r = array.length-1;
        
        for(int i=0;i<=r;){
            if(array[i] < a){
                int temp = array[l];
                array[l] = array[i];
                array[i] = temp;
                l++;
                i++;
            }
            else if(array[i] > b){
                int temp = array[r];
                array[r] = array[i];
                array[i] = temp;
                r--;
            }
            else{
                i++;
            }
        }
    }

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 3, 4};
		threeWayPartition(arr, 1, 2);
		System.out.println(Arrays.toString(arr));
	}

}
