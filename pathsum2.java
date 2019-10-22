package tree;

import java.util.*;

public class pathsum2 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> rv = new ArrayList<>();
		Helper(rv, root, sum, new ArrayList<Integer>());
		return rv;
	}

	public static void Helper(List<List<Integer>> rv, TreeNode root, int sum, ArrayList<Integer> list) {
		if (root == null) {
			return;
		} else if (root.left == null && root.right == null) {
			if (root.val - sum == 0) {
				list.add(root.val);
				rv.add(new ArrayList<>(list));
				list.remove(list.size() - 1);
			}
		} else if (root.left == null) {
			list.add(root.val);
			Helper(rv, root.right, sum - root.val, list);
			list.remove(list.size() - 1);
		} else if (root.right == null) {
			list.add(root.val);
			Helper(rv, root.left, sum - root.val, list);
			list.remove(list.size() - 1);
		} else {
			list.add(root.val);
			Helper(rv, root.right, sum - root.val, list);
			Helper(rv, root.left, sum - root.val, list);
			list.remove(list.size() - 1);
		}
	}

}
