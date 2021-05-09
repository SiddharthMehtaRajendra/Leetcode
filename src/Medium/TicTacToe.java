// Video: https://www.youtube.com/watch?v=oP_0hWm_bDA

package Medium;

public class TicTacToe {
	class Solution {

		int size;
		int[] rows;
		int[] cols;
		int diagonal;
		int antiDiagonal;

		/** Initialize your data structure here. */
		public Solution(int n) {
			this.size = n;
			this.rows = new int[n];
			this.cols = new int[n];
		}

		/**
		 * Player {player} makes a move at ({row}, {col}).
		 * 
		 * @param row    The row of the board.
		 * @param col    The column of the board.
		 * @param player The player, can be either 1 or 2.
		 * @return The current winning condition, can be either: 0: No one wins. 1:
		 *         Player 1 wins. 2: Player 2 wins.
		 */
		public int move(int row, int col, int player) {
			int value = player == 1 ? 1 : -1;
			rows[row] += value;
			cols[col] += value;
			if (row == col)
				diagonal += value;
			if (row == (cols.length - 1 - col))
				antiDiagonal += value;

			if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(diagonal) == size
					|| Math.abs(antiDiagonal) == size) {
				return player;
			}
			return 0;
		}
	}

}
