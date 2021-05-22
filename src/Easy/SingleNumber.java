// Leetcode Solutions, Approach 4

package Easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

	class NaiveSolution {
		public int singleNumber(int[] nums) {
			Map<Integer, Integer> cache = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				cache.put(nums[i], cache.getOrDefault(nums[i], 0) + 1);
			}
			for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
				if (entry.getValue() == 1)
					return entry.getKey();
			}
			return -1;
		}
	}

	class OptimalSolution {
		public int singleNumber(int[] nums) {
			int result = 0;
			for (int num : nums) {
				result ^= num;
			}
			return result;
		}
	}
}
