package Hard;

public class TrappingRainWater {

	class BruteForceSolution {
		public int trap(int[] height) {
			if (height == null || height.length == 0)
				return 0;
			int result = 0;

			for (int i = 0; i < height.length; i++) {
				int leftMax = 0;
				int rightMax = 0;
				for (int j = i; j >= 0; j--) {
					leftMax = Math.max(leftMax, height[j]);
				}
				for (int k = i; k < height.length; k++) {
					rightMax = Math.max(rightMax, height[k]);
				}
				result += Math.min(leftMax, rightMax) - height[i];
			}
			return result;
		}
	}

	class OptimizedSolution {
		public int trap(int[] height) {
			if (height == null || height.length == 0)
				return 0;
			int result = 0;
			int leftWall = 0, rightWall = 0;
			int left = 0, right = height.length - 1;
			while (left <= right) {
				if (leftWall < rightWall) {
					if (leftWall < height[left]) {
						leftWall = height[left];
					} else {
						result += leftWall - height[left];
					}
					left++;
				} else {
					if (rightWall < height[right]) {
						rightWall = height[right];
					} else {
						result += rightWall - height[right];
					}
					right--;
				}
			}
			return result;
		}
	}
}
