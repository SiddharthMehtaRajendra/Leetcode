// https://www.youtube.com/watch?v=cjWnW0hdF1Y

package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestIncreasingSubsequence {
	
	class BruteForceSolutionTLE { //O(2^n)
		public int lengthOfLIS(int[] nums) {
			return this.lengthofLIS(nums, Integer.MIN_VALUE, 0);
		}

		public int lengthofLIS(int[] nums, int prev, int curpos) {
			if (curpos == nums.length) {
				return 0;
			}
			int taken = 0;
			if (nums[curpos] > prev) {
				taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
			}
			int nottaken = lengthofLIS(nums, prev, curpos + 1);
			return Math.max(taken, nottaken);
		}
	}

	class MemoizationSolutionTLE { //O(n^2)
		Map<String, Integer> cache = new HashMap<>();

		public int lengthOfLIS(int[] nums) {
			return this.lengthofLIS(nums, Integer.MIN_VALUE, 0);
		}

		public int lengthofLIS(int[] nums, int prev, int curpos) {
			if (curpos == nums.length) {
				return 0;
			}
			if (this.cache.containsKey(prev + " " + curpos))
				return this.cache.get(prev + " " + curpos);
			int taken = 0;
			if (nums[curpos] > prev) {
				taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
			}
			int nottaken = lengthofLIS(nums, prev, curpos + 1);
			this.cache.put(prev + " " + curpos, Math.max(taken, nottaken));
			return this.cache.get(prev + " " + curpos);
		}
	}

	class DPSolutionAccepted { //O(n^2)
		public int lengthOfLIS(int[] nums) {
			int[] dp = new int[nums.length];
			Arrays.fill(dp, 1);
			int max = 1;
			for (int i = nums.length - 2; i >= 0; i--) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] < nums[j]) {
						dp[i] = Math.max(dp[i], 1 + dp[j]);
						max = Math.max(max, dp[i]);
					}
				}
			}
			return max;
		}
	}
}
