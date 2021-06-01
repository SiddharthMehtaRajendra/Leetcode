// https://www.youtube.com/watch?v=To_uAJRu8NQ

package Medium;

import java.util.ArrayDeque;

public class ReorderList {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	class Solution {
		public void reorderList(ListNode head) {
			if (head == null || head.next == null)
				return;
			ArrayDeque<ListNode> deque = new ArrayDeque<>();

			ListNode node = head;
			node = node.next;
			while (node != null) {
				deque.addLast(node);
				node = node.next;
			}

			while (!deque.isEmpty() && head != null) {
				ListNode temp = deque.pollLast();
				head.next = temp;
				head = head.next;

				if (head != null && !deque.isEmpty()) {
					temp = deque.pollFirst();
					head.next = temp;
					head = head.next;
				}
			}
			head.next = null;
		}
	}
}
