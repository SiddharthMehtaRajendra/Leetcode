package Easy;

public class MaxProductOfThreeNumbers {
	
	class Solution {
		public int maximumProduct(int[] nums) {
			if (nums == null || nums.length < 3)
				return 0;

			int highest = Math.max(nums[0], nums[1]);
			int lowest = Math.min(nums[0], nums[1]);

			int highestProductOfTwo = nums[0] * nums[1];
			int lowestProductOfTwo = nums[0] * nums[1];

			int highestProductOfThree = nums[0] * nums[1] * nums[2];

			for (int i = 2; i < nums.length; i++) {
				int current = nums[i];

				highestProductOfThree = Math.max(Math.max(highestProductOfThree, current * highestProductOfTwo),
						current * lowestProductOfTwo);

				highestProductOfTwo = Math.max(Math.max(highestProductOfTwo, current * highest), current * lowest);
				lowestProductOfTwo = Math.min(Math.min(lowestProductOfTwo, current * highest), current * lowest);

				highest = Math.max(highest, current);
				lowest = Math.min(lowest, current);
			}

			return highestProductOfThree;
		}
	}
}
