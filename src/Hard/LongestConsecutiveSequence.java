// https://www.youtube.com/watch?v=P6RZZMu_maU

package Hard;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	class Solution {
		public int longestConsecutive(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;

			Set<Integer> set = new HashSet<>();
			for (int num : nums) {
				set.add(num);
			}

			int longest = 0;
			for (int i = 0; i < nums.length; i++) {
				if (!set.contains(nums[i] - 1)) {
					int length = 0;
					while (set.contains(nums[i] + length)) {
						length++;
					}
					longest = Math.max(longest, length);
				}
			}
			return longest;
		}
	}
}
