// https://www.youtube.com/watch?v=M1IL4hz0QrE

package Easy;

public class MajorityElement {
	
	class OptimalSolution { //Boyer Moore Majority Voting Algorithm
	    public int majorityElement(int[] nums) {
	        if(nums == null || nums.length == 0) return 0;
	        
	        int counter = 0;
	        int candidate = 0;
	        for(int i = 0; i < nums.length; i++){
	            if(counter == 0){
	                candidate = nums[i];
	            }
	            if(candidate == nums[i]){
	                counter++;
	            } else {
	                counter--;
	            }
	        }
	        return candidate;
	    }
	}
}
