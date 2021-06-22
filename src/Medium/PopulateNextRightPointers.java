// https://www.youtube.com/watch?v=bmjAiDsIDas

package Medium;

public class PopulateNextRightPointers {

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	class Solution {
		public Node connect(Node root) {
			if (root == null || root.left == null)
				return root;
			Node leftPointer = root;
			while (leftPointer != null && leftPointer.left != null) {
				this.populateNextPointers(leftPointer);
				leftPointer = leftPointer.left;
			}
			return root;
		}

		private void populateNextPointers(Node node) {
			Node start = node;
			while (start != null) {
				start.left.next = start.right;
				if (start.next != null) {
					start.right.next = start.next.left;
				}
				start = start.next;
			}
		}
	}
}
