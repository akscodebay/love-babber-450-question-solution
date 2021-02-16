package main;

public class TwoNotEqualArrayMedian {
	
	private static double getMedian(int[] a, int[] b) {
		if(a.length > b.length) {
			return getMedian(b, a);
		}
		
		int len1 = a.length;
		int len2 = b.length;
		
		int low = 0;
		int high = len1;
		
		while(low<=high) {
			int partitionX = (low+high)/2;
			int partitionY = (len1+len2+1)/2 - partitionX;
			
			int maxLeftX = (partitionX==0) ? Integer.MIN_VALUE:a[partitionX-1];
			int minRightX = (partitionX==len1) ? Integer.MAX_VALUE:a[partitionX];
			
			int maxLeftY = (partitionY==0) ? Integer.MIN_VALUE:b[partitionY-1];
			int minRightY = (partitionY==len2) ? Integer.MAX_VALUE:b[partitionY];
			
			if(maxLeftX<=minRightY && maxLeftY<=minRightX) {
				if((len1+len2)%2==0) {
					return (Math.max(maxLeftX, maxLeftY)+Math.min(minRightX, minRightY))/2;
				}
				else {
					return Math.max(maxLeftX, maxLeftY);
				}
			}
			else if(maxLeftX > minRightY) {
				high = partitionX - 1;
			}
			else
				low = partitionX + 1;
		}
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,8};
		int[] b = {4,6,8,10};
		System.out.println(getMedian(a, b));
	}

}
