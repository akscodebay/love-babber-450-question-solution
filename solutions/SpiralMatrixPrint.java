package main;

import java.util.ArrayList;

public class SpiralMatrixPrint {
	
	static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        int r_start = 0;
        int c_start = 0;
        int i;
        
        while(r_start<r && c_start<c) {
        	for(i=c_start;i<c;i++) {
        		al.add(matrix[r_start][i]);
        	}
        	r_start++;
        	
        	for(i=r_start;i<r;i++) {
        		al.add(matrix[i][c-1]);
        	}
        	c--;
        	
        	if(r_start<r) {
        		for(i=c-1;i>=c_start;i--) {
        			al.add(matrix[r-1][i]);
        		}
        		r--;
        	}
        	if(c_start<c) {
        		for(i=r-1;i>=r_start;i--) {
        			al.add(matrix[i][c_start]);
        		}
        		c_start++;
        	}
        }
        
        return al;
        
    }

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 } };
		
		ArrayList<Integer> al = spirallyTraverse(matrix, 3, 6);
		System.out.println(al.toString());
		}
	}
