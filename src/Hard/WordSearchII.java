// https://www.youtube.com/watch?v=EmvsBM7o-5k

package Hard;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	class Solution {
		List<String> result = new ArrayList<>();
		int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		Node trie;
		int m, n;

		class Node {
			char c;
			boolean end;
			String word;
			Node[] child;

			public Node(char c) {
				this.c = c;
				this.end = false;
				this.word = "";
				this.child = new Node[26];
			}
		}

		private void constructTrie(String[] words) {
			this.trie = new Node('/');
			for (String str : words) {
				Node curr = trie;
				for (char c : str.toCharArray()) {
					int index = c - 'a';
					if (curr.child[index] == null) {
						curr.child[index] = new Node(c);
					}
					curr = curr.child[index];
				}
				curr.end = true;
				curr.word = str;
			}
		}

		public List<String> findWords(char[][] board, String[] words) {
			if (words == null || board == null || words.length == 0 || board.length == 0)
				return new ArrayList<>();
			this.m = board.length;
			this.n = board[0].length;
			this.constructTrie(words);
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					this.dfs(board, i, j, trie);
				}
			}
			return result;
		}

		private void dfs(char[][] board, int i, int j, Node curr) {
			int index = board[i][j] - 'a';
			curr = curr.child[index];
			if (curr == null)
				return;
			if (curr.end) {
				result.add(curr.word);
				curr.end = false;
			}
			char temp = board[i][j];
			board[i][j] = '$';
			for (int[] dir : directions) {
				int r = dir[0] + i;
				int c = dir[1] + j;
				if (r >= 0 && r < m && c >= 0 && c < n && board[r][c] != '$') {
					dfs(board, r, c, curr);
				}
			}
			board[i][j] = temp;
		}
	}
}
