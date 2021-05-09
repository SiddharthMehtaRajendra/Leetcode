// https://www.youtube.com/watch?v=NfzTWnFOeYw
package Medium;

public class SumOfTwoNumbers {
	class Solution {
	    public int getSum(int a, int b) {
	        while(b != 0){
	            int answer = a ^ b;
	            int carry = (a & b) << 1;
	            a = answer;
	            b = carry;
	        }
	        return a;
	    }
	}
}
