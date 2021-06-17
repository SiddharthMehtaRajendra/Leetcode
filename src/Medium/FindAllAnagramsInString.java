// https://www.youtube.com/watch?v=slDyFUnGtoU

package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindAllAnagramsInString {
	class Solution {
		public List<Integer> findAnagrams(String s, String p) {
			if (s == null || s.length() == 0 || s.length() < p.length())
				return Collections.emptyList();
			int[] charMap = new int[26];
			int[] reverseCharMap = new int[26];
			int left = 0, right = 0;

			while (right < p.length()) {
				charMap[p.charAt(right) - 'a']++;
				right++;
			}

			while (left < p.length()) {
				reverseCharMap[s.charAt(left) - 'a']++;
				left++;
			}

			List<Integer> result = new ArrayList<>();
			while (left < s.length()) {
				if (Arrays.equals(charMap, reverseCharMap)) {
					result.add(left - p.length());
				}

				char curr = s.charAt(left - p.length());
				if (reverseCharMap[curr - 'a'] > 0) {
					reverseCharMap[curr - 'a']--;
				}
				char next = s.charAt(left++);
				reverseCharMap[next - 'a']++;
			}
			if (Arrays.equals(charMap, reverseCharMap)) {
				result.add(left - p.length());
			}
			return result;
		}
	}
}
