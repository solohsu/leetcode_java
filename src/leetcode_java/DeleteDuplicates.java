package leetcode_java;

public class DeleteDuplicates {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode p, q;
		p = head;
		q = head.next;
		while (q != null) {
			if (q.val == p.val) {
				p.next = q.next;
			} else {
				p = p.next;
			}
			q = q.next;
		}
		return head;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
