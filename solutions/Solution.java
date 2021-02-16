package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	int getPairsCount(int[] arr, int n, int k) {
		int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: arr){
            if(!map.containsKey(a)){
                map.put(a, 1);
            }
            else {
            	map.put(a, map.get(a)+1);
            }
        }
        
        for(int a: arr) {
        	if(map.containsKey(a) && map.containsKey(k-a)){
        		map.put(a, map.get(a)-1);
        		count+= map.get(k-a);
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println(new Solution().getPairsCount(arr, n, k));
		sc.close();
	}

}
