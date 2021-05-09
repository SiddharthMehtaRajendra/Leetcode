// https://www.youtube.com/watch?v=lsQTYlCiU6c

package Hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
	class Solution {
		public int largestRectangleArea(int[] heights) {
			if (heights == null || heights.length == 0)
				return -1;

			Stack<Integer> pStack = new Stack<>();
			Stack<Integer> hStack = new Stack<>();
			int maxArea = 0;

			for (int i = 0; i < heights.length; i++) {
				int lastWidth = Integer.MAX_VALUE;

				while (!hStack.isEmpty() && heights[i] < hStack.peek()) {
					lastWidth = pStack.peek();
					int currWidth = i - pStack.pop();
					int currHeight = hStack.pop();
					maxArea = Math.max(maxArea, currWidth * currHeight);
				}

				if (hStack.isEmpty() || heights[i] > hStack.peek()) {
					hStack.push(heights[i]);
					pStack.push(Math.min(lastWidth, i));
				}
			}

			while (!hStack.isEmpty()) {
				int currArea = (heights.length - pStack.pop()) * hStack.pop();
				maxArea = Math.max(maxArea, currArea);
			}
			return maxArea;
		}
	}
}
