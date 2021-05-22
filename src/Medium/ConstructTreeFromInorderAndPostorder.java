// https://www.youtube.com/watch?v=9R6exp6BxYM

package Medium;

import java.util.Arrays;

public class ConstructTreeFromInorderAndPostorder {

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
		public TreeNode buildTree(int[] inorder, int[] postorder) {
			if (inorder == null || inorder.length == 0)
				return null;
			int rootVal = postorder[postorder.length - 1];
			TreeNode root = new TreeNode(rootVal);
			int idx = -1;
			for (int i = 0; i < inorder.length; i++) {
				if (inorder[i] == rootVal) {
					idx = i;
					break;
				}
			}

			int[] inLeft = Arrays.copyOfRange(inorder, 0, idx);
			int[] inRight = Arrays.copyOfRange(inorder, idx + 1, inorder.length);
			int[] postLeft = Arrays.copyOfRange(postorder, 0, idx);
			int[] postRight = Arrays.copyOfRange(postorder, idx, postorder.length - 1);

			root.left = this.buildTree(inLeft, postLeft);
			root.right = this.buildTree(inRight, postRight);
			return root;
		}
	}
}
