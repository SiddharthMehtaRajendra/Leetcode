package Medium;

import java.util.HashMap;

public class CopyListWithRandomPointers {

	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	class LinearSpaceSolution {
		public Node copyRandomList(Node head) {
			HashMap<Node, Node> cache = new HashMap<>();
			cache.put(null, null);

			Node curr = head;
			while (curr != null) {
				Node newNode = new Node(curr.val);
				cache.put(curr, newNode);
				curr = curr.next;
			}

			curr = head;
			while (curr != null) {
				Node oldNode = cache.get(curr);
				oldNode.next = cache.get(curr.next);
				oldNode.random = cache.get(curr.random);
				curr = curr.next;
			}

			return cache.get(head);
		}
	}
}
