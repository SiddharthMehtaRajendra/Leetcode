// https://www.youtube.com/watch?v=5I5z7ZCPwoE

package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	class Solution {
		public int orangesRotting(int[][] grid) {
			if (grid == null || grid.length == 0)
				return -1;

			int fresh = 0;
			int minutes = 0;
			Queue<int[]> q = new LinkedList<>();
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (grid[i][j] == 2)
						q.add(new int[] { i, j });
					if (grid[i][j] == 1)
						fresh++;
				}
			}

			if (fresh == 0)
				return 0;

			int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int[] rotten = q.poll();
					for (int[] dir : dirs) {
						int r = rotten[0] + dir[0];
						int c = rotten[1] + dir[1];
						if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
							q.add(new int[] { r, c });
							grid[r][c] = 2;
							fresh--;
						}
					}
				}
				minutes++;
			}

			if (fresh > 0)
				return -1;
			return minutes > 0 ? minutes - 1 : minutes;
		}
	}
}
