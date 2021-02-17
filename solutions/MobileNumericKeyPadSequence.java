package main;

public class MobileNumericKeyPadSequence {
	
	
	private static String KeyPadNumericValue(String[] keyPresses, String keyPressed) {
		String output = "";
		
		for (int i = 0; i < keyPressed.length(); i++) {
			if(keyPressed.charAt(i)==' ') {
				output +="0";
			}
			else
				output+=keyPresses[keyPressed.charAt(i)-'A'];
		}
		
		return output;
	}

	public static void main(String[] args) {
		
		String[] keyPresses = {
				"2","22","222",
				"3","33","333",
				"4","44","444",
				"5","55","555",
				"6","66","666",
				"7","77","777","7777",
				"8","88","888",
				"9","99","999","9999"
		};
		String keyPressed = "AKS ";
		System.out.println(KeyPadNumericValue(keyPresses, keyPressed));
	}

}
