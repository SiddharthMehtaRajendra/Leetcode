// https://www.youtube.com/watch?v=3QJzHqNAEXs

package Medium;

import java.util.Stack;

public class RemoveKDigits {
	class Solution {
		public String removeKdigits(String num, int k) {
			if (k == 0)
				return num;
			Stack<Integer> st = new Stack<>();

			for (char c : num.toCharArray()) {
				int temp = c - '0';
				while (!st.isEmpty() && st.peek() > temp && k > 0) {
					st.pop();
					k--;
				}
				if (!st.isEmpty() || temp != 0)
					st.push(temp);
			}

			while (!st.isEmpty() && k > 0) {
				st.pop();
				k--;
			}
			if (st.isEmpty())
				return "0";

			StringBuilder sb = new StringBuilder();
			while (!st.isEmpty()) {
				sb.append(st.pop());
			}
			return sb.reverse().toString();
		}
	}
}
