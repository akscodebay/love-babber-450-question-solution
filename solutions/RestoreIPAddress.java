package main;

import java.util.ArrayList;

public class RestoreIPAddress {
	
	static ArrayList<String> al = new ArrayList<String>();
	
	public static void generateAllIPs(String part, String str, int n, String temp, int dotCount) {
		
		if(part.length()>1 && part.charAt(0)=='0')
			return;
		
		if(Integer.parseInt(part)<0 || Integer.parseInt(part)>255)
			return;
		
		if(dotCount<3) {
			temp+=part+".";
			dotCount++;
		}
		else {
			temp+=part;
			if(temp.length()-3==n) {
				al.add(temp);
			}
			return;
		}
		
		if(str.length()>0)
			generateAllIPs(str.substring(0,1), str.substring(1), n, temp, dotCount);
		if(str.length()>1)
			generateAllIPs(str.substring(0,2), str.substring(2), n, temp, dotCount);
		if(str.length()>2)
			generateAllIPs(str.substring(0,3), str.substring(3), n, temp, dotCount);
	}
	
	public static void stringValidate(String str){
		
		if(str.length()>3 && str.length()<13) {
			generateAllIPs(str.substring(0,1), str.substring(1), str.length(), "", 0);
			generateAllIPs(str.substring(0,2), str.substring(2), str.length(), "", 0);
			generateAllIPs(str.substring(0,3), str.substring(3), str.length(), "", 0);
		}
		
	}

	public static void main(String[] args) {
		stringValidate("0000");
		System.out.println(al);
		al.clear();
		stringValidate("25525511135");
		System.out.println(al);
		al.clear();
		stringValidate("25505011535");
		System.out.println(al);
	}

}
