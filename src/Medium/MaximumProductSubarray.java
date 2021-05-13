// https://www.youtube.com/watch?v=keVevSvaDKo

package Medium;

public class MaximumProductSubarray {
	class Solution {
		public int maxProduct(int[] nums) {
			if (nums == null)
				return 0;
			int max = nums[0], currMax = nums[0], currMin = nums[0];

			for (int i = 1; i < nums.length; i++) {
				int choice1 = currMax * nums[i];
				int choice2 = currMin * nums[i];
				currMax = Math.max(Math.max(choice1, choice2), nums[i]);
				currMin = Math.min(Math.min(choice1, choice2), nums[i]);
				max = Math.max(max, currMax);
			}
			return max;
		}
	}
}
