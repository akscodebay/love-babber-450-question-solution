package main;

import java.util.HashMap;
import java.util.Map;

public class SecondMostRepeatedWord {
	
	private static String secFrequent(String arr[], int N){
		Map<String, Integer> map = new HashMap<>();
		int count = 0;
		String str = "";
		for (String string : arr) {
			if(!map.containsKey(string)) {
				map.put(string, 1);
			}
			else {
				map.put(string, map.get(string)+1);
				if(map.get(string)>count) {
					str = string;
					count = map.get(string);
				}
			}
		}
		map.remove(str);
		str = "";
		count = 0;
		for(Map.Entry<String, Integer> x_map:map.entrySet()) {
			if(count<x_map.getValue()) {
				count = x_map.getValue();
				str = x_map.getKey();
			}
		}
		return str;
    }

	public static void main(String[] args) {
		String[] strs = {"", "", "", "", "aaa", "aaa"};
		String[] strs2 = {"geeks", "for", "geeks", "for", "geeks", "aaa"};
		System.out.println(secFrequent(strs, strs.length));
		System.out.println(secFrequent(strs2, strs2.length));
	}

}
