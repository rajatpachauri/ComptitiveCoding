package tree;

import java.util.*;

public class FlipBTtomatchPreOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void preorder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		list.add(root.val);
		preorder(root.left, list);
		preorder(root.right, list);
	}

	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		List<Integer> list = new ArrayList<>();

		preorder(root, list);
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < voyage.length; ++i) {
			map.put(voyage[i], i);
		}

		for (int i = 0; i < list.size(); ++i) {
			int nv = map.get(list.get(i));
			list.set(i, nv);
		}

		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
