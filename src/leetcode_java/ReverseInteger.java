package leetcode_java;

public class ReverseInteger {
	public static int reverse(int x) {
		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
			x = -x;
		}
		String s = String.valueOf(x);
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		int result = Integer.parseInt(sb.toString());
		return isNegative ? -result : result;
	}

	public static void main(String[] args) {
		System.out.println(reverse(-132001));
	}
}
