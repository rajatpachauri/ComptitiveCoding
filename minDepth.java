package tree;

public class minDepth {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public int minDepth1(TreeNode node) {
		if (node.left == null && node.right == null) {
			return 1;
		} else if (node.left == null) {
			return 1 + minDepth1(node.right);
		} else if (node.right == null) {
			return 1 + minDepth1(node.left);
		} else {
			return Math.min(minDepth1(node.left), minDepth1(node.right)) + 1;
		}

	}
}
