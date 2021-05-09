package Medium;

public class AddTwoNumbers {

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
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if (l1 == null && l2 == null)
				return null;
			ListNode dummy = new ListNode(0);
			ListNode p = l1;
			ListNode q = l2;
			ListNode curr = dummy;
			int sum = 0, carry = 0;

			while (p != null || q != null) {
				int x = (p != null) ? p.val : 0;
				int y = (q != null) ? q.val : 0;
				sum = x + y + carry;
				carry = sum / 10;
				curr.next = new ListNode(sum % 10);
				curr = curr.next;
				if (p != null)
					p = p.next;
				if (q != null)
					q = q.next;
			}
			if (carry != 0) {
				curr.next = new ListNode(carry);
			}
			return dummy.next;
		}
	}
}
