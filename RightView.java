package tree;

import java.util.*;

public class RightView {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public List<Integer> rightSideView(TreeNode root) {
			List<Integer> rv = new ArrayList<>();

			if (root == null)
				return rv;

			LinkedList<TreeNode> q = new LinkedList<>();
			q.add(root);

			while (q.size() != 0) {
				LinkedList<TreeNode> temp = new LinkedList<>();
				int num = 0;
				while (q.size() != 0) {
					TreeNode node = q.removeFirst();
					num = node.val;
					if (node.left != null)
						temp.addLast(node.left);
					if (node.right != null)
						temp.addLast(node.right);
				}
				q = temp;
				rv.add(num);
			}

			return rv;
		}
	}
}
