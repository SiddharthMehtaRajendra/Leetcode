package Medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

	class Node {
		int key;
		int value;
		Node next;
		Node prev;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	@SuppressWarnings("serial")
	class LRUCacheSolution1 extends LinkedHashMap<Integer, Integer> {
		private int capacity;

		public LRUCacheSolution1(int capacity) {
			super(capacity, 0.75F, true);
			this.capacity = capacity;
		}

		public int get(int key) {
			return super.getOrDefault(key, -1);
		}

		public void put(int key, int value) {
			super.put(key, value);
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
			return this.size() > capacity;
		}
	}

	class LRUCacheSolution2 {

		private void addToHead(Node node) {
			node.prev = head;
			head.next.prev = node;
			node.next = head.next;
			head.next = node;
		}

		private void removeNode(Node node) {
			node.next.prev = node.prev;
			node.prev.next = node.next;
		}

		private void moveToHead(Node node) {
			removeNode(node);
			addToHead(node);
		}

		private Map<Integer, Node> map = new HashMap<>();
		Node head, tail;
		int capacity;
		int size;

		public LRUCacheSolution2(int capacity) {
			this.capacity = capacity;
			this.size = 0;

			this.head = new Node(-1, -1);
			this.tail = new Node(-1, -1);

			this.head.next = tail;
			this.tail.prev = head;
		}

		public int get(int key) {
			Node node = map.get(key);
			if (node == null)
				return -1;

			moveToHead(node);
			return node.value;
		}

		public void put(int key, int value) {
			Node node = map.get(key);
			if (node == null) {
				Node newNode = new Node(key, value);
				addToHead(newNode);
				map.put(key, newNode);
				++size;

				if (size > capacity) {
					map.remove(tail.prev.key);
					removeNode(tail.prev);
					--size;
				}
			} else {
				node.value = value;
				moveToHead(node);
			}
		}
	}
}
