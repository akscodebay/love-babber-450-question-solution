package main;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsToDecimal {
	
	static public int romanToDecimal(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int sum = 0;
        for(int i=0;i<str.length();i++) {
        	if(i<str.length()-1 && (map.get(str.charAt(i+1)) > map.get(str.charAt(i)))){
                sum-=map.get(str.charAt(i));
            }
        	else
        		sum+=map.get(str.charAt(i));
        }
        
        return sum;
    }

	public static void main(String[] args) {
		System.out.println(romanToDecimal("CMXVI"));

	}

}
