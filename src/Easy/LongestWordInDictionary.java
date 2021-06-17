// https://www.youtube.com/watch?v=QHvhL94u7gc

package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class LongestWordInDictionary {
	class Solution {
		private TrieNode root = new TrieNode();

		public String longestWord(String[] words) {
			if (words == null || words.length == 0)
				return "";
			this.insertWordsInTrie(words);
			Queue<TrieNode> q = new LinkedList<>();
			q.add(root);
			TrieNode node = null;
			while (!q.isEmpty()) {
				node = q.poll();
				for (int i = 25; i >= 0; i--) {
					if (node.children[i] != null && node.children[i].word.length() > 0) {
						q.add(node.children[i]);
					}
				}
			}
			return node.word;
		}

		private void insertWordsInTrie(String[] words) {
			for (int i = 0; i < words.length; i++) {
				TrieNode curr = this.root;
				String word = words[i];
				for (int j = 0; j < word.length(); j++) {
					char c = word.charAt(j);
					if (curr.children[c - 'a'] == null) {
						curr.children[c - 'a'] = new TrieNode();
					}
					curr = curr.children[c - 'a'];
				}
				curr.word = word;
			}
		}

		class TrieNode {
			String word = "";
			TrieNode[] children = new TrieNode[26];
		}
	}
}
