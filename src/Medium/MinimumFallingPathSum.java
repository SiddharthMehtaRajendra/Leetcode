// https://www.youtube.com/watch?v=Xr_LRdr9IPQ

package Medium;

public class MinimumFallingPathSum {
	class Solution {
		public int minFallingPathSum(int[][] matrix) {
			if (matrix == null || matrix.length == 0)
				return 0;
			int m = matrix.length;
			int n = matrix[0].length;
			int[][] dp = new int[m][n];

			for (int i = 0; i < n; i++) {
				dp[m - 1][i] = matrix[m - 1][i];
			}

			for (int i = m - 2; i >= 0; i--) {
				for (int j = 0; j < n; j++) {
					dp[i][j] = matrix[i][j];
					int min = dp[i + 1][j];

					if (j < n - 1) {
						min = Math.min(min, dp[i + 1][j + 1]);
					}
					if (j > 0) {
						min = Math.min(min, dp[i + 1][j - 1]);
					}
					dp[i][j] += min;
				}
			}

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				min = Math.min(min, dp[0][i]);
			}
			return min;
		}
	}
}
