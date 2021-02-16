package main;

public class LongestRepeatingSubsequence {
	
	public static int LRS(String str)
    {
		int n = str.length();
        int[][] lcs = new int[n+1][n+1];
        for(int i=1;i<=n;i++)
        	for(int j=1;j<=n;j++) {
        		if(str.charAt(i-1)==str.charAt(j-1) && i!=j) {
        			lcs[i][j] = lcs[i-1][j-1]+1;
        		}
        		else
        			lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
        	}
        
        return lcs[n][n];
    }

	public static void main(String[] args) {
		System.out.println(LRS("jxyrnbvtfc"));
		System.out.println(LRS("axxxy"));
	}

}
