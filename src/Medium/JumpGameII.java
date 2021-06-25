// https://www.youtube.com/watch?v=dJ7sWiOoK7g

package Medium;

public class JumpGameII {
	class Solution {
		public int jump(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			int result = 0;
			int left = 0, right = 0;
			while (right < nums.length - 1) {
				int farthest = 0;
				for (int i = left; i <= right; i++) {
					farthest = Math.max(farthest, i + nums[i]);
				}
				left = right + 1;
				right = farthest;
				result++;
			}
			return result;
		}
	}
}
