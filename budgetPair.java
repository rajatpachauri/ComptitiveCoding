package tree;

import java.util.*;

public class budgetPair {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static class Pair {
		int level;
		TreeNode node;

		public Pair(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	public static int getCount(TreeNode node, int bud) {

		LinkedList<Pair> q = new LinkedList<>();
		Pair p = new Pair(node, 1);
		int count = 0;
		q.addLast(p);

		while (q.size() != 0 && bud > 0) {
			Pair pair = q.removeFirst();

			if (pair.node.left == null && pair.node.right == null) {
				if (bud - pair.level < 0) {
					return count;
				}
				++count;
				bud -= pair.level;
			}

			if (pair.node.left != null) {
				q.addLast(new Pair(pair.node.left, pair.level + 1));
			}
			if (pair.node.right != null) {
				q.addLast(new Pair(pair.node.right, pair.level + 1));
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
