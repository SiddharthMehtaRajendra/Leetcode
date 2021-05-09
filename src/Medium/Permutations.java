package Medium;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
	class Solution {
		List<List<Integer>> result = new LinkedList<>();

		public List<List<Integer>> permute(int[] nums) {
			if (nums == null || nums.length == 0)
				return this.result;
			LinkedList<Integer> decisionTree = new LinkedList<>();

			for (int num : nums) {
				decisionTree.add(num);
			}
			this.dfs(new LinkedList<>(), decisionTree);
			return this.result;
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
