package main;

public class CountAndSay {
	
	public static String countAndSay(int n) {
		if(n==1){
	         return "1";
	     }
		
        String s = countAndSay(n-1);
        char prevDigit = s.charAt(0);
        int digitCnt = 1;
        String str = "";
        
        for(int i=1;i<s.length();i++) {
        	if(prevDigit!=s.charAt(i)) {
        		str = str+digitCnt+prevDigit;
        		prevDigit = s.charAt(i);
        		digitCnt=1;
        	}
        	else
        		digitCnt++;
        }
        str= str+digitCnt+prevDigit;
        return str;
	        
	    }

	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}

}
