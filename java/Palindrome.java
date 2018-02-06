package com.antengine.armchair.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Palindrome {
	public static boolean isPalindrome(String str) {
		str = str.toLowerCase().replaceAll("[^a-z|^0-9]+", "");
		System.out.printf("str = %s\n", str);
		int mid = str.length() / 2;
		for(int i = 0; i < mid; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
		}
		return true;
	}

	public static int getDomDeep(String str) {
		int deep = 0;
		int max = 0;

		Pattern pattern = Pattern.compile("<[^>]+>");
		Matcher matcher = pattern.matcher(str);
		//String [] strarr = str.(/<[^>]+>/g);
		int i = 0;
		while (matcher.find()) {
			String sub = matcher.group(i);
			System.out.printf("s = %s\n", sub);
			if ("<ul>".equals(sub) || "<ol>".equals(sub)) {
				deep++;
				if(deep > max) max = deep;
			}
			else if ("</ul>".equals(sub) || "</ol>".equals(sub)) {
				deep--;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		String str = "123Red rum, sir, is murder321";
		System.out.printf("isPalindrome: %b\n", isPalindrome(str));
		String domstr = "<ul><li>Item:<ol><li>Point:<div><ul><li>elem1</li></ul></div></li></ol></li><li>elem2</li></ul><ul><li>simple list1</li></ul><ul></ul>";
		System.out.printf("getDomDeep: %d\n", getDomDeep(domstr));
	}
}
