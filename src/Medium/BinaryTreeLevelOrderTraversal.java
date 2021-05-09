package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

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
	
	class DFSSolution {
	    List<List<Integer>> result = new ArrayList<>();
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        if(root == null) return new ArrayList<>();
	        this.helper(root, 0);
	        return result;
	    }
	    
	    private void helper(TreeNode root, int level){
	        if(result.size() == level) {
	            result.add(new ArrayList<>());
	        }
	        result.get(level).add(root.val);
	        
	        if(root.left != null) this.helper(root.left, level + 1);
	        if(root.right != null) this.helper(root.right, level + 1);
	    }
	}

	class BFSSolution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			if (root == null)
				return new ArrayList<>();
			List<List<Integer>> result = new ArrayList<>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				List<Integer> level = new ArrayList<>();
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					level.add(node.val);
					if (node.left != null)
						queue.offer(node.left);
					if (node.right != null)
						queue.offer(node.right);
				}
				result.add(level);
			}
			return result;
		}
	}
}
