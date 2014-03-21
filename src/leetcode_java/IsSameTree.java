package leetcode_java;

public class IsSameTree {
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == q) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(0);
		t.left = new TreeNode(0);
		t.right = new TreeNode(0);
		t.left.left = new TreeNode(0);

		TreeNode s = new TreeNode(0);
		s.left = new TreeNode(1);
		s.right = new TreeNode(0);
		s.left.left = new TreeNode(0);

		System.out.println(isSameTree(t, s));
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
