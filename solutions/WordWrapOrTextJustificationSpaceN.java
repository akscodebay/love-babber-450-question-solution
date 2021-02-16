package main;

import java.util.Arrays;
import java.util.Scanner;

public class WordWrapOrTextJustificationSpaceN {
	
	private static void justify(int[] words, int k) {
		int cost;
		int currLen;
		int n = words.length;
		int[] mincost = new int[n];
		int[] result = new int[n];
		
		mincost[n-1] = 0;
		result[n-1] = n-1;
		
		for(int i=n-2;i>=0;i--) {
			currLen = -1;
			mincost[i] = Integer.MAX_VALUE;
			for(int j=i;j<n;j++) {
				currLen+=(words[i]+1);
				
				if(currLen>k)
					break;
				
				if(j==n-1)
					cost = 0;
				else 
					cost = (k-currLen)*(k-currLen)+mincost[j+1];
				
				if(cost<mincost[i]) {
					mincost[i] = cost;
					result[i] = j;
				}
			}
		}
		
		System.out.println(Arrays.toString(result));
		
		int i=0;
		while(i<n) {
			System.out.print((i+1)+" "+(result[i]+1)+" ");
			i = result[i]+1;
		}
	}

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int t = sc.nextInt();
		int[] sizes = new int[t];
		int[] width = new int[t];
		int[][] wordSize = new int[t][];
		for(int i=0;i<t;i++) {
			sizes[i] = sc.nextInt();
			wordSize[i] = new int[sizes[i]];
			for(int j=0;j<sizes[i];j++) {
				wordSize[i][j] = sc.nextInt();
			}
			width[i] = sc.nextInt();
		}
		
		
		for(int i=0;i<t;i++) {
			justify(wordSize[i], width[i]);
		}
		sc.close();
	}

}
