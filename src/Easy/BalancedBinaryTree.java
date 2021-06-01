// https://www.youtube.com/watch?v=icxndJkKUuc

package Easy;

public class BalancedBinaryTree {

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

	class Solution { // O(nlogn)
		public boolean isBalanced(TreeNode root) {
			if (root == null)
				return true;
			return Math.abs(this.height(root.left) - this.height(root.right)) <= 1 && this.isBalanced(root.left)
					&& this.isBalanced(root.right);
		}

		private int height(TreeNode root) {
			if (root == null)
				return 0;
			return Math.max(height(root.left), height(root.right)) + 1;
		}
	}
	
	class OptimizedSolution { //O(n)
	    public boolean isBalanced(TreeNode root) {
	        if(root == null) return true;
	        return this.height(root) == -1 ? false : true;
	    }
	    
	    private int height(TreeNode root){
	        if(root == null) return 0;
	        int left = this.height(root.left);
	        int right = this.height(root.right);
	        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
	            return -1;
	        }
	        return Math.max(left, right) + 1;
	    }
	}
}
