// https://www.youtube.com/watch?v=-FEeaf3ufIE

package Medium;

public class DiagonalTraverse {
	class Solution {
		public int[] findDiagonalOrder(int[][] mat) {
			if (mat == null || mat.length == 0)
				return new int[] { 0 };
			int m = mat.length;
			int n = mat[0].length;

			int[] result = new int[m * n];

			int r = 0, c = 0;
			for (int i = 0; i < result.length; i++) {
				result[i] = mat[r][c];
				if ((r + c) % 2 == 0) {
					if (c == n - 1 && r < m - 1) {
						r++;
					} else if (r == 0 && c < n - 1) {
						c++;
					} else {
						r--;
						c++;
					}
				} else {
					if (c == 0 && r < m - 1) {
						r++;
					} else if (r == m - 1 && c < n - 1) {
						c++;
					} else {
						r++;
						c--;
					}
				}
			}
			return result;
		}
	}
}
