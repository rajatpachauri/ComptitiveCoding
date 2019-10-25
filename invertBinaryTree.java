package tree;

public class invertBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public TreeNode invertTree(TreeNode root) {
			if (root == null) {
				return root;
			} else if (root.right == null && root.left == null) {
				return root;
			} else if (root.right == null) {
				root.right = invertTree(root.left);
				root.left = null;
			} else if (root.left == null) {
				root.left = invertTree(root.right);
				root.right = null;
			} else {
				TreeNode node = invertTree(root.right);
				root.right = invertTree(root.left);
				root.left = node;
			}
			return root;
		}
	}
}
