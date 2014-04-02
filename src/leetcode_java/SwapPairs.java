package leetcode_java;

public class SwapPairs {
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode ans = head.next, tmp;
		if (head != null && head.next != null) {
			tmp = swapPairs(head.next.next);
			head.next.next = head;
			head.next = tmp;
		}
		return ans;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		head = swapPairs(head);
		while (head != null) {
			System.out.print(head.val + "\t");
			head = head.next;
		}
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
