// https://www.youtube.com/watch?v=OhlPAvT-6dM

package Medium;

import java.util.Arrays;

public class ConstructTreeFromInorderAndPreorder {
	
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

		public TreeNode buildTree(int[] preorder, int[] inorder) {
			return this.builder(preorder, inorder);
		}

		private TreeNode builder(int[] preorder, int[] inorder) {
			if (preorder.length == 0 || inorder.length == 0)
				return null;
			int index = -1;
			for (int i = 0; i < inorder.length; i++) {
				if (inorder[i] == preorder[0]) {
					index = i;
					break;
				}
			}
			TreeNode root = new TreeNode(preorder[0]);

			int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
			int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
			int[] preLeft = Arrays.copyOfRange(preorder, 1, index + 1);
			int[] preRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);

			root.left = this.builder(preLeft, inLeft);
			root.right = this.builder(preRight, inRight);

			return root;
		}
	}
}
