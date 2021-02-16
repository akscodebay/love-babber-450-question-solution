package main;

//Edit Distance to convert string 1 to string 2 using insert, modify and delete
//operations.

public class MinimumOperationForS1ToS2 {
	
	public static int editDistance(String s, String t)
    {
		int[][] dp = new int[2][s.length()+1];
		
		for(int i=0;i<=s.length();i++) {
			dp[0][i] = i;
		}
		
		for(int i=1;i<=t.length();i++) {
			for(int j=0;j<=s.length();j++) {
				if(j==0)
					dp[i%2][j] = i;
				else if(s.charAt(j-1)==t.charAt(i-1))
					dp[i%2][j] = dp[(i-1)%2][j-1];
				else
					dp[i%2][j] = 1+Math.min(dp[(i-1)%2][j-1], 
							Math.min(dp[(i-1)%2][j], dp[i%2][j-1]));
			}
		}
		
		return dp[t.length()%2][s.length()];
        
    }

	public static void main(String[] args) {
		String s1 = "geek";
		String s2 = "gesek";
		System.out.println(editDistance(s1, s2));
	}

}
