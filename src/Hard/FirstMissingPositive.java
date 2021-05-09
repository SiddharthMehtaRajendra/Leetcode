package Hard;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
	class BruteForceSolution {
	    public int firstMissingPositive(int[] nums) {
	        if(nums == null || nums.length == 0) return 1;
	        Set<Integer> set = new HashSet<>();
	        for(int i = 0; i < nums.length; i++){
	            set.add(nums[i]);
	        }
	        for(int i = 1; i <= nums.length + 1; i++){
	            if(!set.contains(i)) return i;
	        }
	        return 1;
	    }
	}
	
	class OptimizedSolution {
	    public int firstMissingPositive(int[] nums) {
	        if(nums == null || nums.length == 0) return 1;
	        int size = nums.length;
	        boolean containsOne = false;
	        
	        for(int i = 0; i < size; i++){
	            if(nums[i] == 1){
	                containsOne = true;
	            } else if(nums[i] <= 0 || nums[i] > size){
	                nums[i] = 1;
	            }
	        }
	        
	        if(!containsOne) return 1;
	        
	        for(int i = 0; i < size; i++){
	            int index = Math.abs(nums[i]) - 1;
	            if(nums[index] > 0){
	                nums[index] *= -1;
	            }
	        }
	        
	        for(int i = 0; i < size; i++){
	            if(nums[i] > 0) return i + 1;
	        }
	        
	        return size + 1;
	    }
	}
}
