package tree;

public class maxPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int myMax;

	public static int maxPathSum(TreeNode root) {
		myMax = Integer.MIN_VALUE;
		Helper(root);
		return myMax;
	}

	public static int Helper(TreeNode root) {
		if (root == null)
			return 0;

		int ls = Helper(root.left);
		int rs = Helper(root.right);
		int rv = Math.max(ls + root.val, Math.max(rs + root.val, root.val));

		myMax = Math.max(myMax, Math.max(rv, ls + rs + root.val));
		return rv;

	}
}
