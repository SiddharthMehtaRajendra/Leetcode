// https://www.youtube.com/watch?v=fdCwMdXIpw0

package Medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	class Solution {
		List<List<Integer>> result = new ArrayList<>();

		public List<List<Integer>> subsets(int[] nums) {
			if (nums == null || nums.length == 0)
				return result;
			this.backtrack(nums, 0, new ArrayList<>());
			return this.result;
		}

		private void backtrack(int[] nums, int index, List<Integer> curr) {
			result.add(new ArrayList<>(curr));
			for (int i = index; i < nums.length; i++) {
				curr.add(nums[i]);
				this.backtrack(nums, i + 1, curr);
				curr.remove(curr.size() - 1);
			}
		}
	}
}
