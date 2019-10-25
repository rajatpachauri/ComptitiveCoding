package tree;

import java.util.Scanner;

public class Morris {

	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void MorrisPreOrder(Node root) {
		Node curr = root;

		while (curr != null) {
			if (curr.left != null) {
				Node lkrm = leftKaRightMost(curr);
				if (lkrm.right == null) {
					// curr is not processed
					System.out.print(curr.data + " ");
					lkrm.right = curr;
					curr = curr.left;
				} else {
					// curr is processed & now we have to fix the tree
					lkrm.right = null;
					curr = curr.right;
				}
			} else {
				System.out.print(curr.data + " ");
				curr = curr.right;
			}
		}
		System.out.println();
	}
	
	public static void MorrisInOrder(Node root) {
		Node curr = root;

		while (curr != null) {
			if (curr.left != null) {
				Node lkrm = leftKaRightMost(curr);
				if (lkrm.right == null) {
					// curr is not processed
					lkrm.right = curr;
					curr = curr.left;
				} else {
					System.out.print(curr.data + " ");
					// curr is processed & now we have to fix the tree
					lkrm.right = null;
					curr = curr.right;
				}
			} else {
				System.out.print(curr.data + " ");
				curr = curr.right;
			}
		}
		System.out.println();
	}

	public static Node leftKaRightMost(Node node) {
		Node rv = node.left;

		while (rv.right != null && rv.right != node) {
			rv = rv.right;
		}

		return rv;
	}

	public static void morrisReverseInOrder(Node curr) {

		while (curr != null) {
			if (curr.right != null) {
				Node rklm = rightKaLeftMost(curr);
				if (rklm.right == null) {
					// curr has not been printed yet
					System.out.print(curr.data + " ");
					rklm.left = curr;
					curr = curr.right;
				} else {
					curr = curr.left;
					rklm.left = null;

				}
			} else {
				System.out.print(curr.data + " ");
				curr = curr.left;
			}
		}
		System.out.println();
	}

	public static Node rightKaLeftMost(Node node) {
		Node rv = node.right;

		while (rv.left != null && rv != node) {
			rv = rv.left;
		}

		return rv;
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " => " + node.data + " <= ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void displayPre(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		displayPre(node.left);
		displayPre(node.right);
	}

	public static void displayPost(Node node) {
		if (node == null) {
			return;
		}

		displayPre(node.left);
		displayPre(node.right);
		System.out.print(node.data + " ");

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Node[] nodes = new Node[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				nodes[i] = new Node(arr[i], null, null);

				if (i > 0) {
					int pi = (i - 1) / 2;

					if (i == 2 * pi + 1) {
						nodes[pi].left = nodes[i];
					} else {
						nodes[pi].right = nodes[i];
					}
				}
			}
		}
		scn.close();
//		displayPre(nodes[0]);
//		System.out.println();
//		MorrisPreOrder(nodes[0]);
//		morrisReverseInOrder(nodes[0]);
		MorrisInOrder(nodes[0]);

	}

}

//test case 1
/*
 * 15 1 2 3 4 5 6 7 -1 -1 8 9 -1 -1 -1 -1 1 2 4 5 8 9 3 6 7
 */

//test case 2
/*
 * 7 1 2 3 4 -1 5 -1 1 2 4 3 5
 */