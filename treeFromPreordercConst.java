package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class treeFromPreordercConst {

	public static class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static class Pair {
		Node node;
		int status;

		public Pair(Node node, int status) {
			this.status = status;
			this.node = node;
		}
	}

	public static Node construct(int[] arr, char[] type) {
		Node root = new Node(arr[0]);
		Stack<Pair> st = new Stack<>();
		Pair pair = new Pair(root, 0);
		st.push(pair);
		int i = 1;
		while (i < arr.length) {
			Node nn = new Node(arr[i]);
			Pair top = st.pop();

			if (top.status == 0) {
				top.node.left = nn;
			} else if (top.status == 1) {
				top.node.right = nn;
			}

			++top.status;

			if (top.status < 2) {
				st.push(top);
			}
			if (type[i] == 'n') {
				Pair np = new Pair(nn, 0);
				st.push(np);
			}
			++i;
		}

		return root;
	}

	private static void display(Node root) {
		if (root == null)
			return;
		String s = "";
		s += root.data + "->";
		if (root.left != null) {
			s += root.left.data + " ";
		}
		s += ',';
		if (root.right != null) {
			s += root.right.data + " ";
		}
		System.out.println(s);

		display(root.left);
		display(root.right);
	}

	public static boolean[][] tree2matrix(Node node) {
		int size = getSize(node);
		boolean[][] rv = new boolean[size][size];
		travel(node, rv, new ArrayList<Integer>());

		return rv;
	}

	private static void travel(Node node, boolean[][] rv, ArrayList<Integer> list) {
		if (node == null) {
			return;
		}

		list.add(node.data);

		for (int i = 0; i < list.size() - 1; ++i) {
			rv[list.get(i) - '0'][node.data - '0'] = true;
		}

		travel(node.left, rv, list);
		travel(node.right, rv, list);

		list.remove(list.size() - 1);
	}

	private static int getSize(Node node) {
		if (node == null)
			return 0;

		return 1 + getSize(node.left) + getSize(node.right);
	}

	private static void dispalyMatrix(boolean[][] arr) {
		System.out.print("{");
		for (int i = 0; i < arr.length; ++i) {
			String s = Arrays.toString(arr[i]);
			s = s.substring(1, s.length() - 1);
			s = "{" + s + "},";
			System.out.println(s);
		}
		System.out.print("}");
	}

	public static void main(String[] args) {
//		int[] arr = {10,30,20,5,15};
//		char[] type= {'n','n','l','l','l'};

//		int[] arr = { 'a', 'b', 'd', 'h', 'i', 'e', 'c', 'f', 'g', 'j', 'k' };
//		char[] type = { 'n', 'n', 'n', 'l', 'l', 'l', 'n', 'l', 'n', 'l', 'l' };

		int[] arr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		char[] type = { 'n', 'n', 'n', 'l', 'l', 'l', 'n', 'l', 'n', 'l' };

		Node root = construct(arr, type);
		display(root);

		boolean[][] bool = tree2matrix(root);
		dispalyMatrix(bool);
	}

}
