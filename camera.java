package tree;

import java.util.*;

public class camera {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int minCameraCover(TreeNode root) {
		HashMap<TreeNode, Integer> map = new HashMap<>();
		int rv = Helper(map, root);
		return rv;
	}

	public static int Helper(HashMap<TreeNode, Integer> map, TreeNode root) {
		if (root == null)
			return 0;

		if (map.containsKey(root)) {
			return map.get(root);
		}

		int v1 = Integer.MAX_VALUE, v2 = Integer.MAX_VALUE, v3 = Integer.MAX_VALUE;

		// on root
		v1 = 1 + (root.left != null ? Helper(map, root.left.left) + Helper(map, root.left.right) : 0)
				+ (root.right != null ? Helper(map, root.right.left) + Helper(map, root.right.right) : 0);

		TreeNode b = root.left, c = root.right;

		if (b != null)
			v2 = 1 + Helper(map, root.right)
					+ (b.left != null ? Helper(map, b.left.left) + Helper(map, b.left.right) : 0)
					+ (b.right != null ? Helper(map, b.right.left) + Helper(map, b.right.right) : 0);

		if (c != null)
			v3 = 1 + Helper(map, root.left)
					+ (c.left != null ? Helper(map, c.left.left) + Helper(map, c.left.right) : 0)
					+ (c.right != null ? Helper(map, c.right.left) + Helper(map, c.right.right) : 0);

		int rv = Math.min(Math.min(v2, v3), v1);
		map.put(root, rv);
		return rv;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
