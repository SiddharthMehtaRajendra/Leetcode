package Medium;

public class GameOfLife {
	class ExtraSpaceSolution {
		public void gameOfLife(int[][] board) {
			if (board == null || board.length == 0)
				return;
			int m = board.length;
			int n = board[0].length;
			int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { 1, -1 },
					{ -1, -1 }, { -1, 1 } };
			int[][] nextState = new int[m][n];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					int liveCount = 0;
					for (int[] direction : directions) {
						int r = direction[0] + i;
						int c = direction[1] + j;
						if (r >= 0 && r < m && c >= 0 && c < n && board[r][c] == 1) {
							liveCount++;
						}
					}

					if (board[i][j] == 0 && liveCount == 3) {
						nextState[i][j] = 1;
					} else if (board[i][j] == 1) {
						if (liveCount == 2 || liveCount == 3) {
							nextState[i][j] = 1;
						} else if (liveCount < 2 || liveCount > 3) {
							continue;
						}
					}
				}
			}

			for (int i = 0; i < m; i++) {
				board[i] = nextState[i].clone();
			}
		}
	}

	class ConstantSpaceSolution {
		public void gameOfLife(int[][] board) {
			if (board == null || board.length == 0)
				return;
			int m = board.length;
			int n = board[0].length;
			int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { 1, -1 },
					{ -1, -1 }, { -1, 1 } };

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					int liveCount = 0;
					for (int[] direction : directions) {
						int r = direction[0] + i;
						int c = direction[1] + j;
						if (r >= 0 && r < m && c >= 0 && c < n && Math.abs(board[r][c]) == 1) {
							liveCount++;
						}
					}

					if (board[i][j] == 0 && liveCount == 3) {
						board[i][j] = 2;
					} else if (board[i][j] == 1) {
						if (liveCount < 2 || liveCount > 3) {
							board[i][j] = -1;
						}
					}
				}
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] > 0) {
						board[i][j] = 1;
					} else {
						board[i][j] = 0;
					}
				}
			}
		}
	}
}
