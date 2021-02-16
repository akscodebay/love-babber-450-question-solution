package main;


public class TwoEqualArrayMedian {
	
	private static int getMedian(int[] a, int[] b, int startA, int endA,int startB,
			int endB) {
		
		if(endA-startA ==1) {
			return (Math.max(a[startA], b[startB])+Math.min(a[startA+1], b[startB+1]))/2;
		}
		
		int m1 = median(a, startA,endA-startA+1);
		int m2 = median(b, startB,endB-startB+1);
		
		if(m1==m2)
			return m1;
		else if(m1<m2) {
			return getMedian(a, b, (endA+startA+1)/2, endA, startB, (endB+startB+1)/2);
		}
		else
			return getMedian(a, b, startA, (endA+startA+1)/2, (endB+startB+1)/2, endB);
	}
	
	static int median(int[] x,int start, int n) {
	if(n%2 == 1 ) {
		return x[start+(n/2)];
	}
	else
		return (x[start+(n/2)]+x[start+(n/2)-1])/2;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3,8};
		int[] b = { 4, 6, 8,10};
		
		System.out.println(getMedian(a, b, 0, a.length-1, 0, b.length-1));
		
	}

}
