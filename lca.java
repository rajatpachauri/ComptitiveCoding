package tree;

public class lca {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode node = null;
	public static boolean left = false, right = false;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		findlca(root, p, q);
		return node;
	}

	private static boolean findlca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return false;
		
		boolean self = false;

		if (root.val == p.val || root.val == q.val) {
			self = true;
		}

		left = left || findlca(root.left, p, q);
		right = right || findlca(root.right, p, q);

		if (self && left || left && right || right && self) {
			if (node != null) {
				node = root;
			}
		}
		return self || left || right;
	}

	public static void main(String[] args) {

	}

}
