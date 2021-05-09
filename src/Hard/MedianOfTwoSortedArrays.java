package Hard;

public class MedianOfTwoSortedArrays {
	class OptimizedSolution {
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			if (nums1 == null && nums2 == null)
				return (double) 0.0;

			if (nums1.length > nums2.length) {
				int[] temp = nums1;
				nums1 = nums2;
				nums2 = temp;
			}

			int n1 = nums1.length;
			int n2 = nums2.length;
			int lo = 0, hi = n1;

			while (lo <= hi) {
				int partX = (lo + hi) / 2;
				int partY = (n1 + n2 + 1) / 2 - partX;

				int leftX = (partX == 0) ? Integer.MIN_VALUE : nums1[partX - 1];
				int leftY = (partY == 0) ? Integer.MIN_VALUE : nums2[partY - 1];
				int rightX = (partX == n1) ? Integer.MAX_VALUE : nums1[partX];
				int rightY = (partY == n2) ? Integer.MAX_VALUE : nums2[partY];

				if (leftX <= rightY && leftY <= rightX) {
					if ((n1 + n2) % 2 == 0) {
						return (double) (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2;
					} else {
						return (double) (Math.max(leftX, leftY));
					}
				} else if (leftX > rightY) {
					hi = partX - 1;
				} else {
					lo = partX + 1;
				}
			}
			return -1;
		}
	}
}
