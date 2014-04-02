package leetcode_java;

import leetcode_java.MergeTwoLists.ListNode;

public class Partition {
	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode smaller = new ListNode(0), larger = new ListNode(0), p = head, smallHead = null, largeHead = null;
		boolean smallheadFound = false, largeheadFound = false;
		while (p != null) {
			if (p.val < x) {
				smaller.next = new ListNode(p.val);
				smaller = smaller.next;
				if (!smallheadFound) {
					smallHead = smaller;
					smallheadFound = true;
				}
			} else {
				larger.next = new ListNode(p.val);
				larger = larger.next;
				if (!largeheadFound) {
					largeHead = larger;
					largeheadFound = true;
				}
			}
			p = p.next;
		}
		smaller.next = largeHead;
		return smallHead == null ? largeHead : smallHead;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		printLinkList(partition(head, 0));
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
