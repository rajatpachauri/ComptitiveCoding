import java.util.Scanner;

public class StringRotationAnagram {

	public static void main(String[] args) {
		System.out.println((-1+5)%5);
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		int q = scan.nextInt();
		int[] r = new int[q];
		String[] d = new String[q];

		for (int i = 0; i < q; ++i) {
			d[i] = scan.next();
			r[i] = scan.nextInt();
		}

		int pointer=0 , n=str.length();
		
		
		scan.close();
	}

}
