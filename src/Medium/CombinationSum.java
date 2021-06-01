// https://www.youtube.com/watch?v=yFfv03AE_vA

package Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	class Solution {
		List<List<Integer>> result = new ArrayList<>();

		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			if (candidates == null || candidates.length == 0)
				return result;
			this.backtrack(candidates, target, 0, new ArrayList<>());
			return this.result;
		}

		private void backtrack(int[] candidates, int target, int index, List<Integer> curr) {
			if (target < 0)
				return;
			if (target == 0) {
				result.add(new ArrayList<>(curr));
				return;
			}

			for (int i = index; i < candidates.length; i++) {
				curr.add(candidates[i]);
				this.backtrack(candidates, target - candidates[i], i, curr);
				curr.remove(curr.size() - 1);
			}
		}
	}
}
