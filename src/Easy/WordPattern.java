
package Easy;

import java.util.HashMap;

public class WordPattern {
	class Solution {
		public boolean wordPattern(String pattern, String s) {
			if (pattern == null || s == null || pattern.isEmpty() || s.isEmpty())
				return false;
			HashMap<Character, String> mapping = new HashMap<>();
			String[] words = s.split(" ");

			if (pattern.length() != words.length)
				return false;

			for (int i = 0; i < pattern.length(); i++) {
				char ch = pattern.charAt(i);
				String word = words[i];
				if (mapping.containsKey(ch) && mapping.get(ch).equals(word))
					continue;
				else if (mapping.containsKey(ch) && !(mapping.get(ch).equals(word)))
					return false;
				else if (!mapping.containsKey(ch) && mapping.values().contains(word))
					return false;
				else
					mapping.put(ch, word);
			}
			return true;
		}
	}
}
