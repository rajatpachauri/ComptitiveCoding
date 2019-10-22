package tree;


public class HouseRobber3 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int rob(TreeNode root) {
		int[] mv = find(root);
		return Math.max(Math.max(mv[0], mv[1]), mv[2]);
	}

	public int[] find(TreeNode root) {
		if (root == null) {
			return new int[] { 0, 0, -100 };
		}

		int[] lv = find(root.left);
		int[] rv = find(root.right);
		int[] mv = new int[3];

		mv[0] = lv[1] + rv[1];
		mv[1] = Math.max(Math.max(rv[1], rv[2]) + lv[2], Math.max(lv[1], lv[2]) + rv[2]);
		mv[2] = root.val + Math.max(Math.max(rv[1], rv[2]), rv[0]) + Math.max(Math.max(lv[1], lv[2]), lv[0]);

		return mv;
	}
}
