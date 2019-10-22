package tree;

public class DecimalSumRootToLEaf {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumRootToLeaf(TreeNode root) {
		return sumRootToLeaf(root, 0);
	}

	public int sumRootToLeaf(TreeNode root, int sum) {
		sum = sum * 2 + root.val;
		if (root.left == null && root.right == null) {
			return sum;
		} else if (root.left == null) {
			return sumRootToLeaf(root.right, sum);
		} else if (root.right == null) {
			return sumRootToLeaf(root.left, sum);
		} else {
			return sumRootToLeaf(root.right, sum) + sumRootToLeaf(root.left, sum);
		}
	}
}
