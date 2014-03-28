package leetcode_java;

import java.util.Hashtable;

public class RomanToInt {
	public static int romanToInt(String s) {
		int result = 0, len = s.length();
		Hashtable<Character, Integer> rn = new Hashtable<>(7);
		rn.put('I', 1);
		rn.put('V', 5);
		rn.put('X', 10);
		rn.put('L', 50);
		rn.put('C', 100);
		rn.put('D', 500);
		rn.put('M', 1000);
		int last = 1, tmp;
		for (int i = 0; i < len; i++) {
			tmp = rn.get(s.charAt(i));
			if (tmp <= last || i == 0) {
				result += tmp;
			} else {
				result += tmp - last - last;
			}
			last = tmp;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("MCDXXXVII"));
	}
}
