package tree;

import java.util.*;

public class maxWidth {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Pair {
		TreeNode node;
		int level;

		public Pair(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	public int widthOfBinaryTree(TreeNode root) {
		int rv = 0;

		if (root == null) {
			return rv;
		}

		Pair pair = new Pair(root, 0);

		LinkedList<Pair> q = new LinkedList<>();
		q.add(pair);

		while (q.size() != 0) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

			LinkedList<Pair> temp = new LinkedList<>();

			while (q.size() != 0) {
				Pair rem = q.removeFirst();
				if (rem == null)
					continue;
				min = Math.min(rem.level, min);
				max = Math.max(rem.level, max);

				temp.addLast(new Pair(rem.node.left, rem.level - 1));
				temp.addLast(new Pair(rem.node.right, rem.level + 1));

			}

			rv = Math.max(rv, max - min);
			q = temp;
		}

		return rv;
	}
}
