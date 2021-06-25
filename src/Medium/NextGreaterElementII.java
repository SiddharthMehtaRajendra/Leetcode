// Leetcode Solutions Approach 3

package Medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
	class Solution {
		public int[] nextGreaterElements(int[] nums) {
			if (nums == null || nums.length == 0)
				;
			Stack<Integer> st = new Stack<>();
			int n = nums.length;
			int[] result = new int[nums.length];
			Arrays.fill(result, -1);

			for (int i = n - 1; i >= 0; i--) {
				while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
					st.pop();
				}
				if (!st.isEmpty()) {
					result[i] = nums[st.peek()];
				}
				st.push(i);
			}

			for (int i = n - 1; i >= 0; i--) {
				while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
					st.pop();
				}
				if (!st.isEmpty()) {
					result[i] = nums[st.peek()];
				}
				st.push(i);
			}

			return result;
		}
	}
}
