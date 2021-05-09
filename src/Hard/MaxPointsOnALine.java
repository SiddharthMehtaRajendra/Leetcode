package Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxPointsOnALine {
	class Solution {
	    public int maxPoints(int[][] points) {
	        int n = points.length;
	        if(n < 2) return n;
	        
	        Set<String> set = new HashSet<>();
	        int max = 1;
	        
	        for(int i = 0; i < n; i++){
	            if(!set.contains(points[i][0] + "-" + points[i][1])){
	                int[] curr = points[i];
	                int same = 0;
	                int localMax = 1;
	                Map<Double, Integer> map = new HashMap<>();
	                for(int j = i + 1; j < n; j++){
	                    if(this.isSame(curr, points[j])){
	                        same++;
	                        continue;
	                    }
	                    double slope = this.getSlope(curr, points[j]);
	                    map.put(slope, map.getOrDefault(slope, 1) + 1);
	                    localMax = Math.max(localMax, map.get(slope));
	                }
	                max = Math.max(max, localMax + same);
	                set.add(curr[0] + "-" + curr[1]);
	            }
	        }
	        return max;
	    }
	    
	    private boolean isSame(int[] a, int[] b){
	        return a[0] == b[0] && a[1] == b[1];
	    }
	    
	    private double getSlope(int[] a, int[] b){
	        if(a[0] == b[0]) return Double.MAX_VALUE;
	        if(a[1] == b[1]) return 0;
	        return ((double) a[0] - b[0]) / ((double) a[1] - b[1]);
	    }
	}
}
