package leetcode_java;

public class RemoveDuplicates {
	public static int removeDuplicates(int[] A) {
		int len = A.length;
		if (len < 3) {
			return len;
		}
		int tmp = A[0], count = 1;
		int result = len;
		for (int i = 1; i < result; i++) {
			if (A[i] == tmp) {
				count++;
			} else {
				tmp = A[i];
				if (count > 2) {
					for (int j = i; j < result; j++) {
						A[j - (count - 2)] = A[j];
					}
					result -= (count - 2);
					i -= count - 2;
				}
				count = 1;
			}

			// printArray(A, result);
			// System.out.println(count);
		}

		if (count > 2) {
			result -= (count - 2);
		}

		return result;
	}

	private static void printArray(int[] a, int result) {
		for (int i = 0; i < result; i++) {
			System.out.print(a[i] + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 2, 2 };
		int len = removeDuplicates(A);
		System.out.println(len);
		for (int i = 0; i < len; i++) {
			System.out.print(A[i] + "\t");
		}
	}
}
