// https://www.youtube.com/watch?v=SA867FvqHrM

package Medium;

public class RotateImage {
	class Solution {
		public void rotate(int[][] matrix) {
			if (matrix == null || matrix.length <= 1)
				return;
			int n = matrix.length;

			// Transpose the Matrix
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}

			// Horizontal Flip
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < (n / 2); j++) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[i][n - 1 - j];
					matrix[i][n - 1 - j] = temp;
				}
			}
		}
	}
}
