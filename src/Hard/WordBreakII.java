// https://www.youtube.com/watch?v=hRqJJF2j3To

package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
	class Solution {
	    Set<String> wordSet;
	    Map<String, List<String>> memo;
	    public List<String> wordBreak(String s, List<String> wordDict) {
	        if(s == null || s.length() == 0 || wordDict.isEmpty()) return new ArrayList<>();
	        this.wordSet = new HashSet<>(wordDict);
	        this.memo = new HashMap<>();
	        return helper(s);
	    }
	    
	    private List<String> helper(String s){
	        if(memo.containsKey(s)) return memo.get(s);
	        List<String> result = new ArrayList<>();
	        for(int i = 0; i < s.length(); i++){
	            String prefix = s.substring(0, i + 1);
	            if(wordSet.contains(prefix)){
	                if(prefix.equals(s)){
	                    result.add(prefix);
	                } else {
	                    List<String> remainingWords = helper(s.substring(i + 1));
	                    for(String word: remainingWords){
	                        result.add(prefix + " " + word);
	                    }
	                }
	            }
	        }
	        memo.put(s, result);
	        return result;
	    }
	}
}
