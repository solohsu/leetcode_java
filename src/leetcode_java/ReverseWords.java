package leetcode_java;

import java.util.Stack;

public class ReverseWords {
	public static String reverseWords(String s) {
		s = s.trim();
		StringBuilder sb = new StringBuilder();
		Stack<Character> tmp = new Stack<Character>();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == ' ') {
				boolean flag = !tmp.isEmpty();
				while (!tmp.isEmpty()) {
					sb.append(tmp.pop());
				}
				if (flag) {
					sb.append(c);
				}
			} else {
				tmp.push(c);
			}
			if (i == 0) {
				while (!tmp.isEmpty()) {
					sb.append(tmp.pop());
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("   a   "));
	}
}
