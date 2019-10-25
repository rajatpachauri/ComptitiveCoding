package tree;

import java.util.Stack;

public class SerealizeAndDesearelizeBT {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		} else if (root.left == null && root.right == null) {
			return root.val + " lnull " + "rnull ";
		} else if (root.left == null) {
			return root.val + " lnull " + serialize(root.right);
		} else if (root.right == null) {
			return root.val + " " + serialize(root.left) + " rnull ";
		} else {
			return root.val + " " + serialize(root.left) + serialize(root.right);
		}
	}

	public class Pair {
		TreeNode node;
		int status;

		public Pair(TreeNode node) {
			this.node = node;
			this.status = 0;
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.length() == 0)
			return null;
		String[] arr = data.trim().split("\\s+");
		int i = 0;
		TreeNode root = new TreeNode(Integer.parseInt(arr[i++]));
		Stack<Pair> st = new Stack<>();
		Pair p = new Pair(root);
		st.push(p);

		while (st.size() != 0 && i != arr.length) {
			Pair rem = st.pop();

			String nex = arr[i++];
			if (nex.length() == 0)
				continue;

			if (rem.status == 0) {
				if (nex.equals("lnull")) {
					rem.status++;
					st.push(rem);
				} else {
					TreeNode tn = new TreeNode(Integer.parseInt(nex));
					rem.node.left = tn;
					rem.status++;
					st.push(rem);
					st.push(new Pair(tn));
				}
			} else if (rem.status == 1) {
				if (nex.equals("rnull")) {
					rem.status++;
					st.push(rem);
				} else {
					TreeNode tn = new TreeNode(Integer.parseInt(nex));
					rem.node.right = tn;
					rem.status++;
					st.push(rem);
					st.push(new Pair(tn));
				}
			} else if (rem.status == 2) {
				// both child done
				i--;
			}
		}

		return root;

	}
}
