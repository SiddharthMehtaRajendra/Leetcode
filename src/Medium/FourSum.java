// Own solution :)

package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourSum {
	class Solution {
		public List<List<Integer>> fourSum(int[] nums, int target) {
			Map<Integer, List<int[]>> map = new HashMap<>();
			Set<List<Integer>> result = new HashSet<>();

			for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j < nums.length; j++) {
					if (i != j) {
						int twoSum = nums[i] + nums[j];
						if (!map.containsKey(twoSum)) {
							map.put(twoSum, new LinkedList<>());
						}
						map.get(twoSum).add(new int[] { i, j });
					}
				}
			}

			for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j < nums.length; j++) {
					if (i != j) {
						int twoSum = target - (nums[i] + nums[j]);
						if (map.containsKey(twoSum)) {
							for (int[] coords : map.get(twoSum)) {
								if (i == coords[0] || i == coords[1] || j == coords[0] || j == coords[1])
									break;
								List<Integer> temp = Arrays.asList(nums[coords[0]], nums[coords[1]], nums[i], nums[j]);
								Collections.sort(temp);
								result.add(temp);
							}
						}
					}
				}
			}
			return new ArrayList<>(result);
		}
	}

}
