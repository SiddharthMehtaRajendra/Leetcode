// https://www.youtube.com/watch?v=IYXWcjwhUYo

package Medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {
	class Solution {
		public List<String> letterCasePermutation(String s) {
			if (s == null || s.length() == 0)
				return Collections.emptyList();
			LinkedList<String> q = new LinkedList<>();
			int index = s.length() - 1;
			q.add(s);

			while (index >= 0) {
				char c = s.charAt(index);
				if (Character.isAlphabetic(c)) {
					int size = q.size();
					for (int i = 0; i < size; i++) {
						StringBuilder s1 = new StringBuilder(q.poll());
						StringBuilder s2 = new StringBuilder(s1);
						s1.setCharAt(index, Character.toLowerCase(c));
						s2.setCharAt(index, Character.toUpperCase(c));
						q.add(s1.toString());
						q.add(s2.toString());
					}
				}
				index--;
			}
			return q;
		}
	}
}
