package tree;

import java.util.ArrayList;

import graphs.surroundingRegions;
import tree.pathsum2.TreeNode;

public class PathSum3 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int pathSum(TreeNode root, int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		return sum(root, sum, list);
	}

	private int sum(TreeNode root, int target, ArrayList<Integer> list) {
		if (root == null)
			return 0;

		list.add(root.val);
		int rv = 0, currSum = 0;
		rv += sum(root.left, target, list);
		rv += sum(root.right, target, list);

		for (int i = list.size() - 1; i >= 0; --i) {
			currSum += list.get(i);
			if (currSum == target) {
				++rv;
			}
		}

		list.remove(list.size() - 1);
		return rv;
	}

	public int sum(TreeNode root, int sum, int target) {
		if (root == null)
			return 0;

		int rv = 0;

		rv += sum(root.left, sum + root.val, target);
		rv += sum(root.right, sum + root.val, target);
		rv += sum(root.left, root.val, target);
		rv += sum(root.right, root.val, target);

		if (sum + root.val == target) {
			rv ++;
			System.out.println(root.val);
		}
		
		return rv;
	}
}
