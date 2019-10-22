package tree;

import java.util.LinkedList;

public class isCompleateBT {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isCompleteTree(TreeNode root) {
		if (root == null)
			return false;

		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(root);

		boolean nullFound = false;

		while (list.size() != 0) {
			TreeNode rem = list.removeFirst();
			if (rem != null && nullFound) {
				return false;
			}
			if (rem == null) {
				nullFound = true;
			}
			if (rem != null) {
				list.addLast(rem.left);
				list.addLast(rem.right);
			}
		}

		return true;
	}
}
