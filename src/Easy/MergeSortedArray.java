package Easy;

public class MergeSortedArray {
	class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			int ptr = m + n - 1;
			while (m > 0 && n > 0) {
				if (nums1[m - 1] > nums2[n - 1]) {
					nums1[ptr] = nums1[m - 1];
					m--;
				} else {
					nums1[ptr] = nums2[n - 1];
					n--;
				}
				ptr--;
			}

			while (m > 0) {
				nums1[ptr--] = nums1[m - 1];
				m--;
			}
			while (n > 0) {
				nums1[ptr--] = nums2[n - 1];
				n--;
			}
		}
	}
}
