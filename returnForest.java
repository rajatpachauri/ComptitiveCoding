package tree;

import java.util.*;

public class returnForest {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int u_val = Integer.MAX_VALUE - 100;

	public class Pair {
		boolean parent_processed;
		TreeNode node;

		public Pair(TreeNode node, boolean parent_processed) {
			this.parent_processed = parent_processed;
			this.node = node;
		}
	}

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		HashSet<Integer> set = new HashSet<>();
		for (int val : to_delete) {
			set.add(val);
		}

		traverse(root, set);

		List<TreeNode> rv = new ArrayList<>();
		LinkedList<Pair> q = new LinkedList<>();

		if (root == null)
			return rv;

		q.addLast(new Pair(root, false));

		while (q.size() != 0) {
			Pair rem = q.removeFirst();
			if (rem.node == null)
				continue;

			if (rem.parent_processed == false && rem.node.val != u_val) {
				rv.add(rem.node);
				q.addLast(new Pair(rem.node.left, true));
				q.addLast(new Pair(rem.node.right, true));
			} else if (rem.node.val == u_val) {
				q.addLast(new Pair(rem.node.left, false));
				q.addLast(new Pair(rem.node.right, false));
			} else {
				q.addLast(new Pair(rem.node.left, true));
				q.addLast(new Pair(rem.node.right, true));
			}
		}

		return rv;

	}

	public void traverse(TreeNode root, HashSet<Integer> set) {
		if (root == null)
			return;
		if (set.contains(root.val)) {
			root.val = u_val;
		}

		traverse(root.left, set);
		traverse(root.right, set);

	}
}
