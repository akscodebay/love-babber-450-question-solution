package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SubArray0Sum {
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);

	    int n = scan.nextInt() ;
	    int arr[] = new int[n];
	    for(int i = 0; i<n;i++)
	    {
	        arr[i] = scan.nextInt();
	    }
	    System.out.println(findsum(arr,n)==true?"Yes":"No");
	    scan.close();
	}
	
	static boolean findsum(int arr[],int n)
	{
	 Map<Integer, Integer> map = new HashMap<>();
	 int sum = 0;
	 for(int i=0; i < n; i++){
		 if(arr[i] == 0) {
			 return true;
		 }
		 sum+=arr[i];
		 if(sum == 0){
		     return true;
		 }
	     if(!map.containsKey(sum)) {
	    	 map.put(sum, 0);
	     }
	     else {
	    	 return true;
	     }
	 }
	 return false;
	}
}
