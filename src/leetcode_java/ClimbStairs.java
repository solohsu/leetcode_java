package leetcode_java;

import static java.lang.System.out;

public class ClimbStairs {
	public static int climbStairs(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return n;
		}
		int[] list = new int[n];
		list[0] = 1;
		list[1] = 2;
		for (int i = 2; i < n; i++) {
			list[i] = list[i - 2] + list[i - 1];
		}
		return list[n - 1];
	}

	public static void main(String[] args) {
		out.println(climbStairs(44));
	}
}
