// https://www.youtube.com/watch?v=4a4bspKyOH8

package Medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseSubstringBetweenParentheses {
	class Solution {
		public String reverseParentheses(String s) {
			if (s == null || s.length() == 0)
				return "";
			Stack<Character> st = new Stack<>();

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ')') {
					Queue<Character> q = new LinkedList<>();
					while (st.peek() != '(') {
						q.offer(st.pop());
					}
					st.pop();
					while (!q.isEmpty()) {
						st.push(q.poll());
					}
				} else {
					st.push(s.charAt(i));
				}
			}
			StringBuilder result = new StringBuilder();
			while (!st.isEmpty()) {
				result.append(st.pop());
			}
			return result.reverse().toString();
		}
	}
}
