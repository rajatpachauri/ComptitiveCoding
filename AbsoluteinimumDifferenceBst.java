package tree;

public class AbsoluteinimumDifferenceBst {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	Integer prev;
	int minDiff = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		inorder(root);
		return minDiff;
	}

	private void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		if (prev != null)
			minDiff = Math.min(minDiff, Math.abs(root.val - prev));
		prev = root.val;
		inorder(root.right);
	}

	public static int getMinimumDifferenceWrong(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		} else if (root.left == null && root.right == null) {
			return Integer.MAX_VALUE;
		} else if (root.left == null) {
			int diff = Math.abs(root.val - root.right.val);
			return Math.min(diff, getMinimumDifferenceWrong(root.right));
		} else if (root.right == null) {
			int diff = Math.abs(root.val - root.left.val);
			return Math.min(diff, getMinimumDifferenceWrong(root.left));
		} else {
			int diff = Math.abs(root.val - root.left.val);
			int diff2 = Math.abs(root.val - root.right.val);
			return Math.min(diff, Math.min(diff2,
					Math.min(getMinimumDifferenceWrong(root.left), getMinimumDifferenceWrong(root.right))));
		}
	}
}