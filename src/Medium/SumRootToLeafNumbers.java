// https://www.youtube.com/watch?v=9R6exp6BxYM

package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeafNumbers {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class RecursiveDFSSolution {
		public int sumNumbers(TreeNode root) {
			return this.helper(root, 0);
		}

		private int helper(TreeNode root, int val) {
			if (root == null)
				return 0;
			if (root.left == null && root.right == null)
				return val * 10 + root.val;
			return this.helper(root.left, val * 10 + root.val) + this.helper(root.right, val * 10 + root.val);
		}
	}
	
	class IterativeBFSSolution {
	    
	    class Pair{
	        private TreeNode node;
	        private Integer value;
	        
	        public Pair(TreeNode node, Integer value){
	            this.node = node;
	            this.value = value;
	        }
	        
	        public TreeNode getNode(){
	            return this.node;
	        }
	        
	        public int getValue(){
	            return this.value;
	        }
	    }
	    
	    public int sumNumbers(TreeNode root) {
	        if(root == null) return 0;
	        Queue<Pair> queue = new LinkedList<>();
	        queue.add(new Pair(root, 0));
	        int sum = 0;
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            for(int i = 0; i < size; i++){
	                Pair pair = queue.poll();
	                TreeNode node = pair.getNode();
	                Integer value = pair.getValue();
	                if(node != null){
	                    value = (value * 10) + node.val;
	                    if(node.left == null && node.right == null){
	                        sum += value;
	                        continue;
	                    }
	                    queue.add(new Pair(node.left, value));
	                    queue.add(new Pair(node.right, value));
	                }
	            }
	        }
	        return sum;
	    }
	}
}
