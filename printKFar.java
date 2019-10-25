package tree;

import java.util.*;

public class printKFar {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> list = new ArrayList<Integer>();

		traverse(root, list, target, k);
		return list;
	}

	public int traverse(TreeNode root, List<Integer> list, TreeNode target, int k) {
		if (root == null)
			return -1;
		
		if (root.val == target.val) {
			printKDown(root, null, k, list);
			return 0;
		}
		int left = traverse(root.left, list, target, k);

		if (left != -1) {
			printKDown(root, root.left, k - left - 1, list);
			return left + 1;
		}
		int right = traverse(root.right, list, target, k);

		if (right != -1) {
			printKDown(root, root.right, k - right - 1, list);
			return right + 1;
		}

		return -1;
	}

	public void printKDown(TreeNode node, TreeNode blocker, int k, List<Integer> list) {
		if (node == null || k < 0)
			return;
		if (node == blocker)
			return;
		if (k == 0) {
			list.add(node.val);
			return;
		}

		printKDown(node.left, blocker, k - 1, list);
		printKDown(node.right, blocker, k - 1, list);
	}
}
