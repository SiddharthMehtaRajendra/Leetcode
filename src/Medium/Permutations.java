// https://www.youtube.com/watch?v=UvSPsz0jTQ4

package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
	class Solution {
	    List<List<Integer>> result = new LinkedList<>();
	    
	    public List<List<Integer>> permute(int[] nums) {
	        if(nums == null || nums.length == 0) return this.result;
	        ArrayList<Integer> decisionTree = new ArrayList<>();
	    
	        for(int num: nums){
	            decisionTree.add(num);
	        }
	        this.dfs(new ArrayList<>(), decisionTree);
	        return this.result;
	    }
	    
	    private void dfs(List<Integer> current, List<Integer> decisionTree){
	        if(decisionTree.isEmpty()){
	            this.result.add(current);
	            return;
	        }
	        
	        for(Integer num: decisionTree){
	            List<Integer> tempCurr = new ArrayList<>(current);
	            List<Integer> tempDt = new ArrayList<>(decisionTree);
	            tempCurr.add(num);
	            tempDt.remove(num);
	            this.dfs(tempCurr, tempDt);
	        }
	    }
	    
	}
}
