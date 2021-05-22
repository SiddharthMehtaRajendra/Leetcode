// https://www.youtube.com/watch?v=20v8zSo2v18

package Medium;

import java.util.HashMap;

public class SubarraySumEqualsK {
	class Solution {
		public int subarraySum(int[] nums, int k) {
			if (nums == null || nums.length == 0)
				return 0;
			int result = 0;
			HashMap<Integer, Integer> counter = new HashMap<>();
			counter.put(0, 1);

			int prefixSum = 0;
			for (int i = 0; i < nums.length; i++) {
				prefixSum += nums[i];
				int subArraySum = prefixSum - k;
				if (counter.containsKey(subArraySum)) {
					result += counter.get(subArraySum);
				}
				counter.put(prefixSum, counter.getOrDefault(prefixSum, 0) + 1);
			}
			return result;
		}
	}
}
