// https://www.youtube.com/watch?v=ewNE1UbjmJ8

package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
	class Solution {
	    public List<List<Integer>> palindromePairs(String[] words) {
	        List<List<Integer>> result = new ArrayList();
	        Map<String, Integer> map = new HashMap();
	        
	        for(int i = 0; i < words.length; i++){
	            map.put(words[i], i);
	        }
	        
	        if(map.containsKey("")){
	            int idx = map.get("");
	            for(int i = 0; i < words.length; i++){
	                if(idx != i && this.isPalindrome(words[i])){
	                    result.add(Arrays.asList(idx, i));
	                    result.add(Arrays.asList(i, idx));
	                }
	            }
	        }
	        
	        for(int i = 0; i < words.length; i++){
	            String curr = new StringBuilder(words[i]).reverse().toString();
	            Integer reversedIdx = map.get(curr);
	            if(reversedIdx != null && reversedIdx != i){
	                result.add(Arrays.asList(i, reversedIdx));
	            }
	        }
	        
	        for(int i = 0; i < words.length; i++){
	            String curr = words[i];
	            for(int cut = 1; cut < curr.length(); cut++){
	                String left = curr.substring(0, cut);
	                String right = curr.substring(cut);
	                if(this.isPalindrome(left)){
	                    String reversedRight = new StringBuilder(right).reverse().toString();
	                    if(map.containsKey(reversedRight)){
	                        result.add(Arrays.asList(map.get(reversedRight), i));
	                    }
	                }
	                if(this.isPalindrome(right)){
	                    String reversedLeft = new StringBuilder(left).reverse().toString();
	                    if(map.containsKey(reversedLeft)){
	                        result.add(Arrays.asList(i, map.get(reversedLeft)));
	                    }
	                }
	            }
	        }
	        return result;
	    }
	    
	    private boolean isPalindrome(String s){
	        int left = 0, right = s.length() - 1;
	        while(left < right){
	            if(s.charAt(left++) != s.charAt(right--)) return false;
	        }
	        return true;
	    }
	}
}
