package leetcode_java;

public class HasCircle {
	public static boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(0);
		list1.next = list1;
		System.out.println(hasCycle(list1));

		ListNode list2 = new ListNode(0);
		list2.next = new ListNode(0);
		list2.next.next = new ListNode(0);
		list2.next.next.next = list2.next.next;
		System.out.println(hasCycle(list2));

		ListNode list3 = new ListNode(0);
		list3.next = new ListNode(0);
		list3.next.next = new ListNode(0);
		System.out.println(hasCycle(list3));

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
