package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
	
	// https://www.youtube.com/watch?v=tGw5GbDekTU
	class Solution {
	    public int leastInterval(char[] tasks, int n) {
	        if(tasks == null || tasks.length == 0) return 0;
	        int[] frequencyMap = new int[26];
	        
	        for(char task: tasks){
	            frequencyMap[task - 'A']++;
	        }
	        
	        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
	        for(int i = 0; i < 26; i++){
	            if(frequencyMap[i] > 0){
	                pq.offer(frequencyMap[i]);
	            }
	        }
	        
	        int cycles = 0;
	        while(!pq.isEmpty()){
	            List<Integer> temp = new ArrayList<>();
	            for(int i = 0; i < n + 1; i++){
	                if(!pq.isEmpty()){
	                    temp.add(pq.poll() - 1);
	                }
	            }
	            if(!temp.isEmpty()){
	                for(int i : temp){
	                    if(i > 0) pq.offer(i);
	                }
	            }
	            cycles += pq.isEmpty() ? temp.size() : n + 1;
	        }
	        return cycles;
	    }
	}
	
	// SMART Solution (Mathematical)
	// https://www.youtube.com/watch?v=Z2Plc8o1ld4
	class SmartSolution {
	    public int leastInterval(char[] tasks, int n) {
	        if(tasks == null || tasks.length == 0) return 0;
	        int[] frequencyMap = new int[26];
	        int max_freq = 0;
	        
	        for(char task: tasks){
	            frequencyMap[task - 'A']++;
	            max_freq = Math.max(max_freq, frequencyMap[task - 'A']);
	        }
	        
	        int max_freq_count = 0;
	        for(int i = 0; i < 26; i++){
	            if(frequencyMap[i] == max_freq){
	                max_freq_count++;
	            }
	        }
	        return Math.max(tasks.length, (max_freq - 1) * (n + 1) + max_freq_count);
	    }
	}
}
