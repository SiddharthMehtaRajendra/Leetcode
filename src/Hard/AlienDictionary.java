// https://www.youtube.com/watch?v=fhCXVABhFDc

package Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
	class Solution {
		public String alienOrder(String[] words) {
			if (words == null || words.length == 0)
				return "";
			Map<Character, Set<Character>> adjList = new HashMap<>();
			int[] indegrees = new int[26];

			for (String word : words) {
				for (char ch : word.toCharArray()) {
					if (!adjList.containsKey(ch)) {
						adjList.put(ch, new HashSet<>());
					}
				}
			}

			for (int i = 1; i < words.length; i++) {
				int length1 = words[i - 1].length();
				int length2 = words[i].length();
				int length = Math.min(length1, length2);

				boolean valid = false;
				for (int j = 0; j < length; j++) {
					char charOut = words[i - 1].charAt(j);
					char charIn = words[i].charAt(j);

					if (charOut != charIn) {
						valid = true;
						if (!(adjList.get(charOut).contains(charIn))) {
							adjList.get(charOut).add(charIn);
							indegrees[charIn - 'a'] += 1;
						}
						break;
					}
				}
				if (!valid && length1 > length2)
					return "";
			}

			String result = "";
			Queue<Character> queue = new LinkedList<>();
			for (char key : adjList.keySet()) {
				if (indegrees[key - 'a'] == 0)
					queue.offer(key);
			}

			while (!queue.isEmpty()) {
				char current = queue.poll();
				result += current;
				for (char neighbour : adjList.get(current)) {
					indegrees[neighbour - 'a'] -= 1;
					if (indegrees[neighbour - 'a'] == 0)
						queue.offer(neighbour);
				}
			}

			if (result.length() != adjList.size())
				return "";
			return result;
		}
	}
}
