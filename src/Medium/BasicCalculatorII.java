package Medium;

import java.util.Stack;

public class BasicCalculatorII {
	class Solution {
		public int calculate(String s) {
			if (s == null || s.length() == 0)
				return 0;
			return calculator(s.trim());
		}

		private int calculator(String s) {
			String curr = "";
			char operator = '+';
			Stack<String> st = new Stack<>();
			for (char c : s.toCharArray()) {
				if (Character.isDigit(c)) {
					curr += c;
				} else {
					if (c == ' ')
						continue;
					process(operator, curr, st);
					operator = c;
					curr = "";
				}
			}
			if (curr.length() != 0) {
				process(operator, curr, st);
			}
			int result = 0;
			while (!st.isEmpty()) {
				result += Integer.parseInt(st.pop());
			}
			return result;
		}

		private void process(char operator, String curr, Stack<String> st) {
			if (operator == '*') {
				int value = Integer.parseInt(st.pop()) * Integer.parseInt(curr);
				st.push(String.valueOf(value));
			} else if (operator == '/') {
				int value = Integer.parseInt(st.pop()) / Integer.parseInt(curr);
				st.push(String.valueOf(value));
			} else if (operator == '-') {
				curr = operator + curr;
				st.push(curr);
			} else {
				st.push(curr);
			}
		}
	}
}
