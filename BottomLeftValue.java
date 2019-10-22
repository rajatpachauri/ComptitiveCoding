package tree;

import java.util.*;

public class BottomLeftValue {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int findBottomLeftValue(TreeNode root) {
		// if(root==null)
		// return null;
		int rv = root.val;

		LinkedList<TreeNode> list = new LinkedList<>();

		list.addLast(root);
		list.addLast(null);
		boolean needToSet = false;
		while (list.size() != 1) {
			TreeNode node = list.removeFirst();
			if (node == null) {
				needToSet = true;
				list.addLast(node);
			} else {
				if (needToSet) {
					needToSet = false;
					rv = node.val;
				}
				if (node.left != null)
					list.addLast(node.left);
				if (node.right != null)
					list.addLast(node.right);
			}
		}

		return rv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
