// https://www.youtube.com/watch?v=uhZeoivB7_4

package Hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	class Solution {
		List<String> solutions = new ArrayList<>();

		public List<String> addOperators(String num, int target) {
			this.dfs(num, "", target, 0, 0, 0);
			return this.solutions;
		}

		private void dfs(String num, String candidate, long target, int position, long total, long prev_add) {
			if (position == num.length() && total == target) {
				solutions.add(candidate);
				return;
			}
			for (int i = position + 1; i <= num.length(); i++) {
				String str = num.substring(position, i);
				long digits = Long.parseLong(str);
				if (num.charAt(position) == '0' && !str.equals("0"))
					continue;
				if (candidate.length() == 0) {
					this.dfs(num, str, target, i, digits, digits);
				} else {
					this.dfs(num, candidate + "+" + str, target, i, total + digits, digits);
					this.dfs(num, candidate + "-" + str, target, i, total - digits, -digits);
					this.dfs(num, candidate + "*" + str, target, i, total - prev_add + prev_add * digits,
							prev_add * digits);
				}
			}
		}
	}
}
