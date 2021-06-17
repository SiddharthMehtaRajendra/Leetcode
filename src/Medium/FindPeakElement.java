// https://www.youtube.com/watch?v=322dz0XECKM

package Medium;

public class FindPeakElement {
	
	class NaiveSolution { // O(n)
		public int findPeakElement(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;

			int n = nums.length - 1;
			for (int i = 0; i < n; i++) {
				if (nums[i] > nums[i + 1]) {
					return i;
				}
			}
			return n;
		}
	}
	
	class OptimalSolution { // O(logn)
	    public int findPeakElement(int[] nums) {
	        if(nums == null || nums.length == 0) return 0;
	        
	        int left = 0;
	        int right = nums.length - 1;
	        
	        while(left < right){
	            int mid = left + (right - left) / 2;
	            if(nums[mid] > nums[mid + 1]){
	                right = mid;
	            } else {
	                left = mid + 1;
	            }
	        	}
	        return left;
	    }
	}
}
