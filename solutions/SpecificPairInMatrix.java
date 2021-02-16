package main;

/* mat[c][d] - mat[a][b] should be maximum where c>a, d>b. */

public class SpecificPairInMatrix {
	
	private static int findMaxValue(int[][] mat, int n) {
		int maxValue = mat[n-1][n-1];
		int[][] maxArr = new int[n][n];
		
		maxArr[n-1][n-1] = mat[n-1][n-1]; 
		
		for(int j=n-2; j>=0; j--) {
			if(mat[n-1][j] > maxValue)
				maxValue = mat[n-1][j];
			maxArr[n-1][j] = maxValue; 
		}
		
		maxValue = mat[n-1][n-1];
		
		for(int i=n-2; i>=0; i--) {
			if(mat[i][n-1] > maxValue)
				maxValue = mat[i][n-1];
			maxArr[i][n-1] = maxValue; 
		}
		
		maxValue = Integer.MIN_VALUE;
		
		for(int i=n-2;i>=0;i--) {
			for(int j=n-2;j>=0;j--) {
				if(mat[i+1][i+1] - mat[i][j] > maxValue)
					maxValue = mat[i+1][j+1] - mat[i][j];
				mat[i][j] = Math.max(mat[i][j], Math.max(mat[i][j+1],mat[i+1][j]));
			}
		}
		
		return maxValue;
	}

	public static void main(String[] args) {
		int[][] mat = { 
                { 1, 2, -1, -4, -20 }, 
                { -8, -3, 4, 2, 1 }, 
                { 3, 8, 6, 1, 3 }, 
                { -4, -1, 1, 7, -6 }, 
                { 0, -4, 10, -5, 1 } 
             };
		
		System.out.println(findMaxValue(mat, 5));
		
	}

}
