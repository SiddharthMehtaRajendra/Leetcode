// https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/25191994#overview

package Medium;

public class ShortestUnsortedContinuousSubarray {
	class Solution {
		public int findUnsortedSubarray(int[] nums) {
			if (nums == null || nums.length < 2)
				return 0;
			int smallest = Integer.MAX_VALUE;
			int largest = Integer.MIN_VALUE;

			for (int i = 0; i < nums.length; i++) {
				if (this.isOutOfOrder(nums, i)) {
					smallest = Math.min(smallest, nums[i]);
					largest = Math.max(largest, nums[i]);
				}
			}

			if (smallest == Integer.MAX_VALUE)
				return 0;

			int left = 0, right = nums.length - 1;
			while (smallest >= nums[left] && left < right) {
				left++;
			}
			while (largest <= nums[right] && right > left) {
				right--;
			}

			return right - left + 1;
		}

		private boolean isOutOfOrder(int[] nums, int i) {
			int curr = nums[i];
			if (i == 0) {
				return curr > nums[i + 1];
			}
			if (i == nums.length - 1) {
				return curr < nums[i - 1];
			}
			return curr < nums[i - 1] || curr > nums[i + 1];
		}
	}
}
