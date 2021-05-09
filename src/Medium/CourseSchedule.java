package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
	class DFSSolution {
	    Map<Integer, List<Integer>> adjList = new HashMap<>();
	    Set<Integer> visited = new HashSet<>();
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
	        
	        for(int i = 0; i < numCourses; i++){
	            adjList.put(i, new LinkedList<>());
	        }
	        this.buildAdjacencyList(prerequisites);
	        
	        for(int course = 0; course < numCourses; course++){
	            if(!this.dfs(course)) return false;
	        }
	        return true;
	    }
	    
	    private void buildAdjacencyList(int[][] prerequisites){
	        for(int i = 0; i < prerequisites.length; i++){
	            int source = prerequisites[i][0];
	            int destination = prerequisites[i][1];
	            this.adjList.get(source).add(destination);
	        }
	    }
	    
	    private boolean dfs(int course){
	        if(this.adjList.get(course).isEmpty()) return true;
	        if(this.visited.contains(course)) return false;
	        
	        this.visited.add(course);
	        for(int neighbour: this.adjList.get(course)){    
	            if(!dfs(neighbour)) return false;
	        }
	        this.visited.remove(course);
	        this.adjList.get(course).clear();
	        return true;
	    }
	}
	
	class TopologicalSortSolution {
	    Map<Integer, List<Integer>> adjList = new HashMap<>();
	    int[] indegrees;
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
	        this.indegrees = new int[numCourses];
	        for(int i = 0; i < numCourses; i++){
	            this.adjList.put(i, new LinkedList<>());
	        }
	        Queue<Integer> queue = new LinkedList<>();
	        this.buildAdjacencyListAndIndegreesArray(prerequisites);
	        for(int i = 0; i < numCourses; i++){
	            if(this.indegrees[i] == 0) queue.add(i);
	        }
	        
	        int count = queue.size();
	        while(!queue.isEmpty()){
	            int course = queue.poll();
	            for(int neighbour: this.adjList.get(course)){
	                if(this.indegrees[neighbour] > 0) this.indegrees[neighbour]--;
	                if(this.indegrees[neighbour] == 0) {
	                    count++;
	                    queue.add(neighbour);
	                }
	            }
	        }
	        return count == numCourses;
	    }
	    
	    private void buildAdjacencyListAndIndegreesArray(int[][] prerequisites){
	        for(int i = 0; i < prerequisites.length; i++){
	            int source = prerequisites[i][0];
	            int destination = prerequisites[i][1];
	            this.adjList.get(source).add(destination);
	            this.indegrees[destination]++;
	        }
	    }
	}
}
