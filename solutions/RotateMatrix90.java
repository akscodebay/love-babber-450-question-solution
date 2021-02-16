package main;

public class RotateMatrix90 {
	
	private static void rotate90ClockWise(int[][] mat, int n) {
		for(int i=0;i<n/2;i++) {
			for(int j=i;j<n-i-1;j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[n-j-1][i];
				mat[n-j-1][i] = mat[n-i-1][n-j-1];
				mat[n-i-1][n-j-1] = mat[j][n-i-1];
				mat[j][n-i-1] = temp;
			}
		}
	}
	
	private static void rotate90AntiClockWise(int[][] mat, int n) {
		for(int i=0;i<n/2;i++) {
			for(int j=i;j<n-i-1;j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][n-i-1];
				mat[j][n-i-1] = mat[n-i-1][n-j-1];
				mat[n-i-1][n-j-1] = mat[n-j-1][i];
				mat[n-j-1][i] = temp;
			}
		}

	}
	
	private static void print(int[][] mat, int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int mat[][] = { 
	            { 1, 2, 3, 4 }, 
	            { 5, 6, 7, 8 }, 
	            { 9, 10, 11, 12 }, 
	            { 13, 14, 15, 16 } 
	        };
		rotate90AntiClockWise(mat, mat.length);
		print(mat, mat.length);
		System.out.println();
		rotate90ClockWise(mat, mat.length);
		print(mat, mat.length);
		
	}

}
