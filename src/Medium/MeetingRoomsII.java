// https://www.youtube.com/watch?v=qx7Akat3xrM

package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {
	
	class BruteForceSolution {
	    public int minMeetingRooms(int[][] intervals) {
	        if(intervals == null || intervals.length == 0) return 0;
	        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
	        List<Integer> list = new ArrayList<>();
	        for(int i = 0; i < intervals.length; i++){
	            list.add(intervals[i][1]);
	        }
	        for(int i = 0; i < intervals.length; i++){
	            for(int j = 0; j < list.size(); j++){
	                if(intervals[i][0] >= list.get(j)){
	                    list.remove(list.get(j));
	                    break;
	                } 
	            }
	        }
	        return list.size();
	    }
	}
	
	class OptimizedSolution {
	    public int minMeetingRooms(int[][] intervals) {
	        if(intervals == null || intervals.length == 0) return 0;
	        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
	        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (a - b));
	        pq.add(intervals[0][1]);
	        for(int i = 1; i < intervals.length; i++){
	            int currStartTime = intervals[i][0];
	            int currEndTime = pq.peek();
	            if(currStartTime >= currEndTime){
	                pq.poll();   
	            }
	            pq.offer(intervals[i][1]);
	        }
	        return pq.size();
	    }
	}
}
