package Easy;

public class ReverseLinkedList {
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

	class RecursiveSolution {
		public ListNode reverseList(ListNode head) {
			if (head == null || head.next == null)
				return head;
			ListNode temp = reverseList(head.next);
			head.next.next = head;
			head.next = null;
			return temp;
		}
	}

	class IterativeSolution {
		public ListNode reverseList(ListNode head) {
			if (head == null)
				return head;
			return reverse(head);
		}

		private ListNode reverse(ListNode head) {
			ListNode prev = null;
			ListNode temp = null;
			ListNode curr = head;
			while (curr != null) {
				temp = curr.next;
				curr.next = prev;
				prev = curr;
				curr = temp;
			}
			return prev;
		}
	}
}
