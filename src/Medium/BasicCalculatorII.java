// https://www.youtube.com/watch?v=2EErQ25kKE8 (Similar)

package Medium;

import java.util.Stack;

public class BasicCalculatorII {
	class Solution {
		public int calculate(String s) {
			if (s == null || s.length() == 0)
				return 0;
			return this.calculator(s.trim());
		}

		private int calculator(String s) {
			Integer curr = 0;
			char operator = '+';
			Stack<Integer> st = new Stack<>();
			for (char c : s.toCharArray()) {
				if (Character.isDigit(c)) {
					curr = (curr * 10) + (c - '0');
				} else {
					if (c == ' ')
						continue;
					this.process(operator, curr, st);
					operator = c;
					curr = 0;
				}
			}
			if (curr != 0) {
				this.process(operator, curr, st);
			}
			int result = 0;
			while (!st.isEmpty()) {
				result += st.pop();
			}
			return result;
		}

		private void process(char operator, Integer curr, Stack<Integer> st) {
			if (operator == '*') {
				int value = st.pop() * curr;
				st.push(value);
			} else if (operator == '/') {
				int value = st.pop() / curr;
				st.push(value);
			} else if (operator == '-') {
				st.push(-curr);
			} else {
				st.push(curr);
			}
		}
	}
}
