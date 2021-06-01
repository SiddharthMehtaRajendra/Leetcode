// https://www.youtube.com/watch?v=C8iHdhXjKC4

package Medium;

import java.util.Stack;

public class BSTIterator {
	
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
	
	class BSTIteratorImpl {
	    Stack<TreeNode> st = new Stack<>();
	    
	    public BSTIteratorImpl(TreeNode root) {
	        this.partialInorder(root);
	    }
	    
	    private void partialInorder(TreeNode node){
	        while(node != null){
	            st.push(node);
	            node = node.left;
	        }
	    }
	    
	    public int next() {
	        TreeNode top = st.pop();
	        this.partialInorder(top.right);
	        return top.val;
	    }
	    
	    public boolean hasNext() {
	        return !st.isEmpty();
	    }
	}
}
