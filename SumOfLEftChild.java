package tree;


public class SumOfLEftChild {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public int sum(TreeNode root, boolean ilc) {
		if (root.left == null && root.right == null) {
			if (ilc)
				return root.val;
			else
				return 0;
		} else if (root.left == null) {
			return sum(root.right, false);
		} else if (root.right == null) {
			return sum(root.left, true);
		} else {
			return sum(root.right, false) + sum(root.left, true);
		}
	}

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		return sum(root, false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
