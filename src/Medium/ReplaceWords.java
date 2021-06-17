// https://www.youtube.com/watch?v=QHvhL94u7gc

package Medium;

import java.util.List;

public class ReplaceWords {

	class Solution {
		private TrieNode root = new TrieNode();

		public String replaceWords(List<String> dictionary, String sentence) {
			if (dictionary == null || dictionary.size() == 0)
				return sentence;
			this.insertWordsInTrie(dictionary);
			String[] words = sentence.split(" ");
			StringBuilder sb = new StringBuilder();
			for (String word : words) {
				TrieNode curr = root;
				if (sb.length() > 0) {
					sb.append(" ");
				}
				for (int i = 0; i < word.length(); i++) {
					char c = word.charAt(i);
					if (curr.children[c - 'a'] == null || curr.word.length() > 0)
						break;
					curr = curr.children[c - 'a'];
				}
				if (curr.word.length() > 0) {
					sb.append(curr.word);
				} else {
					sb.append(word);
				}
			}
			return sb.toString();
		}

		private void insertWordsInTrie(List<String> dictionary) {
			for (int i = 0; i < dictionary.size(); i++) {
				TrieNode curr = this.root;
				String word = dictionary.get(i);
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
