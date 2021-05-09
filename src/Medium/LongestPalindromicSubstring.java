package Medium;

public class LongestPalindromicSubstring {
	class BruteForceSolution {
	    public String longestPalindrome(String s) {
	        if(s == null || s.length() == 0) return s;
	        int max = 0;
	        String longestPalindrome = "";
	        
	        for(int i = 0; i < s.length(); i++){
	            for(int j = i; j < s.length(); j++){
	                if(isPalindrome(s.substring(i, j + 1))){
	                    if(max < (j - i + 1)){
	                        max = j - i + 1;
	                        longestPalindrome = s.substring(i, j + 1);
	                    }
	                }
	            }
	        }
	        return longestPalindrome;
	    }
	    
	    private boolean isPalindrome(String s){
	        int lo = 0, hi = s.length() - 1;
	        while(lo < hi){
	            if(s.charAt(lo) == s.charAt(hi)){
	                lo++;
	                hi--;
	            } else {
	                return false;
	            }
	        }
	        return true;
	    }
	}
	
	class OptimalSolution {
	    public String longestPalindrome(String s) {
	        if(s == null || s.length() == 0) return s;
	        int start = 0, end = 0;
	        
	        for(int i = 0; i < s.length(); i++){
	            int len1 = expandAroundCenter(s, i, i);
	            int len2 = expandAroundCenter(s, i, i + 1);
	            int len = Math.max(len1, len2);
	            if(len > (end - start)){
	                start = i - ((len - 1) / 2);
	                end = i + (len / 2);
	            }
	        }
	        return s.substring(start, end + 1);
	    }
	    
	    private int expandAroundCenter(String s, int low, int high){
	        while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
	            low--;
	            high++;
	        }
	        return high - low - 1;
	    }
	}
	
	class MySolution {
	    public String longestPalindrome(String s) {
	        if(s == null || s.length() == 0) return s;
	        int start = 0, end = 0, max = 0;
	        
	        for(int i = 0; i < s.length(); i++){
	            int[] len1 = expandAroundCenter(s, i, i);
	            int[] len2 = expandAroundCenter(s, i, i + 1);
	            if(max < len1[2]){
	                max = len1[2];
	                start = len1[0];
	                end = len1[1];
	            } 
	            if(max < len2[2]){
	                max = len2[2];
	                start = len2[0];
	                end = len2[1];
	            }
	        }
	        return s.substring(start, end + 1);
	    }
	    
	    private int[] expandAroundCenter(String s, int low, int high){
	        while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
	            low--;
	            high++;
	        }
	        return new int[]{low + 1, high - 1, high - low - 1};
	    }
	}
}
