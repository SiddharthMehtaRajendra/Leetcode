package Medium;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorBinaryTree {

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

	class NaiveSolution {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			ArrayList<TreeNode> pathP = new ArrayList<TreeNode>();
			ArrayList<TreeNode> pathQ = new ArrayList<TreeNode>();
			findPath(root, pathP, p.val);
			findPath(root, pathQ, q.val);
			return performLCA(pathP, pathQ);

		}

		private boolean findPath(TreeNode root, List<TreeNode> path, int value) {
			if (root == null)
				return false;
			path.add(root);
			if (root.val == value)
				return true;
			if (findPath(root.left, path, value) || findPath(root.right, path, value))
				return true;
			path.remove(path.size() - 1);
			return false;
		}

		private TreeNode performLCA(List<TreeNode> p, List<TreeNode> q) {
			int length = Math.min(p.size(), q.size());
			for (int i = 0; i < length; i++) {
				if (i + 1 == length || (p.get(i + 1).val != q.get(i + 1).val)) {
					return p.get(i);
				}
			}
			return null;
		}
	}
	
	class OptimalSolution {
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root == null) return root;
	        if(root.val == p.val || root.val == q.val) return root;
	        
	        TreeNode lcaLeft = lowestCommonAncestor(root.left, p, q);
	        TreeNode lcaRight = lowestCommonAncestor(root.right, p, q);
	        
	        if(lcaLeft != null && lcaRight != null) return root;
	        if(lcaLeft != null) return lcaLeft;
	        else return lcaRight;
	    }
	}
}
