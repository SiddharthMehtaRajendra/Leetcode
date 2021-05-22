package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class ReconstructItinerary {
	class Solution {
		public List<String> findItinerary(List<List<String>> tickets) {
			List<String> result = new ArrayList<>();
			Map<String, PriorityQueue<String>> adjList = new HashMap<>();

			for (int i = 0; i < tickets.size(); i++) {
				List<String> pair = tickets.get(i);
				if (!adjList.containsKey(pair.get(0))) {
					adjList.put(pair.get(0), new PriorityQueue<>());
				}
				adjList.get(pair.get(0)).offer(pair.get(1));
			}

			Stack<String> st = new Stack<>();
			st.push("JFK");
			while (!st.isEmpty()) {
				String source = st.peek();
				if (!adjList.containsKey(source) || adjList.get(source).isEmpty()) {
					result.add(source);
					st.pop();
				} else {
					String destination = adjList.get(source).poll();
					st.push(destination);
				}
			}
			Collections.reverse(result);
			return result;
		}
	}
	
}
