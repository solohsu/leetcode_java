package leetcode_java;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
	public static ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<TreeNode> tmpStack = new Stack<>();

		while (root != null || !tmpStack.isEmpty()) {
			while (root != null) {
				tmpStack.push(root);
				root = root.left;
			}
			root = tmpStack.pop();
			result.add(root.val);
			root = root.right;
		}

		return result;
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(3);
		t.left.right = new TreeNode(4);
		System.out.println(inorderTraversal(t));
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
