import java.util.*;

public class MaxProduct {
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			Scanner scan = new Scanner(System.in);
			int t = scan.nextInt();
			
			while(t>0){
			    --t;
				int n = scan.nextInt();
				int[] arr = new int[n];
	
				for (int i = 0; i < n; ++i) {
					arr[i] = scan.nextInt();
				}
//				int[] data = new int[n];
//	
//				Arrays.fill(data, 1);
//				for (int i = 1; i < arr.length; ++i) {
//					for (int j = 0; j < i; ++j) {
//						if (arr[i] > arr[j]) {
//							data[i] = Math.max(data[i], data[j] + 1);
//						}
//					}
//				}
	
				int max = 0;
				int compare = arr[0];
				for (int i = 1; i < n; ++i) {
					if(compare > arr[i]) {
						max++;
					}
					else {
						compare = arr[i];
					}
				}
	
				System.out.println(max);
			}
			scan.close();
	}

}
