// https://www.youtube.com/watch?v=_DtZIPUt8jo, Leetcode Solutions

package Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
	class Solution {
	    public int[][] reconstructQueue(int[][] people) {
	        if(people == null || people.length == 0) return null;
	        Arrays.sort(people, new Comparator<int[]>(){
	            public int compare(int[] a, int[] b){
	                return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
	            }
	        });
	        
	        List<int[]> output = new LinkedList<>();
	        for(int[] person: people){
	            output.add(person[1], person);
	        }
	        
	        return output.toArray(new int[people.length][2]);
	    }
	}
}
