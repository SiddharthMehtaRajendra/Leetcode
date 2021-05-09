package Medium;

import java.util.Arrays;

public class SortAnArray {
	class Solution {
		public int[] sortArray(int[] nums) {
			if (nums == null)
				return nums;
			return this.mergeSort(nums);
		}

		private int[] mergeSort(int[] nums) {
			if (nums.length < 2)
				return nums;
			int mid = nums.length / 2;

			int[] leftArray = Arrays.copyOfRange(nums, 0, mid);
			int[] rightArray = Arrays.copyOfRange(nums, mid, nums.length);

			leftArray = this.mergeSort(leftArray);
			rightArray = this.mergeSort(rightArray);

			return this.merge(leftArray, rightArray);
		}

		private int[] merge(int[] leftArray, int[] rightArray) {
			int lengthLeftArr = leftArray.length;
			int lengthRightArr = rightArray.length;
			int lengthMergedArr = lengthLeftArr + lengthRightArr;

			int[] mergedArray = new int[lengthMergedArr];

			int i = 0, j = 0, k = 0;

			while (i < lengthLeftArr && j < lengthRightArr) {
				if (leftArray[i] < rightArray[j]) {
					mergedArray[k++] = leftArray[i++];
				} else {
					mergedArray[k++] = rightArray[j++];
				}
			}

			while (i < lengthLeftArr) {
				mergedArray[k++] = leftArray[i++];
			}

			while (j < lengthRightArr) {
				mergedArray[k++] = rightArray[j++];
			}
			return mergedArray;
		}
	}
}
