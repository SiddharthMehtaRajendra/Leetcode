// https://www.youtube.com/watch?v=kulWKd3BUcI

package Medium;

public class LowestCommonAncestorOfBST {

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
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (p.val < root.val && q.val < root.val) {
				return this.lowestCommonAncestor(root.left, p, q);
			} else if (p.val > root.val && q.val > root.val) {
				return this.lowestCommonAncestor(root.right, p, q);
			} else {
				return root;
			}
		}
	}

}
