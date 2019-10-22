package tree;

public class foldable {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public boolean isFoldable(TreeNode root) {
		return sym(root, root);
	}

	public boolean sym(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null && q != null || p != null && q == null) {
			return false;
		} else {
			return sym(p.left, q.right) && sym(p.right, q.left);
		}
	}

}
