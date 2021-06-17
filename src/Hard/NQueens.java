// https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
// https://www.youtube.com/watch?v=potGHy7NnzA

package Hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	class Solution {
		List<List<String>> result = new ArrayList<>();

		public List<List<String>> solveNQueens(int n) {
			if (n == 0)
				return result;
			int[][] board = new int[n][n];
			this.solveNQueens(n, 0, board);
			return this.result;
		}

		private void solveNQueens(int n, int col, int[][] board) {
			if (col == n) {
				List<String> curr = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					StringBuilder sb = new StringBuilder();
					for (int j = 0; j < n; j++) {
						if (board[i][j] == 1)
							sb.append("Q");
						else
							sb.append(".");
					}
					curr.add(sb.toString());
				}
				this.result.add(curr);
				return;
			}

			for (int i = 0; i < n; i++) {
				if (this.isSafe(board, i, col, n)) {
					board[i][col] = 1;
					this.solveNQueens(n, col + 1, board);
					board[i][col] = 0;
				}
			}
		}

		private boolean isSafe(int[][] board, int row, int col, int n) {
			for (int i = 0; i < col; i++) {
				if (board[row][i] == 1)
					return false;
			}

			for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
				if (board[i][j] == 1)
					return false;
			}

			for (int i = row, j = col; i < n && j >= 0; i++, j--) {
				if (board[i][j] == 1)
					return false;
			}
			return true;
		}
	}
}
