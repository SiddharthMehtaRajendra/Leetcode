package Easy;

public class MaximumSubarray {
	class BruteForceSolution {
		public int maxSubArray(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < nums.length; i++) {
				int sum = 0;
				for (int j = i; j < nums.length; j++) {
					sum += nums[j];
					max = Math.max(max, sum);
				}
			}
			return max;
		}
	}
	
	class KadanesSolution {
	    public int maxSubArray(int[] nums) {
	        if(nums == null || nums.length == 0) return 0;
	        int localOptima = nums[0];
	        int globalOptima = nums[0];
	        
	        for(int i = 1; i < nums.length; i++){
	            localOptima = Math.max(nums[i], localOptima + nums[i]);
	            globalOptima = Math.max(globalOptima, localOptima);
	        }
	        
	        return globalOptima;
	    }
	}
}
