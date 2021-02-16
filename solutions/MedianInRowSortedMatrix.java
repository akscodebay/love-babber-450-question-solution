package main;

import java.util.Arrays;

public class MedianInRowSortedMatrix {
	private static int median(int matrix[][], int r, int c) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
        for(int i=0;i<r;i++) {
        	if(matrix[i][0]<min)
        		min = matrix[i][0];
        	if(matrix[i][c-1]>max)
        		max = matrix[i][c-1];
        }
        
        int desired = (r*c+1)/2;
        while(min<max) {
        	int place = 0;
        	int mid = min+(max-min)/2;
        	int get = 0;
        	
        	for(int i=0;i<r;i++) {
        		get = Arrays.binarySearch(matrix[i], mid);
        		if(get<0){
        			get = Math.abs(get)-1;
        		}
        		else {
        			while(get<matrix[i].length && matrix[i][get]==mid) {
        				get++;
        			}
        		}
        		place += get;
        	}
        	if(place < desired)
        		min = mid+1;
        	else
        		max = mid;
        }
        return min;
    }

	public static void main(String[] args) {
		int r = 3, c = 3; 
        int m[][]= { {1,3,3}, {5,6,9}, {2,6,9} }; 
          
        System.out.println("Median is " + median(m, r, c));

	}

}
