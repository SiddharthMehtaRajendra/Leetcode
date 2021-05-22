// https://www.youtube.com/watch?v=pfA0VuvwpVg

package Medium;

public class LinkedListCycleII {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class Solution {
		public ListNode detectCycle(ListNode head) {
			if (head == null)
				return null;
			ListNode intersect = this.findIntersect(head);
			if (intersect == null)
				return null;

			ListNode slow = head;
			while (slow != intersect) {
				slow = slow.next;
				intersect = intersect.next;
			}

			return slow;
		}

		private ListNode findIntersect(ListNode head) {
			ListNode slow = head;
			ListNode fast = head;

			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;

				if (slow == fast)
					return slow;
			}
			return null;
		}
	}
}
