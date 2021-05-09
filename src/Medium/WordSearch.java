package Medium;

public class WordSearch {
	class Solution {
		int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int m, n;

		public boolean exist(char[][] board, String word) {
			if (board == null || board.length == 0)
				return false;
			m = board.length;
			n = board[0].length;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == word.charAt(0) && dfs(board, i, j, 1, word)) {
						return true;
					}
				}
			}
			return false;
		}

		private boolean dfs(char[][] board, int i, int j, int count, String word) {
			if (count == word.length())
				return true;
			char temp = board[i][j];
			board[i][j] = '*';
			for (int[] direction : directions) {
				int r = direction[0] + i;
				int c = direction[1] + j;
				if (r >= 0 && r < m && c >= 0 && c < n && board[r][c] == word.charAt(count)) {
					if (dfs(board, r, c, count + 1, word)) {
						return true;
					}
				}
			}
			board[i][j] = temp;
			return false;
		}
	}
}
