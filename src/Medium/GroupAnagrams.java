package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	class Solution {
	    public List<List<String>> groupAnagrams(String[] strs) {
	        if(strs == null || strs.length == 0) return null;
	        Map<String, List<String>> map = new HashMap<>();
	        
	        for(String str: strs){
	            char[] ch = str.toCharArray();
	            Arrays.sort(ch);
	            String sorted = String.valueOf(ch);
	            if(map.containsKey(sorted)){
	                map.get(sorted).add(str);
	            } else {
	                map.put(sorted, new ArrayList<>(Arrays.asList(str)));
	            }
	        }
	        return new ArrayList<>(map.values());
	    }
	}
}
