package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	class Solution {
		public int[] topKFrequent(int[] nums, int k) {
			if (nums == null || nums.length == 0 || k == nums.length)
				return nums;
			Map<Integer, Integer> counter = new HashMap<>();

			for (int n : nums) {
				counter.put(n, counter.getOrDefault(n, 0) + 1);
			}

			PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> counter.get(n1) - counter.get(n2));

			for (int n : counter.keySet()) {
				heap.offer(n);
				if (heap.size() > k)
					heap.poll();
			}

			int[] result = new int[k];
			for (int i = 0; i < k; i++) {
				result[i] = heap.poll();
			}
			return result;
		}
	}
}
