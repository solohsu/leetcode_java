package leetcode_java;

public class FirstMissingPositive {
	/**
	 * 要找的数肯定在[1,n+1]范围内，
	 * 第一次遍历将值为i的数放到A[i]的位置，
	 * 第二次遍历查找A[i]!=i+1的位置，要找的数则为i+1。
	 * 若不存在这样的位置，则要找的数位A.length+1。
	 * @param A
	 * @return
	 */
	public static int firstMissingPositive(int[] A) {
		int i = 0, len = A.length, tmp;
		while (i < len) {
			if (A[i] != (i + 1) && A[i] >= 1 && A[i] <= len
					&& A[A[i] - 1] != A[i]) {
				tmp = A[A[i] - 1];
				A[A[i] - 1] = A[i];
				A[i] = tmp;
			} else {
				i++;
			}
		}
		for (i = 0; i < len; ++i) {
			if (A[i] != (i + 1)) {
				return i + 1;
			}
		}
		return len + 1;
	}

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] { 8, 6, 7, 376, 13,
				7, 4 }));
	}

}
