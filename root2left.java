package tree;

import java.util.*;

public class root2left {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> rv = new ArrayList<>();
		if (root == null)
			return rv;
		Helper(rv, root, "");
		return rv;
	}

	public static void Helper(List<String> rv, TreeNode root, String psf) {
		if (root.left == null && root.right == null) {
			rv.add(psf + root.val);
		} else if (root.left == null) {
			Helper(rv, root.right, psf + root.val + "->");
		} else if (root.right == null) {
			Helper(rv, root.left, psf + root.val + "->");
		} else {
			Helper(rv, root.right, psf + root.val + "->");
			Helper(rv, root.left, psf + root.val + "->");
		}
	}
}