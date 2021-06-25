// https://www.youtube.com/watch?v=PuIqNH-qUPI

package Medium;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
	class Solution {
	    
	    class Function{
	        private int id;
	        private int time;
	        
	        public Function(int id, int time){
	            this.id = id;
	            this.time = time;
	        }
	        
	        public int getId(){
	            return this.id;
	        }
	        
	        public int getTime(){
	            return this.time;
	        }
	    }
	    
	    public int[] exclusiveTime(int n, List<String> logs) {
	        if(logs == null || logs.isEmpty()) return new int[]{0};
	        Stack<Function> st = new Stack<>();
	        int[] result = new int[n];
	        
	        for(String log: logs){
	            String[] temp = log.split(":");
	            int curr_id = Integer.parseInt(temp[0]);
	            int curr_time = Integer.parseInt(temp[2]);
	            if(temp[1].equals("start")){
	                st.push(new Function(curr_id, curr_time));
	            } else {
	                Function function = !st.isEmpty() ? st.pop() : null;
	                if(function != null){
	                    int time_elapsed = curr_time - function.getTime() + 1;
	                    result[function.getId()] += time_elapsed;
	                    if(!st.isEmpty()){
	                        result[st.peek().getId()] -= time_elapsed;
	                    }
	                }
	            }
	        }
	        return result;
	    }
	}
}
