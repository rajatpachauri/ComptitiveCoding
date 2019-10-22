package tree;

public class Node2NodeSum {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static int findMaxSum(Node node) {
		Helper(node);
		return sum;
	}

	public static int sum = 0;

	public static int Helper(Node node) {
		if (node == null) {
			return 0;
		} else if (node.left == null && node.right == null) {
			sum = Math.max(node.data, sum);
			return node.data;
		} else if (node.left == null) {
			int rv = Math.max(node.data, node.data + Helper(node.right));
			sum = Math.max(rv, sum);
			return rv;
		} else if (node.right == null) {
			int rv = Math.max(node.data, node.data + Helper(node.left));
			sum = Math.max(rv, sum);
			return rv;
		} else {
			int ls = Helper(node.left);
			int rs = Helper(node.right);
			int rv = Math.max(Math.max(ls, rs) + node.data, node.data);
			sum = Math.max(sum, Math.max(rv, ls + rs + node.data));
			return rv;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
