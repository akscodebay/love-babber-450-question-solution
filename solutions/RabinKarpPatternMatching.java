package main;

public class RabinKarpPatternMatching {
	
	private final static int d = 256;
	
	private static void search(String text, String pattern, int q) {
		int M = pattern.length();
		int N = text.length();
		int p = 0;
		int t = 0;
		int h = 1;
		int i;
		int j;
		
		for(i=0;i<M-1;i++) {
			h = (h*d)%q; 
		}
		
		for(i=0;i<M;i++) {
			p = (d*p + pattern.charAt(i))%q;
			t = (d*t + text.charAt(i))%q;
		}
		
		for(i=0;i<=N-M;i++) {
			if(p==t) {
				for(j=0;j<M;j++) {
					if(pattern.charAt(j)!=text.charAt(i+j))
						break;
				}
				if(j==M) {
					System.out.println("pattern found at "+i);
				}
			}
			if(i<N-M) {
				t = (d*(t-text.charAt(i)*h) + text.charAt(i+M))%q;
				if(t<0)
					t = t+q;
			}
		}
	}

	public static void main(String[] args) {
		String text = "world is a wonderful place";
		String pattern = "place";
		int q = 101;
		search(text, pattern, q);
	}

}
