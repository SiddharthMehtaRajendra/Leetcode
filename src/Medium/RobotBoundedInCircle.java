package Medium;

public class RobotBoundedInCircle {
	class Solution {
		public boolean isRobotBounded(String instructions) {
			if (instructions == null || instructions.length() == 0)
				return true;
			int currX = 0, currY = 0;
			int idx = 0;
			int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
			for (char ch : instructions.toCharArray()) {
				if (ch == 'L') {
					idx = (idx + 3) % 4;
				} else if (ch == 'R') {
					idx = (idx + 1) % 4;
				} else {
					currX += directions[idx][0];
					currY += directions[idx][1];
				}
			}
			return (currX == 0 && currY == 0) || idx != 0;
		}
	}
}
