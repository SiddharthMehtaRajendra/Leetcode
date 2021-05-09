package Easy;

import java.util.Stack;

public class ValidParentheses {
	class Solution {
		public boolean isValid(String s) {
			if (s == null || s.length() == 0)
				return false;
			Stack<Character> st = new Stack<>();

			for (char ch : s.toCharArray()) {
				if (ch == '(')
					st.push(')');
				else if (ch == '[')
					st.push(']');
				else if (ch == '{')
					st.push('}');
				else if (st.isEmpty() || st.pop() != ch)
					return false;
			}
			return st.isEmpty();
		}
	}
}
