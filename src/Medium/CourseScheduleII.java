package Medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class CourseScheduleII {
	class Solution {
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		int[] indegrees;

		public int[] findOrder(int numCourses, int[][] prerequisites) {
			if (numCourses == 0 || prerequisites == null)
				return new int[1];
			this.indegrees = new int[numCourses];
			Stack<Integer> st = new Stack<>();
			for (int i = 0; i < numCourses; i++) {
				this.adjList.put(i, new LinkedList<>());
			}
			Queue<Integer> queue = new LinkedList<>();

			int count = numCourses - 1;
			this.buildAdjacencyListAndIndegreesArray(prerequisites);
			for (int i = 0; i < numCourses; i++) {
				if (this.indegrees[i] == 0) {
					st.push(i);
					queue.add(i);
				}
				;
			}

			while (!queue.isEmpty()) {
				int course = queue.poll();
				for (int neighbour : this.adjList.get(course)) {
					if (this.indegrees[neighbour] > 0)
						this.indegrees[neighbour]--;
					if (this.indegrees[neighbour] == 0) {
						st.push(neighbour);
						queue.add(neighbour);
					}
				}
			}
			if (st.size() != numCourses)
				return new int[0];
			int[] result = new int[st.size()];
			int i = 0;
			while (!st.isEmpty()) {
				result[i++] = st.pop();
			}
			return result; 
		}

		private void buildAdjacencyListAndIndegreesArray(int[][] prerequisites) {
			for (int i = 0; i < prerequisites.length; i++) {
				int source = prerequisites[i][0];
				int destination = prerequisites[i][1];
				this.adjList.get(source).add(destination);
				this.indegrees[destination]++;
			}
		}
	}

	class BetterSolution { // Self Designed to avoid extra space
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		int[] indegrees;

		public int[] findOrder(int numCourses, int[][] prerequisites) {
			if (numCourses == 0 || prerequisites == null)
				return new int[1];
			this.indegrees = new int[numCourses];
			Stack<Integer> st = new Stack<>();
			for (int i = 0; i < numCourses; i++) {
				this.adjList.put(i, new LinkedList<>());
			}
			Queue<Integer> queue = new LinkedList<>();

			this.buildAdjacencyListAndIndegreesArray(prerequisites);
			for (int i = 0; i < numCourses; i++) {
				if (this.indegrees[i] == 0) {
					queue.add(i);
				}
				;
			}

			int[] result = new int[numCourses];
			int counter = numCourses - 1;
			while (!queue.isEmpty()) {
				int course = queue.poll();
				result[counter--] = course;
				for (int neighbour : this.adjList.get(course)) {
					if (this.indegrees[neighbour] > 0)
						this.indegrees[neighbour]--;
					if (this.indegrees[neighbour] == 0) {
						queue.add(neighbour);
					}
				}
			}
			if (counter > 0)
				return new int[0];
			return result;
		}

		private void buildAdjacencyListAndIndegreesArray(int[][] prerequisites) {
			for (int i = 0; i < prerequisites.length; i++) {
				int source = prerequisites[i][0];
				int destination = prerequisites[i][1];
				this.adjList.get(source).add(destination);
				this.indegrees[destination]++;
			}
		}
	}
}
