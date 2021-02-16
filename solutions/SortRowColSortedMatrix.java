package main;

import java.util.Arrays;

public class SortRowColSortedMatrix {
	
	private static int[][] sortedMatrix(int N, int Mat[][]) {
		int[] a = new int[N*N];
		int k = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				a[k++] = Mat[i][j];
			}
		}
		
		Arrays.sort(a);
		k=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				Mat[i][j] = a[k++];
			}
		}
		
		return Mat;
    }

	public static void main(String[] args) {
		int[][] a = {{10,20,30,40},
		            {15,25,35,45}, 
		        	{27,29,37,48}, 
		            {32,33,39,50}};
		a = sortedMatrix(4, a);
		for(int[] i:a)
			System.out.println(Arrays.toString(i));
	}

}
