package tree;

import java.util.*;;

public class leafSimilarTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		Stack<Integer> stack = new Stack<Integer>();
		dfs(root1, stack);
		System.out.println();
		boolean rv = dfs2(root2, stack);
		return stack.size() == 0 && rv;
	}

	private void dfs(TreeNode root, Stack<Integer> stack) {
		if (root == null)
			return;
		else if (root.left == null && root.right == null) {
			System.out.print(root.val + " ");
			stack.push(root.val);
		} else if (root.left == null) {
			dfs(root.right, stack);
		} else if (root.right == null) {
			dfs(root.left, stack);
		} else {
			dfs(root.right, stack);
			dfs(root.left, stack);
		}
	}

	private boolean dfs2(TreeNode root, Stack<Integer> stack) {
		if (root == null)
			return true;
		else if (root.left == null && root.right == null) {
			System.out.print(root.val + " ");
			if (stack.size() == 0)
				return false;
			return stack.pop() == root.val;
		} else if (root.right == null) {
			return dfs2(root.left, stack);
		} else if (root.left == null) {
			return dfs2(root.right, stack);
		} else {
			return dfs2(root.left, stack) && dfs2(root.right, stack);
		}
	}
}
