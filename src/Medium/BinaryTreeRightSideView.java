// https://www.youtube.com/watch?v=xyHb_ghpXf4
	
package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

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
		public List<Integer> rightSideView(TreeNode root) {
			if (root == null)
				return new ArrayList<>();
			List<Integer> rightSide = new ArrayList<>();
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);

			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = q.poll();
					if (i == 0)
						rightSide.add(node.val);
					if (node.right != null)
						q.add(node.right);
					if (node.left != null)
						q.add(node.left);
				}
			}

			return rightSide;
		}
	}
}
