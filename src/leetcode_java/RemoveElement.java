package leetcode_java;

public class RemoveElement {
	public static int removeElement(int[] A, int elem) {
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (elem == A[i]) {
				count++;
			} else {
				A[i - count] = A[i];
			}
		}
		return A.length - count;
	}
}
