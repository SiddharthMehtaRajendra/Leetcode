// https://www.youtube.com/watch?v=3B5gnrwRmOA

package Medium;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	
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
	    List<List<Integer>> result = new ArrayList<>();
	    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
	        this.helper(root, targetSum, new ArrayList<>());
	        return result;
	    }
	    
	    private void helper(TreeNode root, int target, List<Integer> curr){
	        if(root == null) return;
	        curr.add(root.val);
	        if(target == root.val && root.left == null && root.right == null){
	            result.add(curr);
	            return;
	        }
	        this.helper(root.left, target - root.val, new ArrayList<>(curr));
	        this.helper(root.right, target - root.val, new ArrayList<>(curr));
	    }
	}
}
