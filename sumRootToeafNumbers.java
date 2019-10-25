package tree;

public class sumRootToeafNumbers {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		return Helper(root, 0);
	}

	public int Helper(TreeNode root, int num) {
		if (root.left == null && root.right == null) {
			return num * 10 + root.val;
		} else if (root.left == null) {
			return Helper(root.right, num * 10 + root.val);
		} else if (root.right == null) {
			return Helper(root.left, num * 10 + root.val);
		} else {
			return Helper(root.right, num * 10 + root.val) + Helper(root.left, num * 10 + root.val);
		}
	}
}
