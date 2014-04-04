package leetcode_java;

public class RemoveNthFromEnd {
	/**
	 * 设置两个指针p,q,等p遍历过n+1个元素后q开始与p同时向后遍历，
	 * 如果链表长度count==n，则q始终未动，需要去掉的是头元素；
	 * 否则，去掉的是q所在的下一个元素。
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p, q;
		int count = 0;
		p = q = head;
		while (p != null) {
			if (++count - n > 1) {
				q = q.next;
			}
			p = p.next;
		}
		if(count == n){
			return head.next;
		}
		q.next = q.next.next;
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
