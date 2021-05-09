package Easy;

import java.util.Arrays;

public class ValidAnagram {
	class NaiveSolution {
		public boolean isAnagram(String s, String t) {
			if (s.length() != t.length())
				return false;
			char[] arrS = s.toCharArray();
			char[] arrT = t.toCharArray();
			Arrays.sort(arrS);
			Arrays.sort(arrT);
			if (Arrays.equals(arrS, arrT))
				return true;
			return false;
		}
	}

	class Solution {
		public boolean isAnagram(String s, String t) {
			if (s.length() != t.length())
				return false;
			int[] counter = new int[26];
			int i = 0;

			while (i < s.length() && i < t.length()) {
				counter[s.charAt(i) - 'a']++;
				counter[t.charAt(i) - 'a']--;
				i++;
			}

			for (int count : counter) {
				if (count != 0)
					return false;
			}
			return true;
		}
	}
}
