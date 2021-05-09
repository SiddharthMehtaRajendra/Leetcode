package Medium;

public class ContainerWithMostWater {
	class NaiveSolution {
		public int maxArea(int[] height) {
			if (height == null || height.length == 0)
				return 0;
			int result = Integer.MIN_VALUE;
			for (int i = 0; i < height.length; i++) {
				for (int j = i + 1; j < height.length; j++) {
					result = Math.max(result, Math.min(height[j], height[i]) * (j - i));
				}
			}
			return result;
		}
	}

	class OptimizedSolution {
		public int maxArea(int[] height) {
			if (height == null || height.length == 0)
				return 0;
			int result = Integer.MIN_VALUE;
			int left = 0, right = height.length - 1;

			while (left < right) {
				result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
				if (height[left] < height[right])
					left++;
				else
					right--;
			}
			return result;
		}
	}
}
