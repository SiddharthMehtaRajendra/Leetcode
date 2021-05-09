package Easy;

import java.util.Arrays;

public class IntersectionOfTwoArraysII {
	class Solution {
		public int[] intersect(int[] nums1, int[] nums2) {
			int i = 0, j = 0, k = 0;
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			int maxLength = Math.max(nums1.length, nums2.length);
			int[] answer = new int[maxLength];

			while (i < nums1.length && j < nums2.length) {
				if (nums1[i] < nums2[j]) {
					i++;
				} else if (nums1[i] > nums2[j]) {
					j++;
				} else {
					answer[k++] = nums1[i++];
					j++;
				}
			}
			return Arrays.copyOfRange(answer, 0, k);
		}
	}
}
