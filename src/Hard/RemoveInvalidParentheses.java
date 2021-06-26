package Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class RemoveInvalidParentheses {
	
	//Getting TLE: https://www.youtube.com/watch?v=Cbbf5qe5stw
	class Solution {
	    HashSet<String> set = new HashSet<>();
	    
	    public List<String> removeInvalidParentheses(String s) {
	        if(s == null || s.length() == 0) return Collections.emptyList();
	        int minRemovals = this.getMinRemovals(s);
	        this.backtrack(s, minRemovals);
	        return new ArrayList<>(set);
	    }
	    
	    public void backtrack(String s, int minRemovals){
	        if(minRemovals == 0){
	            boolean isValid = this.getMinRemovals(s) == 0;
	            if(isValid){
	                if(!set.contains(s)){
	                    set.add(s);
	                }
	            }
	            return;
	        }
	        
	        for(int i = 0; i < s.length(); i++){
	            String left = s.substring(0, i);
	            String right = s.substring(i + 1);
	            this.backtrack(left + right, minRemovals - 1);
	        }
	    }
	    
	    public int getMinRemovals(String s){
	        Stack<Character> st = new Stack<>();
	        for(char c: s.toCharArray()){
	            if(c == '('){
	                st.push(c);
	            } else if (c == ')') {
	                if(st.isEmpty() || st.peek() == ')'){
	                    st.push(c);
	                } else if(st.peek() == '('){
	                    st.pop();
	                }
	            }
	        }
	        return st.size();
	    }
	}
	
	// S30 BFS Technique: https://www.youtube.com/watch?v=oROEp4bs4Q4
	
	class WorkingSolution {
	    public List<String> removeInvalidParentheses(String s) {
	        if(s == null || s.length() == 0) return Collections.emptyList();
	        return this.breadthFirstSearch(s);
	    }
	    
	    private List<String> breadthFirstSearch(String s){
	        Queue<String> q = new LinkedList<>();
	        List<String> result = new ArrayList<>();
	        HashSet<String> set = new HashSet<>();
	        q.add(s);
	        boolean isValid = false;
	        int count = 0;
	        while(!q.isEmpty()){
	            String curr = q.poll();
	            if(this.isValidParentheses(curr)){
	                isValid = true;
	                result.add(curr);
	            }
	            if(!isValid){
	                for(int i = 0; i < curr.length(); i++){
	                    if(Character.isLetterOrDigit(curr.charAt(i))) continue;
	                    String temp = curr.substring(0, i) + curr.substring(i + 1);
	                    if(!set.contains(temp)){
	                        q.add(temp);
	                        set.add(temp);
	                    }
	                }
	            }
	        }
	        return result;
	    }
	    
	    private boolean isValidParentheses(String s){
	        int left = 0; int count = 0;
	        while(left < s.length()){
	            if(s.charAt(left) == '(') count++;
	            else if(s.charAt(left) == ')') count--;
	            if(count < 0) break;
	            left++;
	        }
	        return count == 0;
	    }
	}
}
