package Easy;

import java.util.Stack;


public class MinStack {
	class Solution {

		Stack<Pair> st;

		class Pair {
			int value;
			int min;

			public Pair(int val, int min) {
				this.value = val;
				this.min = min;
			}

			public int getMin() {
				return this.min;
			}

			public int getValue() {
				return this.value;
			}
		}

		/** initialize your data structure here. */
		public Solution() {
			this.st = new Stack<>();
		}

		public void push(int val) {
			int currMin = val;
			if (!st.isEmpty()) {
				currMin = st.peek().getMin();
			}
			this.st.push(new Pair(val, Math.min(currMin, val)));
		}

		public void pop() {
			if (!st.isEmpty()) {
				this.st.pop();
			}
		}

		public int top() {
			if (!st.isEmpty()) {
				Pair pair = this.st.peek();
				return pair.getValue();
			}
			return -1;
		}

		public int getMin() {
			return this.st.peek().getMin();
		}
	}
}
