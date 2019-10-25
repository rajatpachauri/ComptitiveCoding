package tree;

public class BTfromPreOrder {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int count_dash(String str, int i) {
		int rv = 0;
		while (i < str.length()) {
			if (str.charAt(i) != '-')
				break;
			++i;
			++rv;
		}
		return rv;
	}

	public static String extract(String str, int i) {
		String rv = "";
		while (i < str.length() && str.charAt(i) != '-') {
			rv += str.charAt(i);
			++i;
		}
		return rv;
	}

	public static int index;

	public static TreeNode recoverFromPreorder(String S) {
		index = 0;
		if (S.length() == 0) {
			return null;
		} else {
			return makeTree(S, 0);
		}
	}

	public static TreeNode makeTree(String str, int depth) {
		System.out.println(index);
		if (index == str.length())
			return null;
		int dash = count_dash(str, index);
		if (depth == dash) {
			index+=dash;
			String num=extract(str, index);
			index+=num.length();
			TreeNode node = new TreeNode(Integer.parseInt(num));
			node.left=makeTree(str, depth+1);
			node.right=makeTree(str, depth+1);
			return node;
		} else {
			return null;
		}
	}
	

	public static void main(String[] args) {

		String str = "1-2--3--4-5--6--7";
		TreeNode node = recoverFromPreorder(str);

	}

}
