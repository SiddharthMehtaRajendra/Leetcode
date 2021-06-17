// https://www.youtube.com/watch?v=3jvWodd7ht0

package Medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	class Solution {
		List<List<String>> result = new ArrayList<>();

		public List<List<String>> partition(String s) {
			if (s == null || s.length() == 0)
				return result;
			this.backtrack(s, 0, new ArrayList<>());
			return result;
		}

		private void backtrack(String s, int index, List<String> curr) {
			if (index == s.length()) {
				result.add(new ArrayList<>(curr));
				return;
			}

			for (int i = index; i < s.length(); i++) {
				String partition = s.substring(index, i + 1);
				if (this.isPalindrome(s, index, i)) {
					curr.add(partition);
					this.backtrack(s, i + 1, curr);
					curr.remove(curr.size() - 1);
				}
			}
		}

		private boolean isPalindrome(String str, int i, int j) {
			while (i < j) {
				if (str.charAt(i) != str.charAt(j))
					return false;
				i++;
				j--;
			}
			return true;
		}
	}
}
