package tree;

import java.util.*;

import tree.SumOfLEftChild.TreeNode;

public class VerticalTraverrsal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Pair {
		int level;
		TreeNode node;

		public Pair(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		List<List<Integer>> rv = new ArrayList<>();

		if (root == null)
			return rv;

		LinkedList<Pair> list = new LinkedList<>();
		Pair p = new Pair(root, 0);
		list.addLast(p);

		while (list.size() != 0) {
			Pair rem = list.removeFirst();

			if (map.containsKey(rem.level)) {
				map.get(rem.level).add(rem.node.val);
			} else {
				List<Integer> li = new ArrayList<>();
				li.add(rem.node.val);
				map.put(rem.level, li);
			}

			if (rem.node.left != null) {
				list.add(new Pair(rem.node.left, rem.level - 1));
			}
			if (rem.node.right != null) {
				list.add(new Pair(rem.node.right, rem.level + 1));
			}
		}
		ArrayList<Integer> al = new ArrayList<Integer>(map.keySet());
		Collections.sort(al);
		for (int key : al) {
			rv.add(map.get(key));
		}
		return rv;
	}
}
