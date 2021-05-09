package Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationsII {
	class Solution {
		Set<List<Integer>> result = new HashSet<>();

		public List<List<Integer>> permuteUnique(int[] nums) {
			if (nums == null || nums.length == 0)
				return null;
			LinkedList<Integer> decisionTree = new LinkedList<>();

			for (int num : nums) {
				decisionTree.add(num);
			}
			this.dfs(new LinkedList<>(), decisionTree);
			return new LinkedList<>(this.result);
		}

		private void dfs(List<Integer> current, List<Integer> decisionTree) {
			if (decisionTree.isEmpty()) {
				this.result.add(current);
				return;
			}

			for (Integer num : decisionTree) {
				List<Integer> tempCurr = new LinkedList<>(current);
				List<Integer> tempDt = new LinkedList<>(decisionTree);
				tempCurr.add(num);
				tempDt.remove(num);
				this.dfs(tempCurr, tempDt);
			}
		}
	}
}
