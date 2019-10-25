package tree;

import java.util.*;

public class trie {
	class Trie {
		public Node root;

		/** Initialize your data structure here. */
		public Trie() {
			root = new Node('.', false);
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			insert(root, word);
		}

		private void insert(Node root, String word) {
			if (word.length() == 0) {
				root.end = true;
				return;
			}

			char ch = word.charAt(0);
			String ros = word.substring(1);

			Node child = root.children.get(ch);

			if (child != null) {
				insert(child, ros);
			} else {
				child = new Node(ch, false);
				root.children.put(ch, child);
				insert(child, ros);
			}
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			if (word.length() == 0)
				return false;
			return search(root, word);
		}

		private boolean search(Node root, String word) {
			if (word.length() == 0) {
				if (root.end)
					return true;
				else
					return false;
			}
			HashMap<Character, Node> map = root.children;
			if (!map.containsKey(word.charAt(0)))
				return false;
			else
				return search(map.get(word.charAt(0)), word.substring(1));
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String word) {
			return startsWith(root, word);
		}

		private boolean startsWith(Node node, String word) {
			if (word.length() == 0) {
				return true;
			}
			HashMap<Character, Node> map = root.children;
			if (!map.containsKey(word.charAt(0)))
				return false;
			else
				return startsWith(map.get(word.charAt(0)), word.substring(1));
		}
	}

	public class Node {
		char ch;
		boolean end;
		HashMap<Character, Node> children;

		public Node(char ch, boolean end) {
			this.ch = ch;
			this.end = end;
			children = new HashMap<>();
		}
	}

}
