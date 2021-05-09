package Hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowString {
	class Solution {
		public String minWindow(String s, String t) {
			if (s == null || t == null || s.isEmpty() || t.isEmpty())
				return "";
			Map<Character, Integer> map = new HashMap<>();

			for (char c : t.toCharArray()) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}

			int count = map.size();
			int i = 0, j = 0, left = 0, right = s.length() - 1;
			int min = s.length() + 1;

			while (j < s.length()) {
				char endChar = s.charAt(j++);
				if (map.containsKey(endChar)) {
					map.put(endChar, map.get(endChar) - 1);
					if (map.get(endChar) == 0)
						count--;
				}

				if (count > 0)
					continue;

				while (count == 0) {
					char startChar = s.charAt(i++);
					if (map.containsKey(startChar)) {
						map.put(startChar, map.get(startChar) + 1);
						if (map.get(startChar) > 0)
							count++;
					}
				}

				if ((j - i) < min) {
					left = i;
					right = j;
					min = (j - i);
				}
			}

			return min > s.length() ? "" : s.substring(left - 1, right);
		}
	}
}
