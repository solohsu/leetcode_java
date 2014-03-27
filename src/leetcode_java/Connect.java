package leetcode_java;

public class Connect {
	public static void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			root.left.next = root.right;
			connect(root.left);
		}
		if (root.right != null) {
			if (root.next != null) {
				root.right.next = root.next.left;
			}
			connect(root.right);
		}
	}

	public static void main(String[] args) {
		// Accepted without off-line testing, lOl
	}

	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
