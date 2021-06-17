// https://www.youtube.com/watch?v=nDLk8TxB6rc

package Medium;

public class JumpGame {
	class Solution {
		public boolean canJump(int[] nums) {
			if (nums == null || nums.length == 0)
				return true;
			int lastIndexWeCanJump = nums.length - 1;

			for (int i = nums.length - 2; i >= 0; i--) {
				if (nums[i] >= (lastIndexWeCanJump - i)) {
					lastIndexWeCanJump = i;
				}
			}

			return lastIndexWeCanJump == 0;
		}
	}
}
