// https://www.youtube.com/watch?v=BQk9kGO725E

package Easy;

import java.util.HashSet;

public class LongestPalindrome {
	class Solution {
		public int longestPalindrome(String s) {
			if (s == null || s.length() == 0)
				return 0;
			HashSet<Character> set = new HashSet<>();
			int count = 0;

			for (char c : s.toCharArray()) {
				if (!set.contains(c)) {
					set.add(c);
				} else {
					count += 2;
					set.remove(c);
				}
			}

			if (!set.isEmpty())
				count += 1;
			return count;
		}
	}
}
