package Medium;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

	class RecursiveNaiveSolutionTLE {
		public int rob(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			return this.helper(nums, 0, 0);
		}

		public int helper(int[] nums, int money, int pos) {
			if (pos >= nums.length)
				return money;

			int robbed = this.helper(nums, money + nums[pos], pos + 2);
			int notRobbed = this.helper(nums, money, pos + 1);
			return Math.max(robbed, notRobbed);
		}
	}

	class MemoizedSolutionPass {
		Map<String, Integer> cache = new HashMap<>();

		public int rob(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			return this.helper(nums, 0, 0);
		}

		public int helper(int[] nums, int money, int pos) {
			if (pos >= nums.length)
				return money;

			if (this.cache.containsKey(pos + " " + money))
				return this.cache.get(pos + " " + money);

			int robbed = this.helper(nums, money + nums[pos], pos + 2);
			int notRobbed = this.helper(nums, money, pos + 1);
			this.cache.put(pos + " " + money, Math.max(robbed, notRobbed));
			return this.cache.get(pos + " " + money);
		}
	}

	
	// https://www.youtube.com/watch?v=xlvhyfcoQa4
	
	class DPOptimalSolution {
		public int rob(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			else if (nums.length == 1)
				return nums[0];
			else if (nums.length == 2)
				return Math.max(nums[0], nums[1]);

			int[] dp = new int[nums.length];
			dp[0] = nums[0];
			dp[1] = Math.max(nums[0], nums[1]);

			for (int i = 2; i < nums.length; i++) {
				dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
			}

			return dp[nums.length - 1];
		}
	}
}
