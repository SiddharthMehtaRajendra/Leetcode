// https://www.youtube.com/watch?v=6Qkail843d8

package Easy;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {
	class Solution {
		public boolean isIsomorphic(String s, String t) {
			if ((s == null && t == null) || (s.isEmpty() && t.isEmpty()))
				return true;
			else if (s == null || t == null || s.isEmpty() || t.isEmpty())
				return false;

			HashMap<Character, Character> mapping = new HashMap<>();
			HashSet<Character> used = new HashSet<>();

			for (int i = 0; i < s.length(); i++) {
				char ch1 = s.charAt(i);
				char ch2 = t.charAt(i);

				if (!mapping.containsKey(ch1) && !used.contains(ch2)) {
					mapping.put(ch1, ch2);
					used.add(ch2);
				} else if (mapping.containsKey(ch1) && mapping.get(ch1) == ch2) {
					continue;
				} else {
					return false;
				}
			}
			return true;
		}
	}
}
