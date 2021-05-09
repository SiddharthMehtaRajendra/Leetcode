package Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
	class NaiveSolution {
		public int findKthLargest(int[] nums, int k) {
			if (nums == null || nums.length == 0)
				return 0;
			Arrays.sort(nums);
			return nums[nums.length - k];
		}
	}

	class OptimizedSolution {
		public int findKthLargest(int[] nums, int k) {
			if (nums == null || nums.length == 0)
				return 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
			for (int num : nums) {
				pq.offer(num);
				if (pq.size() > k) {
					pq.poll();
				}
			}
			return pq.poll();
		}
	}

	class MySolution {
		public int findKthLargest(int[] nums, int k) {
			if (nums == null || nums.length == 0)
				return 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
			for (int num : nums) {
				pq.offer(num);
			}
			while (pq.size() > (nums.length - k + 1)) {
				pq.poll();
			}
			return pq.poll();
		}
	}
}
