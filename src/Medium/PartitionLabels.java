// Tweaked a bit from https://www.youtube.com/watch?v=ED4ateJu86I

package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartitionLabels {
	class Solution {
	    public List<Integer> partitionLabels(String s) {
	        if(s == null || s.isEmpty()) return Collections.emptyList();
	        List<Integer> partitions = new ArrayList<>();
	        int[] lastIndexes = new int[26];
	        
	        for(int i = 0; i < s.length(); i++){
	            lastIndexes[s.charAt(i) - 'a'] = i;
	        }
	        
	        for(int i = 0; i < s.length();){
	            int end = lastIndexes[s.charAt(i) - 'a'];
	            int j = i;
	            while(j != end){
	                end = Math.max(end, lastIndexes[s.charAt(++j) - 'a']);
	            }
	            partitions.add(j - i + 1);
	            i = j + 1;
	        }
	        return partitions;
	    }
	}
}
