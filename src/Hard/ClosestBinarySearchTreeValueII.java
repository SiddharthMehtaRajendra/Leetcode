// https://www.youtube.com/watch?v=YZFfZ3nh3sY

package Hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ClosestBinarySearchTreeValueII {

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
		List<Integer> result = new ArrayList<>();
		Deque<Integer> smaller = new ArrayDeque<>();
		Deque<Integer> bigger = new ArrayDeque<>();

		public List<Integer> closestKValues(TreeNode root, double target, int k) {
			this.dfsSmaller(root, target);
			this.dfsLarger(root, target);
			while (k > 0) {
				if (this.smaller.isEmpty()) {
					this.result.add(this.bigger.removeFirst());
				} else if (this.bigger.isEmpty()) {
					this.result.add(this.smaller.removeLast());
				} else if (Math.abs(this.smaller.peekLast() - target) < Math.abs(this.bigger.peekFirst() - target)) {
					this.result.add(this.smaller.removeLast());
				} else {
					this.result.add(this.bigger.removeFirst());
				}
				k--;
			}
			return this.result;
		}

		private void dfsSmaller(TreeNode root, double target) {
			if (root == null)
				return;

			this.dfsSmaller(root.left, target);
			if (root.val <= target) {
				this.smaller.addLast(root.val);
			}
			this.dfsSmaller(root.right, target);
		}

		private void dfsLarger(TreeNode root, double target) {
			if (root == null)
				return;

			this.dfsLarger(root.left, target);
			if (root.val > target) {
				this.bigger.addLast(root.val);
			}
			this.dfsLarger(root.right, target);
		}
	}
}
