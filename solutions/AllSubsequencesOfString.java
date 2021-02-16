package main;

public class AllSubsequencesOfString {
	
	private static void subsequences(String s, String out) {
		if(s.length()==0) {
			System.out.println(out);
		}
		else {
			subsequences(s.substring(1), out+s.charAt(0));
			subsequences(s.substring(1), out);
		}
	}

	public static void main(String[] args) {
		subsequences("abc", "");
	}

}
