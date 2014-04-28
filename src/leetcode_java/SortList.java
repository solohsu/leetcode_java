package leetcode_java;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class SortList {

	class ListNodeWrapper {
		ListNode listNode;
		int index;

		public ListNodeWrapper(ListNode listNode, int index) {
			this.listNode = listNode;
			this.index = index;
		}
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = head, ans;
		TreeSet<ListNodeWrapper> set = new TreeSet<>(
				new Comparator<ListNodeWrapper>() {
					@Override
					public int compare(ListNodeWrapper o1, ListNodeWrapper o2) {
						int result = Integer.valueOf(o1.listNode.val)
								.compareTo(Integer.valueOf(o2.listNode.val));
						if (result == 0) {
							return Integer.valueOf(o1.index).compareTo(
									Integer.valueOf(o2.index));
						}
						return result;
					}
				});
		int index = 1;
		while (p != null) {
			set.add(new ListNodeWrapper(p, index));
			p = p.next;
			index++;
		}
		Iterator<ListNodeWrapper> it = set.iterator();
		p = it.next().listNode;
		ans = p;
		while (it.hasNext()) {
			p.next = it.next().listNode;
			p = p.next;
		}
		p.next = null;
		return ans;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(5);
		head.next = new ListNode(1);
		head.next.next = new ListNode(10);
		head.next.next.next = new ListNode(1);
		printLinkedList(head);
		printLinkedList(new SortList().sortList(head));
	}

	public static void printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "\t");
			head = head.next;
		}
		System.out.println();
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
