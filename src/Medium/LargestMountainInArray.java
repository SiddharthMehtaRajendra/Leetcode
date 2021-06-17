// https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/24429154#overview

package Medium;

public class LargestMountainInArray {
	class Solution {
		public int longestMountain(int[] arr) {
			if (arr == null || arr.length == 0)
				return 0;
			int largest = 0;

			for (int i = 1; i < arr.length - 1;) {
				if ((arr[i] > arr[i - 1]) && (arr[i] > arr[i + 1])) {
					int j = i;
					int cnt = 1;

					while (j >= 1 && arr[j] > arr[j - 1]) {
						cnt++;
						j--;
					}
					while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
						i++;
						cnt++;
					}
					largest = Math.max(largest, cnt);
				} else {
					i++;
				}
			}
			return largest;
		}
	}
}
