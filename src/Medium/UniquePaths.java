// Leetcode Solutions

package Medium;

import java.util.Arrays;

public class UniquePaths {

	class RecursiveSolution {
		public int uniquePaths(int m, int n) {
			if (m == 1 || n == 1)
				return 1;
			return this.uniquePaths(m - 1, n) + this.uniquePaths(m, n - 1);
		}
	}

	class MemoizedSolution {
		int[][] cache;

		public int uniquePaths(int m, int n) {
			this.cache = new int[m + 1][n + 1];
			return this.helper(m, n);
		}

		private int helper(int m, int n) {
			if (m == 1 || n == 1)
				return 1;
			if (this.cache[m][n] > 0)
				return this.cache[m][n];
			this.cache[m][n] = this.helper(m - 1, n) + this.helper(m, n - 1);
			return this.cache[m][n];
		}
	}
	
	class DPSolution {
	    public int uniquePaths(int m, int n) {
	        if(m == 1 || n == 1) return 1;
	        int[][] dp = new int[m][n];
	        
	        for(int[] row: dp){
	            Arrays.fill(row, 1);
	        }
	        
	        for(int i = 1; i < m; i++){
	            for(int j = 1; j < n; j++){
	                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
	            }
	        }
	        return dp[m - 1][n - 1];
	    }
	}

}
