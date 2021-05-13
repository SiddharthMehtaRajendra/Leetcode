// Leetcode Solutions

package Easy;

public class DiameterOfBinaryTree {
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

	class Solution {
		private int diameter;

		public int diameterOfBinaryTree(TreeNode root) {
			this.helper(root);
			return diameter;
		}

		private int helper(TreeNode root) {
			if (root == null)
				return 0;

			int leftPath = this.helper(root.left);
			int rightPath = this.helper(root.right);

			diameter = Math.max(diameter, leftPath + rightPath);
			return 1 + Math.max(leftPath, rightPath);
		}
	}
}
