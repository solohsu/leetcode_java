package leetcode_java;

import java.util.Stack;

/**
 * http://oj.leetcode.com/problems/symmetric-tree/
 * 
 * @author solohsu
 *
 */
public class IsSymmetric {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * Recursive Version
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		TreeNode l = new TreeNode(0), r = new TreeNode(0);
		if (root.left == null && root.right == null) {
			return true;
		} else if (root.left == null || root.right == null) {
			return false;
		} else if (root.left.val == root.right.val) {
			l.left = root.left.left;
			l.right = root.right.right;
			r.left = root.left.right;
			r.right = root.right.left;
			return isSymmetric(l) && isSymmetric(r);
		} else {
			return false;
		}
	}

	/**
	 * Iterative Version
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric_iterative(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root.left);
		s2.push(root.right);
		while (!s1.isEmpty() && !s2.isEmpty()) {
			TreeNode left = s1.pop(), right = s2.pop();
			if (left == null && right == null) {
				continue;
			} else if (left == null || right == null || left.val != right.val) {
				return false;
			} else {
				s1.push(left.left);
				s2.push(right.right);
				s1.push(left.right);
				s2.push(right.left);
			}
		}
		return true;
	}
}
