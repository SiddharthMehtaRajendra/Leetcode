package Medium;

public class ProductOfArrayExceptSelf {
	class Solution {
	    public int[] productExceptSelf(int[] nums) {
	        if(nums == null || nums.length == 0) return null;
	        int n = nums.length;
	        int[] productLeft = new int[n];
	        int[] productRight = new int[n];
	        
	        productLeft[0] = 1;
	        for(int i = 1; i < n; i++){
	            productLeft[i] = productLeft[i - 1] * nums[i - 1];
	        }
	        
	        productRight[n - 1] = 1;
	        for(int i = n - 2; i >= 0; i--){
	            productRight[i] = productRight[i + 1] * nums[i + 1];
	        }
	        
	        for(int i = 0; i < nums.length; i++){
	            nums[i] = productLeft[i] * productRight[i];
	        }
	        
	        return nums;
	    }
	}
	
	class OptimizedSolution {
	    public int[] productExceptSelf(int[] nums) {
	        if(nums == null || nums.length == 0) return null;
	        int n = nums.length;
	        int[] result = new int[n];
	        int rp = 1, temp = 1;
	        result[0] = 1;
	        
	        for(int i = 1; i < n; i++){
	            result[i] = result[i - 1] * nums[i - 1];
	        }
	        
	        for(int i = n - 1; i >= 0; i--){
	            rp *= temp;
	            temp = nums[i];
	            result[i] *= rp;
	        }
	        
	        return result;
	    }
	}
}
