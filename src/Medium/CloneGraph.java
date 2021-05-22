package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	class DFSSolution {
	    public Node cloneGraph(Node node) {
	        if(node == null) return null;
	        Map<Integer, Node> map = new HashMap<>();
	        return this.cloneGraph(node, map);
	    }
	    
	    private Node cloneGraph(Node node, Map<Integer, Node> map){
	        if(map.containsKey(node.val)) return map.get(node.val);
	        Node copy = new Node(node.val);
	        map.put(node.val, copy);
	        for(Node neighbor: node.neighbors) {
	            Node clonedNeighbour = this.cloneGraph(neighbor, map);
	            copy.neighbors.add(clonedNeighbour);
	        }
	        return copy;
	    }
	}
	
	class BFSSolution {
	    public Node cloneGraph(Node node) {
	        if(node == null) return null;
	        Map<Integer, Node> map = new HashMap<>();
	        Queue<Node> q = new LinkedList<>();
	        q.add(node);
	        map.put(node.val, new Node(node.val));
	        
	        while(!q.isEmpty()){
	            Node curr = q.poll();
	            for(Node neighbor: curr.neighbors){
	                if(!map.containsKey(neighbor.val)){
	                    map.put(neighbor.val, new Node(neighbor.val));
	                    q.add(neighbor);
	                }
	                map.get(curr.val).neighbors.add(map.get(neighbor.val));
	            }
	        }
	        return map.get(node.val);
	    }
	}
}
