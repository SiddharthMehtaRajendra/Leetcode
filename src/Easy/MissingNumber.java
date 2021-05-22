package Easy;

public class MissingNumber {
	class Solution {
		public int missingNumber(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			int n = nums.length;
			int sum = (n * (n + 1)) / 2;
			int currSum = 0;
			for (int num : nums) {
				currSum += num;
			}
			return sum - currSum;
		}
	}
}
