package leetcode_java;

public class SingleNumberII {
	public static int singleNumber(int[] A) {
		int count, result = 0;
		for (int i = 0; i < 32; i++) {
			count = 0;
			for (int j = 0; j < A.length; j++) {
				count += (A[j] >> i) & 1;
			}
			result |= ((count % 3) << i);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 4, 4, 1, 1, 1, 5, 2, 2, 2,
				3, 3, 3, 4 }));
	}
}
