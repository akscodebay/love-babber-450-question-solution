package main;

import java.util.Arrays;
import java.util.Scanner;

public class WordWrapOrTextJustification {
	
	static int printSolution (int p[], int n, int arrayLen) 
	{ 
		int k; 
		if (p[n] == 1) 
		k = 1; 
		else
		k = printSolution (p, p[n]-1, arrayLen) + 1;
		if(arrayLen == n)
			System.out.print(p[n] + " " + n);
		else
			System.out.print(p[n] + " " + n + " "); 
		return k; 
	} 
	
	private static void justify(int[] words, int k) {
		int[][] cost = new int[words.length+1][words.length+1];
		
		for(int i=1;i<=words.length;i++) {
			cost[i][i] = k-words[i-1];
			for(int j=i+1;j<=words.length;j++) {
				cost[i][j] = cost[i][j-1]-words[j-1]-1;
			}
		}
		
		for(int i=1;i<=words.length;i++) {
			for(int j=i;j<=words.length;j++) {
				if(cost[i][j]<0) {
					cost[i][j] = Integer.MAX_VALUE;
				}
				else if(j==words.length && cost[i][j]>=0)
					cost[i][j] = 0;
				else
					cost[i][j] = cost[i][j]*cost[i][j];
			}
		}
		
		int[] minCost = new int[words.length+1];
		int[] result = new int[words.length+1];
		
		minCost[0] = 0;
		
		for(int j=1;j<=words.length;j++) {
			minCost[j] = Integer.MAX_VALUE;
			for(int i=1;i<=j;i++) {
				if (minCost[i-1] != Integer.MAX_VALUE 
						&& cost[i][j] != Integer.MAX_VALUE
						&& (minCost[i-1] + cost[i][j] < minCost[j])) 
	          		{ 
	                    minCost[j] = minCost[i-1] + cost[i][j]; 
	                    result[j] = i; 
	                } 
			}
		}
		printSolution(result, words.length, words.length);
		System.out.println();
		
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
			System.out.println(Arrays.toString(wordSize[i]));
			justify(wordSize[i], width[i]);
		}
		sc.close();

	}

}
