package tree;

import java.util.*;

public class btlevelOrder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> rv = new ArrayList<>();

		if (root == null)
			return rv;

		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (q.size() != 0) {
			List<Integer> list = new ArrayList<>();
			LinkedList<TreeNode> temp = new LinkedList<>();
			while (q.size() != 0) {
				TreeNode node = q.removeFirst();
				list.add(node.val);
				if (node.left != null)
					temp.addLast(node.left);
				if (node.right != null)
					temp.addLast(node.right);
			}
			q = temp;
			temp.clear();
			rv.add(list);
		}

		return rv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
