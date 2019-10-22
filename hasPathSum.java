package tree;

public class hasPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum1(TreeNode root, int target) {
		if (root == null) {
			return false;
		} else if (root.left == null && root.right == null) {
			if (target - root.val == 0)
				return true;
			else
				return false;
		} else if (root.left == null) {
			return hasPathSum1(root.right, target - root.val);
		} else if (root.right == null) {
			return hasPathSum1(root.left, target - root.val);
		} else {
			if (hasPathSum1(root.right, target - root.val)) {
				return true;
			} else if (hasPathSum1(root.left, target - root.val)) {
				return true;
			} else {
				return false;
			}
		}
	}
}
