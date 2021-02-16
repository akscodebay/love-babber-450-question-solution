package main;

public class SearchElementInMatrix {
	
	private static boolean searchMatrix(int[][] matrix, int target) {
		int i;
		for(i=0;i<matrix.length;i++) {
			int c = matrix[i].length-1;
			if(matrix[i][c] == target) {
				return true;
			}
			if(matrix[i][c] > target) {
				break;
			}
		}
		if(i == matrix.length){
            return false;
        }
		int low = 0;
		int high = matrix[i].length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(matrix[i][mid] == target) {
				return true;
			}
			else if(matrix[i][mid] > target) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		System.out.println(searchMatrix(matrix, 10));
	}

}
