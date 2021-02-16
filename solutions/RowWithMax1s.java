package main;

public class RowWithMax1s {
	
	private static int rowWithMax1s(int arr[][], int n, int m) {
        int left = m-1;
        int down = 0;
        int desiredRow = -1;
        
        while(left>-1 && down<n) {
        	if(arr[down][left] == 1) {
        		left--;
        		desiredRow = down;
        	}
        	else {
        		down++;
        	}
        }
        return desiredRow;
    }

	public static void main(String[] args) {
		int[][] a = {{0, 1, 1, 1},
		           {0, 0, 1, 1},
		           {1, 1, 1, 1},
		           {0, 0, 0, 0}};
		
		System.out.println(rowWithMax1s(a, 4, 4));
	}

}
