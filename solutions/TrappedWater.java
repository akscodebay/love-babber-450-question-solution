package main;

public class TrappedWater {
	
	static int trappingWater(int arr[], int n) { 
        int l=0;
        int r = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int waterTrapped = 0;
        
        while(l<=r) {
        	if(arr[l] < arr[r]) {
        		if(arr[l]>leftMax) {
            		leftMax = arr[l];
            	}
        		else {
        			waterTrapped+=leftMax - arr[l];
        		}
        		l++;
        	}
        	else {
        		if(arr[r]>rightMax) {
        			rightMax = arr[r];
        		}
        		else {
        			waterTrapped+=rightMax - arr[r];
        		}
        		r--;
        	}
        }
        
        return waterTrapped;
        
    } 

	public static void main(String[] args) {
		int[] arr = {8,8,2,4,5,5,1};
		
		System.out.println(trappingWater(arr, arr.length));

	}

}
