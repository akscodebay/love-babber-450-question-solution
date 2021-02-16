package main;

public class StringSplitEqual01 {
	
	private static int maxSplitCount(String s, int n) {
		int count=0;
		int count0 = 0;
		int count1 = 0;
		
		for(int i=0;i<n;i++) {
			if(s.charAt(i)=='1') {
				count1++;
			}
			else
				count0++;
			if(count0==count1)
				count++;
		}
		if(count0!=count1)
			return -1;
		return count;
	}

	public static void main(String[] args) {
		String s = "01011010";
		System.out.println(maxSplitCount(s, s.length()));
	}

}
