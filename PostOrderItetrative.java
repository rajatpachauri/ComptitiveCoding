package tree;

import java.util.*;

public class PostOrderItetrative {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Pair {
		TreeNode node;
		int status;

		public Pair(TreeNode node) {
			this.node = node;
			status = 0;
		}
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null)
			return list;

		Stack<Pair> st = new Stack<>();
		Pair pair = new Pair(root);
		st.push(pair);

		while (st.size() != 0) {
			Pair rem = st.pop();

			if (rem.status == 0) {
				rem.status++;
				st.push(rem);
				if (rem.node.left != null) {
					Pair p = new Pair(rem.node.left);
					st.push(p);
				}
			} else if (rem.status == 1) {
				rem.status++;
				st.push(rem);
				if (rem.node.right != null) {
					Pair p = new Pair(rem.node.right);
					st.push(p);
				}
			} else {
				list.add(rem.node.val);
			}
		}

		return list;
	}

	public void postOrder(TreeNode node, ArrayList<Integer> list) {
		if (node == null)
			return;

		postOrder(node.left, list);
		postOrder(node.right, list);
		list.add(node.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
