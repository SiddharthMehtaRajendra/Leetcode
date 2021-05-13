// https://www.youtube.com/watch?v=6cA_NDtpyz8

package Hard;

public class BinaryTreeMaximumPathSum {

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
		int max = Integer.MIN_VALUE;

		public int maxPathSum(TreeNode root) {
			this.helper(root);
			return max;
		}

		private int helper(TreeNode root) {
			if (root == null)
				return 0;
			int left = Math.max(this.helper(root.left), 0);
			int right = Math.max(this.helper(root.right), 0);
			max = Math.max(max, root.val + left + right);
			return Math.max(left, right) + root.val;
		}
	}
}
