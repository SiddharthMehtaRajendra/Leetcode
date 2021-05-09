package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacterInString {
	class NaiveSolution {
		public int firstUniqChar(String s) {
			Map<Character, Integer> map = new HashMap<>();

			for (int i = 0; i < s.length(); i++) {
				map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			}

			for (int i = 0; i < s.length(); i++) {
				if (map.get(s.charAt(i)) == 1)
					return i;
			}
			return -1;
		}
	}

	class BetterSolution {
		public int firstUniqChar(String s) {
			int[] counter = new int[26];

			for (char c : s.toCharArray()) {
				int index = c - 'a';
				counter[index]++;
			}

			for (int i = 0; i < s.length(); i++) {
				int index = s.charAt(i) - 'a';
				if (counter[index] == 1)
					return i;
			}
			return -1;
		}
	}

	class OnePassSolution {
		public int firstUniqChar(String s) {
			Map<Character, Integer> map = new LinkedHashMap<>();
			Set<Character> visited = new HashSet<>();

			for (int i = 0; i < s.length(); i++) {
				char curr = s.charAt(i);
				if (visited.contains(curr)) {
					if (map.containsKey(curr)) {
						map.remove(curr);
					}
				} else {
					visited.add(curr);
					map.put(curr, i);
				}
			}
			return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
		}
	}
}
