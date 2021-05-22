package Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
	class Solution {
		public int evalRPN(String[] tokens) {
			if (tokens == null || tokens.length == 0)
				return 0;
			Stack<Integer> st = new Stack<>();
			Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

			for (String token : tokens) {
				if (!operators.contains(token)) {
					st.push(Integer.parseInt(token));
				} else {
					int numberTwo = st.pop();
					int numberOne = st.pop();

					switch (token) {
					case "+":
						st.push(numberOne + numberTwo);
						break;
					case "-":
						st.push(numberOne - numberTwo);
						break;
					case "*":
						st.push(numberOne * numberTwo);
						break;
					case "/":
						st.push(numberOne / numberTwo);
						break;
					}
				}
			}
			return st.pop();
		}
	}
}
