// https://www.youtube.com/watch?v=LR3K5XAWV5k

package Hard;

public class RecoverBinarySearchTree {

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
		TreeNode previousNode = null;
		TreeNode firstStartPoint = null;
		TreeNode lastEndPoint = null;

		public void recoverTree(TreeNode root) {
			this.helper(root);
			this.swap(root);
		}

		private void swap(TreeNode root) {
			if (this.firstStartPoint != null) {
				int temp = this.firstStartPoint.val;
				this.firstStartPoint.val = this.lastEndPoint.val;
				this.lastEndPoint.val = temp;
			}
		}

		private void helper(TreeNode root) {
			if (root == null)
				return;
			this.helper(root.left);
			if (this.previousNode != null) {
				if (this.previousNode.val > root.val) {
					if (this.firstStartPoint == null) {
						this.firstStartPoint = this.previousNode;
					}
					this.lastEndPoint = root;
				}
			}
			this.previousNode = root;
			this.helper(root.right);
		}
	}
}
