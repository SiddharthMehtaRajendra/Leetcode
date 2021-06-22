// Leetcode Solutions

package Easy;

public class FindTownJudge {
	class Solution {
		public int findJudge(int n, int[][] trust) {
			int[] indegrees = new int[n + 1];
			int[] outdegrees = new int[n + 1];

			for (int[] relation : trust) {
				indegrees[relation[1]]++;
				outdegrees[relation[0]]++;
			}

			for (int i = 1; i <= n; i++) {
				if (indegrees[i] == n - 1 && outdegrees[i] == 0) {
					return i;
				}
			}
			return -1;
		}
	}
}
