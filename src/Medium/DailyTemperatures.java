// https://www.youtube.com/watch?v=WGm4Kj3lhRI

package Medium;

import java.util.Stack;

public class DailyTemperatures {
	
	class Solution {
	    public int[] dailyTemperatures(int[] temperatures) {
	        if(temperatures == null || temperatures.length == 0) return new int[]{0};
	        int n = temperatures.length - 1;
	        int[] result = new int[temperatures.length];
	        Stack<Integer> st = new Stack<>();
	        
	        for(int i = n; i >= 0; i--){
	            int curr = temperatures[i];
	            while(!st.isEmpty() && temperatures[st.peek()] <= curr){
	                st.pop();
	            } 
	            result[i] = st.isEmpty() ? 0 : st.peek() - i;
	            st.push(i);
	        }
	        return result;
	    }
	}}
