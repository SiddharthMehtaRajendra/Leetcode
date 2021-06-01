// https://www.youtube.com/watch?v=dPrPCyzaqXQ

package Easy;

public class CousinsInBinaryTree {

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
		Integer xParent = null, yParent = null;
		Integer xDepth = -1, yDepth = -2;

		public boolean isCousins(TreeNode root, int x, int y) {
			if (root.val == x || root.val == y)
				return false;
			this.dfs(root, x, y, 0, root.val);
			return (xParent != yParent) && (xDepth == yDepth);
		}

		private void dfs(TreeNode root, int x, int y, int depth, int parent) {
			if (root == null)
				return;

			if (root.val == x) {
				xParent = parent;
				xDepth = depth;
			} else if (root.val == y) {
				yParent = parent;
				yDepth = depth;
			}
			this.dfs(root.left, x, y, depth + 1, root.val);
			this.dfs(root.right, x, y, depth + 1, root.val);
		}
	}
}
