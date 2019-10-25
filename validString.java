
public class validString {

	public static boolean isValid(String S) {
		int x = -1;
		for (int i = 0; i < S.length(); ++i) {
			if (S.charAt(i) == 'a') {
				x = 0;
			} else if (x == 0 && S.charAt(i) == 'b') {
				++x;
			} else if (x == 1 && S.charAt(i) == 'c') {
				return true;
			} else {
				x = -1;
			}

		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(isValid("abccbc"));	
}

}
