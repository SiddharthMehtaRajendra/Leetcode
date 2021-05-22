package Easy;

import java.util.Stack;

public class QueueUsingStack {
	class MyQueue {

		private Stack<Integer> st1;
		private Stack<Integer> st2;

		/** Initialize your data structure here. */
		public MyQueue() {
			this.st1 = new Stack<>();
			this.st2 = new Stack<>();
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			this.st1.push(x);
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			if (!st2.isEmpty())
				return st2.pop();
			while (!st1.isEmpty()) {
				st2.push(st1.pop());
			}
			return st2.pop();
		}

		/** Get the front element. */
		public int peek() {
			if (!st2.isEmpty())
				return st2.peek();
			while (!st1.isEmpty()) {
				st2.push(st1.pop());
			}
			return st2.peek();
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return st1.isEmpty() && st2.isEmpty();
		}
	}
}
