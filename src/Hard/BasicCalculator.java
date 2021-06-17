// Leetcode Solutions

package Hard;

import java.util.Stack;

public class BasicCalculator {
	class Solution {
	    public int calculate(String s) {
	        if(s == null || s.length() == 0) return 0;
	        Stack<Integer> st = new Stack<>();
	        int operand = 0, sign = 1, result = 0;
	               
	        for(char ch: s.toCharArray()){
	            if(Character.isDigit(ch)){
	                operand = 10 * operand + (ch - '0');
	            } else if(ch == '+'){
	                result += sign * operand;
	                sign = 1;
	                operand = 0;
	            } else if(ch == '-'){
	                result += sign * operand;
	                sign = -1;
	                operand = 0;
	            } else if(ch == '('){
	                st.push(result);
	                st.push(sign);
	                sign = 1;
	                result = 0;
	                operand = 0;
	            } else if(ch == ')'){
	                result += sign * operand;
	                result *= st.pop();
	                result += st.pop();
	                operand = 0;
	            }
	        }
	        return result + sign * operand;
	    }
	}
}
