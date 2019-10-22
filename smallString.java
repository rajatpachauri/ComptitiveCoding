package tree;

public class smallString {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public String smallestFromLeaf(TreeNode root) {
		if (root == null) {
			return "";
		} else if (root.left == null && root.right == null) {
			return (char) (root.val + 'a') + "";
		} else if (root.left == null) {
			String r = smallestFromLeaf(root.right);
			return r + (char) (root.val + 'a');
		} else if (root.right == null) {
			String l = smallestFromLeaf(root.left);
			return l + (char) (root.val + 'a');
		} else {
			String l = smallestFromLeaf(root.left);
			String r = smallestFromLeaf(root.right);
			if (l.compareTo(r) < 0) {
				return l + (char) (root.val + 'a');
			} else {
				return r + (char) (root.val + 'a');
			}
		}
	}
}
