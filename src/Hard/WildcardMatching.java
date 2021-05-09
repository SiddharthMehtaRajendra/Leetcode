package Hard;

public class WildcardMatching {
	class Solution {
		public boolean isMatch(String s, String p) {
			if ((s == null && p == null) || (s.length() == 0 && p.length() == 0))
				return true;
			int m = s.length() + 1;
			int n = p.length() + 1;
			boolean[][] dp = new boolean[m][n];
			dp[0][0] = true;

			for (int i = 1; i < n; i++) {
				if (p.charAt(i - 1) == '*') {
					dp[0][i] = dp[0][i - 1];
				}
			}

			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
						dp[i][j] = dp[i - 1][j - 1];
					} else if (p.charAt(j - 1) == '*') {
						dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
					} else {
						dp[i][j] = false;
					}
				}
			}

			return dp[m - 1][n - 1];
		}
	}
}
