package leetcode_java;

public class MergeTwoLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		ListNode ans, tmp;
		if (l1.val <= l2.val) {
			ans = l1;
			l1 = l1.next;
		} else {
			ans = l2;
			l2 = l2.next;
		}
		tmp = ans;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				tmp.next = l1;
				tmp = l1;
				l1 = l1.next;
			} else {
				tmp.next = l2;
				tmp = l2;
				l2 = l2.next;
			}
		}
		while (l1 != null) {
			tmp.next = l1;
			tmp = l1;
			l1 = l1.next;
		}
		while (l2 != null) {
			tmp.next = l2;
			tmp = l2;
			l2 = l2.next;
		}
		return ans;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(-6), l2 = new ListNode(1);
		l1.next = new ListNode(5);
		// ListNode p = l1, q = l2;
		// for (int i = 1; i <= 5; i++) {
		// q.next = new ListNode(2 * i + 1);
		// p.next = new ListNode(2 * i);
		// p = p.next;
		// q = q.next;
		// }
		printLinkList(l1);
		printLinkList(l2);
		printLinkList(mergeTwoLists(l1, l2));
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	static public void printLinkList(ListNode lst) {
		while (lst != null) {
			System.out.print(lst.val + "\t");
			lst = lst.next;
		}
		System.out.println();
	}
}
