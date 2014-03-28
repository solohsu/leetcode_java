package leetcode_java;

import java.util.Arrays;

public class MaxSubArray {
	public static int maxSubArray(int[] A) {
		int len = A.length;
		if (len == 1) {
			return A[0];
		}
		int tmp = A[0], max = A[0];
		for (int i = 1; i < len; i++) {
			if (tmp < 0) {
				tmp = 0;
			}
			tmp += A[i];
			max = max > tmp ? max : tmp;
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5,
				4 }));
		;
	}
}
