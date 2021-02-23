package main;

public class CountPalindromeSubsequence {
	
	public static int countPS(String str){
        int n = str.length();
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
        
        for (int L = 2; L <= n; L++) {
			for (int i = 0; i <= n-L; i++) {
				int k = L + i -1;
				if (str.charAt(i)==str.charAt(k)) {
					dp[i][k] = dp[i][k-1] + dp[i+1][k] + 1;
				} else {
					dp[i][k] = dp[i][k-1] + dp[i+1][k] - dp[i+1][k-1];
				}
			}
		}
        
        return dp[0][n-1];
    }

	public static void main(String[] args) {
		String str = "abcd";
		System.out.println(countPS(str));
	}

}
