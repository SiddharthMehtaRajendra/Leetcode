// Leetcode Solutions

package Hard;

public class IntegerToEnglishWords {
	class Solution {
	    public String numberToWords(int num) {
	        if(num == 0) return "Zero";
	        
	        int billion = num / 1000000000;
	        int million = (num - billion * 1000000000) / 1000000;
	        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
	        int rest = (num - billion * 1000000000 - million * 1000000 - thousand * 1000);
	        
	        StringBuilder sb = new StringBuilder();
	        
	        if(billion != 0){
	            sb.append(this.helper(billion) + " Billion");
	        }
	        if(million != 0){
	            if(!(sb.length() == 0)){
	                sb.append(" ");
	            }
	            sb.append(this.helper(million) + " Million");
	        }
	        if(thousand != 0){
	            if(!(sb.length() == 0)){
	                sb.append(" ");
	            }
	            sb.append(this.helper(thousand) + " Thousand");
	        }
	        if(rest != 0){
	           if(!(sb.length() == 0)){
	                sb.append(" ");
	            }
	            sb.append(this.helper(rest));
	        }
	        return sb.toString();
	    }
	    
	    private String helper(int number){
	        int hundred = number / 100;
	        int rest = (number - hundred * 100);
	        StringBuilder sb = new StringBuilder();
	        if(hundred != 0 && rest != 0){
	            sb.append(this.ones(hundred) + " Hundred " + this.subHelper(rest));
	        } else if(hundred != 0 && rest == 0){
	            sb.append(this.ones(hundred) + " Hundred");
	        } else if(hundred == 0 && rest != 0){
	            sb.append(this.subHelper(rest));
	        }
	        return sb.toString();
	    }
	    
	    private String subHelper(int rest){
	        if(rest < 10){
	            return this.ones(rest);
	        } else if(rest < 20){
	            return this.lessThanTwenty(rest);
	        } else {
	            int tenner = rest / 10;
	            int other = (rest - tenner * 10);
	            if(other != 0){
	                return this.tens(tenner) + " " + this.ones(other);
	            } else {
	                return this.tens(tenner);
	            }
	        }
	    }
	    
	    private String ones(int num){
	        switch(num){
	          case 1: return "One";
	          case 2: return "Two";
	          case 3: return "Three";
	          case 4: return "Four";
	          case 5: return "Five";
	          case 6: return "Six";
	          case 7: return "Seven";
	          case 8: return "Eight";
	          case 9: return "Nine";
	        }
	        return "";
	    }
	    
	    private String lessThanTwenty(int num) {
	        switch(num) {
	          case 10: return "Ten";
	          case 11: return "Eleven";
	          case 12: return "Twelve";
	          case 13: return "Thirteen";
	          case 14: return "Fourteen";
	          case 15: return "Fifteen";
	          case 16: return "Sixteen";
	          case 17: return "Seventeen";
	          case 18: return "Eighteen";
	          case 19: return "Nineteen";
	        }
	        return "";
	    }
	    
	    public String tens(int num) {
	        switch(num) {
	          case 2: return "Twenty";
	          case 3: return "Thirty";
	          case 4: return "Forty";
	          case 5: return "Fifty";
	          case 6: return "Sixty";
	          case 7: return "Seventy";
	          case 8: return "Eighty";
	          case 9: return "Ninety";
	        }
	        return "";
	    }
	}
}
