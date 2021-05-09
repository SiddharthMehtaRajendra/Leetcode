package Hard;

public class SerializeDeserializeBinaryTree {

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

	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null)
				return "*";

			StringBuilder result = new StringBuilder("");
			result.append(root.val);
			result.append("," + serialize(root.left));
			result.append("," + serialize(root.right));
			return result.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			return helper(data.split(","), new int[1]);
		}

		private TreeNode helper(String[] data, int[] i) {
			if (i[0] == data.length)
				return null;
			String current = data[i[0]++];
			if (current.equals("*"))
				return null;
			TreeNode node = new TreeNode(Integer.valueOf(current));
			node.left = helper(data, i);
			node.right = helper(data, i);
			return node;
		}
	}
}

//Your Codec object will be instantiated and called as such:
//Codec ser = new Codec();
//Codec deser = new Codec();
//TreeNode ans = deser.deserialize(ser.serialize(root));
