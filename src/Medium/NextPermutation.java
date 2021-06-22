// Leetcode Solutions 
// https://www.youtube.com/watch?v=LuLCLgMElus

package Medium;

public class NextPermutation {
	class Solution {
	    public void nextPermutation(int[] nums) {
	        if(nums == null || nums.length < 2) return;
	        int i = nums.length - 2;
	        while(i > -1 && nums[i] >= nums[i + 1]) i--;
	        
	        if(i > -1){
	            int k = nums.length - 1;
	            while(nums[k] <= nums[i]) k--;
	            this.swap(nums, i, k);
	        }
	        this.reverse(nums, i + 1, nums.length - 1);
	    }
	    
	    private void swap(int[] nums, int i, int j){
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	    
	    private void reverse(int[] nums, int low, int high){
	        while(low < high){
	            this.swap(nums, low, high);
	            low++; high--;
	        }
	    }
	}
}
