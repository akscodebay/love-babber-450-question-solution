package main;

import java.util.Stack;

public class MatrixMaxAreaWith1s {
	
	private static int getMaxArea(int hist[], int n)  {
        int i=0;
        int maxArea = -1;
        
        Stack<Integer> stack = new Stack<>();
        
        while(i<n) {
        	if(stack.isEmpty() || hist[stack.peek()]<=hist[i])
        		stack.push(i++);
        	else {
        		int top = stack.pop();
        		int area = hist[top]*(stack.isEmpty()?i:i-stack.peek()-1);
        		
        		if(area>maxArea)
        			maxArea = area;
        	}
        }
        while(!stack.isEmpty()) {
        	int top = stack.pop();
    		int area = hist[top]*(stack.isEmpty()?i:i-stack.peek()-1);
    		
    		if(area>maxArea)
    			maxArea = area;
        }
        
        return maxArea;
    }
	
	public static int maxArea(int M[][], int m, int n) {
		
		int result = getMaxArea(M[0], n);
		
		for(int i=1;i<m;i++)
		{
			for(int j=0;j<n;j++)
				if(M[i][j]==1)
					M[i][j]+=M[i-1][j];
			result = Math.max(getMaxArea(M[i], n), result);
		}
			
		
		return result;
        
    }

	public static void main(String[] args) {
		int m[][] = {{0,1,1, 0},
		         {1 ,1 ,1 ,1},
		         {1 ,1, 1, 1},
		         {1 ,1, 0 ,0}};
		
		System.out.println(maxArea(m, 4, 4));		
	}

}
