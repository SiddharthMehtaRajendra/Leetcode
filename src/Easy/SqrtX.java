// https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/24025178#overview

package Easy;

public class SqrtX {
	class Solution {
		public int mySqrt(int x) {
			if (x < 2)
				return x;
			int left = 0, right = x;
			int result = -1;
			while (left <= right) {
				int mid = left + (right - left) / 2;
				long product = (long) mid * (long) mid;
				if (product == x) {
					return mid;
				} else if (product < x) {
					result = mid;
					left = mid + 1;
				} else if (product > x) {
					right = mid - 1;
				}
			}
			return result;
		}
	}
}
