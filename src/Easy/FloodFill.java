// https://www.youtube.com/watch?v=TClRuEZ-uDg

package Easy;

public class FloodFill {
	class Solution {
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
			if (image == null || image.length == 0 || image[sr][sc] == newColor) {
				return image;
			}
			this.floodFill(image, sr, sc, image[sr][sc], newColor);
			return image;
		}

		private void floodFill(int[][] image, int i, int j, int originalColor, int newColor) {
			if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != originalColor) {
				return;
			}

			image[i][j] = newColor;
			for (int[] dir : this.dirs) {
				int r = i + dir[0];
				int c = j + dir[1];
				this.floodFill(image, r, c, originalColor, newColor);
			}
		}
	}
}
