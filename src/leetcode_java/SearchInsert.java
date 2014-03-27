package leetcode_java;

public class SearchInsert {
	// time complexity: O(log n)
	public static int searchInsert(int[] A, int target) {
		int len = A.length;
		if (A[0] >= target) {
			return 0;
		}
		if (A[len - 1] < target) {
			return len;
		}
		if (A[len - 1] == target) {
			return len - 1;
		}
		int i, begin = 0, end = len - 1;
		while (begin < end - 1) {
			i = (begin + end + 1) / 2;
			if (A[i] == target) {
				return i;
			} else if (A[i] > target) {
				end = i;
			} else {
				begin = i;
			}
		}
		return begin + 1;
	}

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] { 1, 3, 4, 6, 7 }, 5));
	}
}
