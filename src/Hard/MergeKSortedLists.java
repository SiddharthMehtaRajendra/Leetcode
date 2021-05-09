package Hard;

import java.util.PriorityQueue;

public class MergeKSortedLists {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			if (lists == null || lists.length == 0)
				return null;

			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (ListNode curr : lists) {
				while (curr != null) {
					pq.offer(curr.val);
					curr = curr.next;
				}
			}

			ListNode dummy = new ListNode(-1);
			ListNode curr = dummy;

			while (!pq.isEmpty()) {
				curr.next = new ListNode(pq.poll());
				curr = curr.next;
			}
			return dummy.next;
		}
	}
}
