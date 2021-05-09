package Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateNumber {
	class NaiveSolution {
		public int findDuplicate(int[] nums) {
			Arrays.sort(nums);
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] == nums[i - 1])
					return nums[i];
			}
			return -1;
		}
	}
	
	class BetterSolution {
	    public int findDuplicate(int[] nums) {
	        if(nums == null || nums.length == 0) return -1;
	        Set<Integer> set = new HashSet<>();
	        for(int i = 0; i < nums.length; i++){
	            if(set.contains(nums[i])) return nums[i];
	            set.add(nums[i]);
	        }
	        return -1;
	    }
	}
	
	class OptimalSolution {
	    public int findDuplicate(int[] nums) {
	        int slow = nums[0];
	        int fast = nums[0];
	        
	        do {
	            slow = nums[slow];
	            fast = nums[nums[fast]];
	        } while(slow != fast);
	        
	        fast = nums[0];
	        while(slow != fast){
	            slow = nums[slow];
	            fast = nums[fast];
	        }
	        return slow;
	    }
	}
}
