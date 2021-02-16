package main;

public class MinSwapsKTogether {
	
	public static int minSwap (int arr[], int n, int k) {
        int lessCount = 0;
        for(int i=0;i<n;i++)
        	if(arr[i]<=k)
        		lessCount++;
        
        int moreCount = 0;
        for(int i=0;i<lessCount;i++) {
        	if(arr[i]>k) {
        		moreCount++;
        	}
        }
        
        int minSwaps = moreCount;
        
        for(int i=0, j=lessCount; j<n; j++,i++) {
        	if(arr[i]>k) {
        		moreCount--;
        	}
        	if(arr[j]>k) {
        		moreCount++;
        	}
        	minSwaps = Math.min(minSwaps, moreCount);
        }
        return minSwaps;
    }

	public static void main(String[] args) {
		int[] arr = {2, 1, 5, 6, 3};
		System.out.println(minSwap(arr, arr.length, 3));
	}

}
