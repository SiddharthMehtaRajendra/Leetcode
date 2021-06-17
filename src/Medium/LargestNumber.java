// Leetcode Solutions

package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	class Solution {
	    public String largestNumber(int[] nums) {
	        if(nums == null || nums.length == 0) return "0";
	        String[] strs = new String[nums.length];
	        
	        for(int i = 0; i < nums.length; i++){
	            strs[i] = String.valueOf(nums[i]);
	        }
	        
	        Arrays.sort(strs, new Comparator<String>(){
	           public int compare(String a, String b) {
	               String order1 = a + b;
	               String order2 = b + a;
	               return order2.compareTo(order1);
	           }
	        });
	        
	        if(strs[0].charAt(0) == '0'){
	            return "0";
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for(String str: strs){
	            sb.append(str);
	        }
	        
	        return sb.toString();
	    }
	}
}
