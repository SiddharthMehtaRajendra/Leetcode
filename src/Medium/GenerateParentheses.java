package Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	class Solution {
		public List<String> generateParenthesis(int n) {
			if (n == 0)
				return new ArrayList<>();
			List<String> result = new ArrayList<>();
			backtrack(result, "", 0, 0, n);
			return result;
		}

		private void backtrack(List<String> result, String current, int open, int close, int max) {
			if (current.length() == max * 2) {
				result.add(current);
				return;
			}

			if (open < max) {
				backtrack(result, current + "(", open + 1, close, max);
			}
			if (close < open) {
				backtrack(result, current + ")", open, close + 1, max);
			}
		}
	}
}
