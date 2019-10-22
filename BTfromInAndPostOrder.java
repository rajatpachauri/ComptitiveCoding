package tree;

public class BTfromInAndPostOrder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode construct(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
		if (ps > pe) {
			return null;
		}

		TreeNode rv = new TreeNode(postorder[pe]);
		int index = -1;
		for (int i = is; i <= ie; ++i) {
			if (inorder[i] == postorder[pe]) {
				index = i;
				break;
			}
		}

		int num = index - is - 1;

		rv.left = construct(inorder, postorder, is, index - 1, ps, ps + num);
		rv.right = construct(inorder, postorder, index + 1, ie, ps + num + 1, pe - 1);
		return rv;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return construct(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
