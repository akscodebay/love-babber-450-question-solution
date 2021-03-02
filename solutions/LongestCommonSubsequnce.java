package main;

public class LongestCommonSubsequnce {
	
	static int lcs(int p, int q, String s1, String s2){
        int[][] dp = new int[p+1][q+1];
        
        for (int i = 1; i < p+1; i++) {
			for (int j = 1; j < q+1; j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
        
        return dp[p][q];
    }

	public static void main(String[] args) {
		String s1 = "ABCDGH";
		String s2 = "AEDFHR";
		
		System.out.println(lcs(s1.length(), s2.length(), s1, s2));
	}

}
