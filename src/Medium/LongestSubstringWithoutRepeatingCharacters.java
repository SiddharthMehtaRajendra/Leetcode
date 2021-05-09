package Medium;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
	class BruteForceSolution {
	    public int lengthOfLongestSubstring(String s) {
	        if(s == null || s.length() == 0) return 0;
	        int a = 0, b = 0;
	        int max = 1;
	        
	        for(int i = 0; i < s.length(); i++){
	            HashSet<Character> set = new HashSet<>();
	            set.add(s.charAt(i));
	            for(int j = i + 1; j < s.length(); j++){
	                if(!set.contains(s.charAt(j))){
	                    set.add(s.charAt(j));
	                    max = Math.max(max, j - i + 1);
	                } else {
	                    break;
	                }
	            }
	        }
	        return max;
	    }
	}
	
	class OptimizedSolution {
	    public int lengthOfLongestSubstring(String s) {
	        if(s == null || s.length() == 0) return 0;
	        int a = 0, b = 0;
	        int max = Integer.MIN_VALUE;
	        HashSet<Character> set = new HashSet<>();
	        
	        while(b < s.length()){
	            if(!set.contains(s.charAt(b))){
	                set.add(s.charAt(b));
	                b++;
	            } else {
	                set.remove(s.charAt(a));
	                a++;
	            }
	            max = Math.max(set.size(), max);
	        }
	        
	        return max;
	    }
	}
}
