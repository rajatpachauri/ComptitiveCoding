import java.util.Stack;

public class checkWord {
	public static boolean isValid(String S) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < S.length(); ++i) {
			char ch = S.charAt(i);
			if (ch == 'c') {
				if (stack.size() >= 2) {
					char ch1 = stack.pop(), ch2 = stack.pop();
					if (ch1 == 'b' && ch2 == 'a')
						continue;
					else
						return false;
				} else {
					return false;
				}

			} else {
				stack.push(ch);
			}

		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String S = "bac";
		S.repla
		System.out.println(isValid(S));
	}

}
