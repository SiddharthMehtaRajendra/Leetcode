package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	
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
		List<Integer> result = new ArrayList<>();

		public List<Integer> inorderTraversal(TreeNode root) {
			if (root == null)
				return new ArrayList<>();
			this.inorderTraversal(root.left);
			this.result.add(root.val);
			this.inorderTraversal(root.right);
			return this.result;
		}
	}
	
	class IterativeSolution {
	    List<Integer> result = new ArrayList<>();
	    public List<Integer> inorderTraversal(TreeNode root) {
	        if(root == null) return new ArrayList<>();
	        Stack<TreeNode> st = new Stack<>();
	        while(!st.isEmpty() || root != null){
	            while(root != null){
	                st.push(root);
	                root = root.left;
	            }
	            root = st.pop();
	            result.add(root.val);
	            root = root.right;
	        }
	        return result;
	    }
	}
}
