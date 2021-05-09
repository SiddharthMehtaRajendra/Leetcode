package Medium;

public class KthSmallestElementInSortedMatrix {
	class Solution {
		public int kthSmallest(int[][] matrix, int k) {
			int n = matrix.length;
			if (n == 1)
				return matrix[0][0];
			else if (k == n * n)
				return matrix[n - 1][n - 1];
			else if (k == 1)
				return matrix[0][0];

			int low = 0;
			int high = matrix[n - 1][n - 1];

			while (low < high) {
				int mid = low + (high - low) / 2;
				int count = this.getCountOfSmallerElements(matrix, mid);
				if (count < k) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}
			return low;
		}

		public int getCountOfSmallerElements(int[][] matrix, int mid) {
			int count = 0;
			int j = matrix.length - 1;
			for (int i = 0; i < matrix.length; i++) {
				while (j >= 0 && matrix[i][j] > mid)
					j--;
				count += j + 1;
			}
			return count;
		}
	}
}
