package main;

import java.util.Stack;

public class BalancedParanthesis {
	
	static boolean ispar(String x)
    {
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<x.length();i++) {
        	if(x.charAt(i)=='{' || x.charAt(i)=='(' || x.charAt(i)=='[') {
        		st.push(x.charAt(i));
        	}
        	else {
        		if(st.empty())
        			return false;
        		char pop = st.pop();
        		if(x.charAt(i)=='}' && pop!='{' ) {
        			return false;
        		}
        		else if(x.charAt(i)==']' && pop!='[' ) {
        			return false;
        		}
        		else if(x.charAt(i)==')' && pop!='(' ) {
        			return false;
        		}
        	}
        }
        if(!st.empty())
        	return false;
        return true;
    }

	public static void main(String[] args) {
		System.out.println(ispar("{}[]()"));
	}

}
