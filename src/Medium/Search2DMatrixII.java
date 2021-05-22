// https://www.youtube.com/watch?v=Ohke9-qwAKU

package Medium;

public class Search2DMatrixII {
	class Solution {
		public boolean searchMatrix(int[][] matrix, int target) {
			if (matrix == null || matrix.length == 0)
				return false;
			int m = matrix.length;
			int n = matrix[0].length;
			int r = 0, c = n - 1;

			while (r < m && c >= 0) {
				if (matrix[r][c] == target)
					return true;
				if (matrix[r][c] > target) {
					c--;
				} else {
					r++;
				}
			}
			return false;
		}
	}
}
