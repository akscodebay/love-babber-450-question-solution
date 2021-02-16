package main;

import java.util.Stack;

public class HistrogramMaxArea {
	
	private static long getMaxArea(long hist[], long n)  {
        int i=0;
        long maxArea = -1;
        
        Stack<Integer> stack = new Stack<>();
        
        while(i<n) {
        	if(stack.isEmpty() || hist[stack.peek()]<=hist[i])
        		stack.push(i++);
        	else {
        		int top = stack.pop();
        		long area = hist[top]*(stack.isEmpty()?i:i-stack.peek()-1);
        		
        		if(area>maxArea)
        			maxArea = area;
        	}
        }
        while(!stack.isEmpty()) {
        	int top = stack.pop();
    		long area = hist[top]*(stack.isEmpty()?i:i-stack.peek()-1);
    		
    		if(area>maxArea)
    			maxArea = area;
        }
        
        return maxArea;
    }

	public static void main(String[] args) {
		long[] a = {6,2,5,4,5,1,6};
		System.out.println(getMaxArea(a, a.length));
	}

}
