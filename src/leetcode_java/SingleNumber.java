package leetcode_java;

public class SingleNumber {
	public static int singleNumber(int[] A) {
		int result = A[0];
		for (int i = 1; i < A.length; i++) {
			result ^= A[i];
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,1,2,2,3}));
	}
}
