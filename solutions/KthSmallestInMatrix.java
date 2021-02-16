package main;

public class KthSmallestInMatrix {
	
	static class HeapNode{
		int val;
		int r;
		int c;
		HeapNode(int val, int r, int c){
			this.val = val;
			this.r = r;
			this.c = c;
		}
	}
	
	private static void minHeapify(HeapNode[] hn, int i, int n) {
		int l = (2*i)+1;
		int r = (2*i)+2;
		int min = i;
		
		if(l < n && hn[min].val > hn[l].val) {
			min = l;
		}
		
		if(r < n && hn[min].val > hn[r].val) {
			min = r;
		}
		
		if(min!=i) {
			HeapNode temp = hn[i];
			hn[i] = hn[min];
			hn[min] = temp;
			minHeapify(hn,min,n);
		}
	}
	
	private static int kthSmallest(int[][]mat,int n,int k)
	{
		
		HeapNode[] hn = new HeapNode[n];
		for(int i=0;i<n;i++) {
			hn[i] = new HeapNode(mat[0][i], 0, i);
		}
		
		HeapNode firstNode = new HeapNode(0, 0, 0);
		
		for(int i=1;i<=k;i++) {
			firstNode = hn[0];
			int nextVal = firstNode.r<n-1?mat[firstNode.r+1][firstNode.c]:Integer.MAX_VALUE;
			hn[0] = new HeapNode(nextVal, firstNode.r+1, firstNode.c);
			minHeapify(hn, 0, n);
		}
		
		return firstNode.val;
	    
    }

	public static void main(String[] args) {
		int[][] mat = {{16, 28, 60, 64},
                {22, 41, 63, 91},
                {27, 50, 87, 93},
                {36, 78, 87, 94 }};
		System.out.println(kthSmallest(mat, mat.length, 3));
	}

}
