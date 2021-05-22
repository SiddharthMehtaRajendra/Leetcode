// https://www.youtube.com/watch?v=QNTSidSXkkk

package Medium;

public class DeleteAndEarn {
	class Solution {
		public int deleteAndEarn(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			int max = Integer.MIN_VALUE;

			for (int num : nums) {
				max = Math.max(max, num);
			}

			int[] dp = new int[max + 1];

			for (int num : nums) {
				dp[num] += num;
			}

			int skip = 0;
			int take = 0;
			for (int i = 0; i < dp.length; i++) {
				int curr_skip = Math.max(skip, take);
				int curr_take = dp[i] + skip;
				skip = curr_skip;
				take = curr_take;
			}

			return Math.max(skip, take);
		}
	}
}
