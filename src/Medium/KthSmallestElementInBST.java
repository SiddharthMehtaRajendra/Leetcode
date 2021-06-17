// https://www.youtube.com/watch?v=C6r1fDKAW_o

package Medium;

public class KthSmallestElementInBST {
	
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
		private int index;
		private int value;

		public int kthSmallest(TreeNode root, int k) {
			this.helper(root, k);
			return this.value;
		}

		private void helper(TreeNode root, int k) {
			if (root == null) {
				return;
			}
			this.helper(root.left, k);
			if (++this.index == k) {
				this.value = root.val;
				return;
			}
			this.helper(root.right, k);
		}
	}
}
