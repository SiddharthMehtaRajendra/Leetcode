//https://www.youtube.com/watch?v=LQYYkSe_9CY

package Medium;

public class SearchInSortedArrayOfUnknownSize {

	interface ArrayReader {
		public int get(int index);
	}

	class Solution {
		public int search(ArrayReader reader, int target) {
			int left = 0, right = 2;
			while (left < right) {
				int mid = left + (right - left) / 2;
				if (reader.get(mid) < target) {
					left = mid + 1;
					right *= 2;
				} else {
					right = mid;
				}
			}
			if (reader.get(left) == target)
				return left;
			return -1;
		}
	}
}
