// https://www.youtube.com/watch?v=uvB-Ns_TVis

package Medium;

public class SortColors {
	class Solution {
		public void sortColors(int[] nums) {
			if (nums == null || nums.length == 0)
				return;
			int mid = 0, low = 0, high = nums.length - 1;

			while (mid <= high) {
				if (nums[mid] == 0) {
					this.swap(nums, mid, low);
					low++;
					mid++;
				} else if (nums[mid] == 1) {
					mid++;
				} else if (nums[mid] == 2) {
					this.swap(nums, mid, high);
					high--;
				}
			}
		}

		private void swap(int[] nums, int i, int j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
}
