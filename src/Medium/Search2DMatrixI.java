// https://www.youtube.com/watch?v=EmpwQ4C6WJs

package Medium;

public class Search2DMatrixI {
	class Solution {
		public boolean searchMatrix(int[][] matrix, int target) {
			if (matrix == null || matrix.length == 0)
				return false;
			int rowIdx = this.binarySearchRowSelect(matrix, target);
			return this.binarySearch(matrix, rowIdx, target);
		}

		private int binarySearchRowSelect(int[][] matrix, int target) {
			int lo = 0, hi = matrix.length - 1;
			int end = matrix[0].length - 1;

			while (lo <= hi) {
				int mid = lo + (hi - lo) / 2;
				if (matrix[mid][0] <= target && target <= matrix[mid][end]) {
					return mid;
				} else if (matrix[mid][end] < target) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
			return -1;
		}

		private boolean binarySearch(int[][] matrix, int rowIdx, int target) {
			if (rowIdx == -1)
				return false;
			int lo = 0, hi = matrix[0].length - 1;

			while (lo <= hi) {
				int mid = lo + (hi - lo) / 2;
				if (matrix[rowIdx][mid] == target)
					return true;
				else if (matrix[rowIdx][mid] < target) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
			return false;
		}
	}
}
