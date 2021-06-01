// https://www.youtube.com/watch?v=lyLtgxUS910

package Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NearestZero01Matrix {
	class Solution {
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		public int[][] updateMatrix(int[][] mat) {
			if (mat == null || mat.length == 0)
				return mat;
			Queue<int[]> q = new LinkedList<>();
			int[][] result = new int[mat.length][mat[0].length];

			for (int i = 0; i < mat.length; i++) {
				Arrays.fill(result[i], -1);
				for (int j = 0; j < mat[0].length; j++) {
					if (mat[i][j] == 0) {
						q.offer(new int[] { i, j });
						result[i][j] = 0;
					}
				}
			}

			while (!q.isEmpty()) {
				int[] elem = q.poll();
				for (int[] dir : this.dirs) {
					int i = elem[0] + dir[0];
					int j = elem[1] + dir[1];
					if (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && result[i][j] == -1) {
						q.add(new int[] { i, j });
						result[i][j] = result[elem[0]][elem[1]] + 1;
					}
				}
			}

			return result;
		}
	}
}
