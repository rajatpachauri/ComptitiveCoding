import java.util.Scanner;

public class MaxHeight {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		while(n>0) {
			int[] arr = new int[input.nextInt()*2];
			for(int i = 0;i<arr.length;i++) {
				arr[i] = input.nextInt();
			}
			int max = 0;
			for(int i = 0;i<arr.length;i+=2) {
				if(arr[i]>arr[max]) {
					max = i;
				}
			}
			System.out.println(12*arr[max] + arr[max+1]);
			n--;
		}

	}
}
