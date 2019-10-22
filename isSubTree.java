package tree;


public class isSubTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		String p1 = path(s);
		String p2 = path(t);
		return p1.indexOf(p2) == -1 ? false : true;
	}

	public String path(TreeNode root) {
		if (root == null)
			return ".";
		String lp="-",rp="-";
		if (root.left == null && root.right == null) {
			return lp + root.val + rp;
		} else if (root.right == null) {
			lp = path(root.left);
			return lp + root.val + rp;
		} else if (root.left == null) {
			rp = path(root.right);
			return lp + root.val + rp;
		} else {
			lp = path(root.left);
			rp = path(root.right);
			return lp + root.val + rp;
		}
	}
}
