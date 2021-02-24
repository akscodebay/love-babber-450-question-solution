package main;

import java.util.Scanner;

public class WordInA2dCharacterArray8Directions {
	
	static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };
	
	private static boolean search(char[][] str, int row, int col, String word) {
		
		for (int dir = 0; dir < 8; dir++) {
			int k;
			int rd = row+x[dir];
			int cd = col+y[dir];
			
			for (k = 1; k < word.length(); k++) {
				if(rd<0 || rd>=str.length || cd<0 || cd>=str[0].length 
						||word.charAt(k)!= str[rd][cd])
					break;
				rd+=x[dir];
				cd+=y[dir];
			}
			
			if(k==word.length())
				return true;
		}
		
		return false;
	}
	
	private static void searchWord(char[][] str, String word) {
		
		int flag = 1;
		
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length; j++) {
				if(word.charAt(0)==str[i][j] && search(str, i, j, word))
				{
					System.out.print(i+" "+j+", ");
					flag = 0;
				}
					
			}
		}
		
		if(flag == 1)
			System.out.print(-1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] size = new int[t][2];
		char[][][] board = new char[t][][];
		String[] word = new String[t];
		for (int i = 0; i < t; i++) {
			size[i][0] = sc.nextInt();
			size[i][1] = sc.nextInt();
			board[i] = new char[size[i][0]][size[i][1]];
			for (int j = 0; j < size[i][0]; j++) {
				for (int k = 0; k < size[i][1]; k++) {
					board[i][j][k] = sc.next().charAt(0);
				}
			}
			word[i] = sc.next();
		}
		
		for (int i = 0; i < t; i++) {
			searchWord(board[i], word[i]);
			System.out.println();
		}
		
		sc.close();
	}

}
