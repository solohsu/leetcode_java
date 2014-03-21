package leetcode_java;

public class MaxDepth {
	public static int maxDepth(TreeNode root) {
		int lc, rc;

		if (root == null) {
			return 0;
		} else {
			lc = maxDepth(root.left) + 1;
			rc = maxDepth(root.right) + 1;
			return lc > rc ? lc : rc;
		}
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(0);
		t.left = new TreeNode(0);
		t.right = new TreeNode(0);
		t.left.left = new TreeNode(0);
		System.out.println(maxDepth(t));
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}