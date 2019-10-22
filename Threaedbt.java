package tree;

public class Threaedbt {
	public static class TreeNode {
		char val;
		TreeNode left;
		TreeNode right;

		TreeNode(char x) {
			val = x;
		}
	}

	public static void threadedTraversal_in(TreeNode root) {

		while (root != null) {
			if (root.left == null) {
				System.out.println(root.val);
				root = root.right;
			} else {
				TreeNode lkarm = findrm(root);
				if (lkarm == null) {
					lkarm.right = root;
					root = root.left;
				} else {
					root.right = null;
					System.out.println(root.val);
					root = root.right;
				}
			}
		}
	}

	public static void threadedTraversal_pre(TreeNode root) {

		while (root != null) {
			if (root.left == null) {
				System.out.println(root.val);
				root = root.right;
			} else {
				TreeNode lkarm = findrm(root.left);
				if (lkarm == null) {
					System.out.println(root.val);
					lkarm.right = root;
					root = root.left;
				} else {
					root.right = null;
					root = root.right;
				}
			}
		}
	}

	private static TreeNode findrm(TreeNode node) {
		TreeNode lkrm = node.left;
		while (lkrm != null && lkrm.right != null && lkrm != node) {
			lkrm = lkrm.right;
		}
		return lkrm;
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode('a');
		TreeNode b = new TreeNode('b');
		TreeNode c = new TreeNode('c');
		TreeNode d = new TreeNode('d');
		TreeNode e = new TreeNode('e');
		TreeNode f = new TreeNode('f');
		TreeNode g = new TreeNode('g');
		TreeNode h = new TreeNode('h');
		TreeNode i = new TreeNode('i');
		TreeNode j = new TreeNode('j');
		TreeNode k = new TreeNode('k');
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		e.left = h;
		e.right = i;
		c.left = f;
		c.right = g;
		f.left = j;
		f.right = k;

		threadedTraversal_in(a);

	}
}
