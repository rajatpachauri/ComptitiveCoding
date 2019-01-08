import java.util.Arrays;
import java.util.Scanner;

public class PerfectSumProblem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n;i++) {
			arr[i] = input.nextInt();
		}
		
		Arrays.sort(arr);
		
		int sum = input.nextInt();
		
		int index = Arrays.binarySearch(arr, sum);
		
		while((arr[index+1] == sum) && index+1<n) {
			index++;
		}
		

	}

}
