package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigZagLevelOrderTraversal {

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
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			if (root == null)
				return new ArrayList<>();
			Stack<TreeNode> s1 = new Stack<>();
			Stack<TreeNode> s2 = new Stack<>();
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> leftToRight = new ArrayList<>();
			List<Integer> rightToLeft = new ArrayList<>();

			s1.push(root);
			while (!s1.isEmpty() || !s2.isEmpty()) {
				while (!s1.isEmpty()) {
					TreeNode node = s1.pop();
					leftToRight.add(node.val);
					if (node.left != null)
						s2.push(node.left);
					if (node.right != null)
						s2.push(node.right);
				}
				if (!leftToRight.isEmpty()) {
					result.add(new ArrayList<>(leftToRight));
					leftToRight.clear();
				}
				while (!s2.isEmpty()) {
					TreeNode node = s2.pop();
					rightToLeft.add(node.val);
					if (node.right != null)
						s1.push(node.right);
					if (node.left != null)
						s1.push(node.left);
				}
				if (!rightToLeft.isEmpty()) {
					result.add(new ArrayList<>(rightToLeft));
					rightToLeft.clear();
				}
			}
			return result;
		}
	}
}
