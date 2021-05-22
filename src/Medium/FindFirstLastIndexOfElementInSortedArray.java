// https://www.youtube.com/watch?v=bU-q1OJ0KWw

package Medium;

public class FindFirstLastIndexOfElementInSortedArray {
	class Solution {
		public int[] searchRange(int[] nums, int target) {
			if (nums == null || nums.length == 0)
				return new int[] { -1, -1 };
			int leftIndex = this.findLeftIndex(nums, target);
			int rightIndex = this.findRightIndex(nums, target);
			return new int[] { leftIndex, rightIndex };
		}

		private int findLeftIndex(int[] nums, int target) {
			int index = -1;
			int left = 0, right = nums.length - 1;

			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (nums[mid] >= target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}

				if (nums[mid] == target)
					index = mid;
			}
			return index;
		}

		private int findRightIndex(int[] nums, int target) {
			int index = -1;
			int left = 0, right = nums.length - 1;

			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (nums[mid] <= target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
				if (nums[mid] == target)
					index = mid;
			}
			return index;
		}
	}
}
