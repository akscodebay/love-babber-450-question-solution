package main;

public class LongestCommonPrefix {
	
	public static String lcp(String[] strs) {
		
		if(strs.length==0 || strs==null) {
			return "";
		}
		
		int count = strs[0].length();
		int j=0;
		
		for (int i = 1; i < strs.length; i++) {
			while(j<count && j<strs[i].length() && strs[i].charAt(j)==strs[0].charAt(j)) {
				j++;
			}
			count = j;
			j=0;
		}
		
		
		return strs[0].substring(0, count);
		
	}

	public static void main(String[] args) {
		
		String[] strs = {"flower","flow","flight"};
		System.out.println(lcp(strs));
		String[] strs2 = {"","ac"};
		System.out.println(lcp(strs2));
	}

}
