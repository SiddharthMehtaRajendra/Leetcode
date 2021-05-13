// https://www.youtube.com/watch?v=DfljaUwZsOk

package Hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {

	class BruteForceSolution {
		public int[] maxSlidingWindow(int[] nums, int k) {
			if (nums == null || nums.length == 0 || k == 0)
				return new int[0];
			int size = nums.length;
			int output[] = new int[size - k + 1];
			int counter = 0;

			for (int i = 0; i < size - k + 1; i++) {
				int max_num = Integer.MIN_VALUE;
				for (counter = i + k - 1; counter >= i; counter--) {
					max_num = Math.max(max_num, nums[counter]);
				}
				output[counter + 1] = max_num;
			}
			return output;
		}
	}

	class DequeSolution {
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		int[] nums;

		public int[] maxSlidingWindow(int[] nums, int k) {
			if (nums == null || nums.length == 0 || k == 0)
				return new int[0];
			if (k == 1)
				return nums;
			this.nums = nums;
			int size = nums.length;

			int max_num = 0;
			for (int i = 0; i < k; i++) {
				clean_deque(i, k);
				deque.addLast(i);
				if (nums[i] > nums[max_num]) {
					max_num = i;
				}
			}
			int[] output = new int[size - k + 1];
			output[0] = nums[max_num];

			for (int i = k; i < size; i++) {
				clean_deque(i, k);
				deque.addLast(i);
				output[i - k + 1] = nums[deque.getFirst()];
			}
			return output;
		}

		private void clean_deque(int i, int k) {
			while (!deque.isEmpty() && deque.getFirst() == i - k) {
				deque.removeFirst();
			}

			while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
				deque.removeLast();
			}
		}

	}

	// https://www.youtube.com/watch?v=DfljaUwZsOk
	class DequeSolutionII {
		List<Integer> result = new ArrayList<>();

		public int[] maxSlidingWindow(int[] nums, int k) {
			if (nums == null || nums.length == 0 || k == 0)
				return new int[0];
			if (k == 1)
				return nums;

			ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
			int l = 0, r = 0;

			while (r < nums.length) {
				while (!deque.isEmpty() && nums[deque.getLast()] < nums[r]) {
					deque.removeLast();
				}
				deque.addLast(r);

				if (l > deque.getFirst()) {
					deque.removeFirst();
				}

				if (r + 1 >= k) {
					result.add(nums[deque.getFirst()]);
					l++;
				}
				r++;
			}

			int[] res = new int[result.size()];
			for (int i = 0; i < res.length; i++) {
				res[i] = result.get(i).intValue();
			}
			return res;
		}
	}
}
