// https://www.youtube.com/watch?v=1WugaISSWx8

package Medium;

import java.util.HashMap;

public class ContiguousArray {
	class Solution {
		public int findMaxLength(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			int result = 0;
			HashMap<Integer, Integer> map = new HashMap<>();
			map.put(0, -1);

			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 0) {
					sum -= 1;
				} else if (nums[i] == 1) {
					sum += 1;
				}
				if (map.containsKey(sum)) {
					int idx = map.get(sum);
					int length = i - idx;
					result = Math.max(result, length);
				} else {
					map.put(sum, i);
				}
			}
			return result;
		}
	}
}
