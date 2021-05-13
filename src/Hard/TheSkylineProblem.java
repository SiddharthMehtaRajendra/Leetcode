// https://www.youtube.com/watch?v=GSBLe8cKu0s

package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {
	class Solution {

		class BuildingPoint implements Comparable<BuildingPoint> {
			private int x;
			private int height;
			private boolean isStart;

			public int compareTo(BuildingPoint o) {
				// first compare by x.
				// If they are same then use this logic
				// if two starts are compared then higher height building should be picked first
				// if two ends are compared then lower height building should be picked first
				// if one start and end is compared then start should appear before end

				if (this.x != o.x) {
					return this.x - o.x;
				} else {
					if (this.isStart && o.isStart) {
						return o.height - this.height;
					} else if (this.isStart || o.isStart) {
						return Boolean.compare(o.isStart, this.isStart);
					} else {
						return this.height - o.height;
					}
				}
			}
		}

		public List<List<Integer>> getSkyline(int[][] buildings) {
			if (buildings == null || buildings.length == 0)
				return new ArrayList<>();
			List<List<Integer>> result = new LinkedList<>();
			BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];

			int index = 0;
			for (int[] building : buildings) {
				buildingPoints[index] = new BuildingPoint();
				buildingPoints[index].x = building[0];
				buildingPoints[index].height = building[2];
				buildingPoints[index].isStart = true;

				buildingPoints[index + 1] = new BuildingPoint();
				buildingPoints[index + 1].x = building[1];
				buildingPoints[index + 1].height = building[2];
				buildingPoints[index + 1].isStart = false;
				index += 2;
			}
			Arrays.sort(buildingPoints);
			PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
			queue.offer(0);

			int prevMaxValue = 0;
			for (BuildingPoint buildingPoint : buildingPoints) {
				if (buildingPoint.isStart) {
					queue.offer(buildingPoint.height);
				} else {
					queue.remove(buildingPoint.height);
				}
				int currMaxValue = queue.peek();
				if (prevMaxValue != currMaxValue) {
					result.add(Arrays.asList(buildingPoint.x, currMaxValue));
					prevMaxValue = currMaxValue;
				}
			}

			return result;
		}
	}
}
