package Easy;

public class AddBinary {
	class Solution {
	    public String addBinary(String a, String b) {
	        if(a == null || b == null) return "";
	        StringBuilder sb = new StringBuilder();
	        
	        int i = a.length() - 1;
	        int j = b.length() - 1;
	        int carry = 0;
	        int sum = 0;
	        
	        while(i >= 0 || j >= 0){
	            sum = carry;
	            if(i >= 0){
	                sum += a.charAt(i--) - '0';
	            }
	            if(j >= 0){
	                sum += b.charAt(j--) - '0';
	            }
	            sb.insert(0, sum % 2);
	            carry = sum / 2;
	        }
	        
	        if(carry > 0){
	            sb.insert(0, carry);
	        }
	        return sb.toString();
	    }
	}
}
