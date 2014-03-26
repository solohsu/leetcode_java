package leetcode_java;

public class NumTrees {
	public static int numTrees(int n) {
		if (0 == n) {
			return 1;
		} else if (1 == n) {
			return 1;
		}
		int count = 0;
		for (int i = 1; i <= n; i++) {
			count = count + numTrees(i - 1) * numTrees(n - i);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(numTrees(4));
	}
}
