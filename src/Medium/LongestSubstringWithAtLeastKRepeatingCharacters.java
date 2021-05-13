// https://www.youtube.com/watch?v=bHZkCAcj3dc

package Medium;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
	class Solution {
		public int longestSubstring(String s, int k) {
			if (s == null || s.length() == 0)
				return 0;
			if (k == 0 || k == 1)
				return s.length();

			return this.longestSubstringUtil(s, k);
		}

		public int longestSubstringUtil(String s, int k) {
			if (s.length() < k)
				return 0;

			int[] frequencyMap = new int[26];
			for (char c : s.toCharArray()) {
				frequencyMap[c - 'a'] += 1;
			}

			int start = 0;
			while (start < s.length() && frequencyMap[s.charAt(start) - 'a'] >= k)
				start++;
			if (start == s.length())
				return start;

			int lengthOne = this.longestSubstringUtil(s.substring(0, start), k);
			while (start < s.length() && frequencyMap[s.charAt(start) - 'a'] < k)
				start++;
			int lengthTwo = this.longestSubstringUtil(s.substring(start), k);
			return Math.max(lengthOne, lengthTwo);
		}
	}
}
