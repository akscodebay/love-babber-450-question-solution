package main;

public class GreaterSumSubArray {
	public static long sb(long a[], long n, long x) {
	        
	        long sum = 0L;
	        int l = 0;
	        int r = 0;
	        int minLen = (int) (n+1);
	        
	        while(l<=r && r<n){
	        	if(sum <= x){
	                sum+=a[r++];
	            }
	            else if(sum > x){
	                if(minLen > r-l)
	                {
	                	minLen = r-l;
	                }
	                sum-=a[l++];
	            }
	        }
	        while(sum > x) {
	        	if(minLen > r-l)
                {
                	minLen = r-l;
                }
                sum-=a[l++];
	        }
	        
	        return minLen;
	        
	    }

	public static void main(String[] args) {
		long[] arr = {6,3,4,5,4,3,7,9};
		System.out.println(sb(arr, 8, 16));
	}

}
