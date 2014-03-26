package leetcode_java;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<TreeNode> tmpStack = new Stack<>();

		while (root != null || !tmpStack.isEmpty()) {
			while (root != null) {
				result.add(root.val);
				tmpStack.push(root);
				root = root.left;
			}
			root = tmpStack.pop();
			root = root.right;
		}

		return result;

	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(3);
		t.left.right = new TreeNode(4);
		System.out.println(preorderTraversal(t));
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
