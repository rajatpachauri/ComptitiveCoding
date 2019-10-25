package tree;

import java.util.*;

public class zigzag {
	class TreeNode {
		TreeNode left, right;
		int data;

		TreeNode(int d) {
			data = d;
			left = right = null;
		}

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> rv = new ArrayList<>();

		if (root == null)
			return rv;

		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);

		boolean dr = true;

		while (q.size() != 0) {
			List<Integer> list = new ArrayList<>();
			LinkedList<TreeNode> temp = new LinkedList<>();
			while (q.size() != 0) {
				TreeNode node = q.removeFirst();
				list.add(node.data);
				if (node.left != null)
					temp.addLast(node.left);
				if (node.right != null)
					temp.addLast(node.right);
			}
			q = temp;
			if (!dr)
				Collections.reverse(list);
			dr = !dr;
			rv.add(list);
		}
		return rv;
	}
}
