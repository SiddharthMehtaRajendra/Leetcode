// https://www.youtube.com/watch?v=3FZRnVJ98X0

package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class EmployeeImportance {

	class Employee {
	    public int id;
	    public int importance;
	    public List<Integer> subordinates;
	};
	
	class Solution {
		public int getImportance(List<Employee> employees, int id) {
			HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
			HashMap<Integer, Integer> values = new HashMap<>();

			for (Employee e : employees) {
				adjacencyList.put(e.id, e.subordinates);
				values.put(e.id, e.importance);
			}

			int result = 0;
			Queue<Integer> q = new LinkedList<>();
			Set<Integer> visited = new HashSet<>();
			q.add(id);
			visited.add(id);
			result += values.get(id);
			while (!q.isEmpty()) {
				int curr = q.poll();
				for (int sub : adjacencyList.get(curr)) {
					if (!visited.contains(sub)) {
						result += values.get(sub);
						q.add(sub);
						visited.add(sub);
					}
				}
			}
			return result;
		}
	}
}
