// Leetcode Solutions

package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class MinNumberOfArrowsToBurstBalloons {
	class Solution {
		public int findMinArrowShots(int[][] points) {
			if (points == null || points.length == 0)
				return 1;
			Arrays.sort(points, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return Integer.compare(a[1], b[1]);
				}
			});

			int arrows = 1;
			int firstEnd = points[0][1];

			for (int[] point : points) {
				int currStart = point[0];
				int currEnd = point[1];

				if (firstEnd < currStart) {
					arrows++;
					firstEnd = currEnd;
				}
			}
			return arrows;
		}
	}
}
