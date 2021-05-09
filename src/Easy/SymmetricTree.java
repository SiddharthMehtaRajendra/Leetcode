package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

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

	class RecursiveSolution {
		public boolean isSymmetric(TreeNode root) {
			if (root == null)
				return true;
			return this.isSymmetric(root.left, root.right);
		}

		private boolean isSymmetric(TreeNode left, TreeNode right) {
			if (left == null && right == null)
				return true;
			if (left == null || right == null)
				return false;
			if (left.val != right.val)
				return false;

			return this.isSymmetric(left.left, right.right) && this.isSymmetric(left.right, right.left);
		}
	}
	
	class IterativeSolution {
	    public boolean isSymmetric(TreeNode root) {
	        if(root == null) return true;
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        queue.offer(root);
	        
	        while(!queue.isEmpty()){
	            TreeNode t1 = queue.poll();
	            TreeNode t2 = queue.poll();
	            if(t1 == null && t2 == null) continue;
	            if(t1 == null || t2 == null || t1.val != t2.val) return false;
	            
	            queue.offer(t1.left);
	            queue.offer(t2.right);
	            queue.offer(t1.right);
	            queue.offer(t2.left);
	        }
	        return true;
	    }
	}
}
