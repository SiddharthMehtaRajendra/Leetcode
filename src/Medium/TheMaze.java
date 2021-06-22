// https://www.youtube.com/watch?v=vnHCC0x6yDg

package Medium;

import java.util.Arrays;

public class TheMaze {
	class Solution {
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		public boolean hasPath(int[][] maze, int[] start, int[] destination) {
			if (maze == null || maze.length == 0)
				return false;
			if (Arrays.equals(start, destination))
				return true;
			return this.dfs(maze, start[0], start[1], destination);
		}

		private boolean dfs(int[][] maze, int i, int j, int[] destination) {
			if (i == destination[0] && j == destination[1])
				return true;
			if (maze[i][j] == 2)
				return false;

			maze[i][j] = 2;
			for (int[] dir : dirs) {
				int r = i + dir[0];
				int c = j + dir[1];
				while (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] != 1) {
					r += dir[0];
					c += dir[1];
				}
				if (this.dfs(maze, r - dir[0], c - dir[1], destination)) {
					return true;
				}
			}
			return false;
		}
	}
}
