// https://www.youtube.com/watch?v=OZaADxYTfD4 (I Modified the Approach in Video)

package Medium;

public class RemoveDuplicatesFromSortedArrayI {
	class Solution {
		public int removeDuplicates(int[] nums) {
			if (nums.length < 2)
				return nums.length;
			int idx = 1;
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] != nums[idx - 1]) {
					nums[idx++] = nums[i];
				}
			}
			return idx;
		}
	}
}
