import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class gfg_easeTheArray {
	public static void main(String[] args) throws NumberFormatException, IOException {

//		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); 
		while (t > 0) {
			--t;
			int n = Integer.parseInt(br.readLine()); 
			int[] arr = new int[n];
			
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
   
            for (int i = 0; i < n; i++) 
                arr[i] = Integer.parseInt(strs[i]); 

			int prev = 0;
			for (int curr = 1; curr < n; ++curr) {
				if (arr[curr] != 0 && arr[prev] == arr[curr]) {
					arr[prev] *= 2;
					arr[curr] = 0;
					++curr;
				}
				prev = curr;
			}

			int cursor = 0;
			for (int i = 0; i < n; ++i) {
				if (arr[i] != 0) {
					System.out.print(arr[i] + " ");
					++cursor;
				}
			}

			for (int i = cursor; i < n; ++i) {
				System.out.print("0 ");

			}

			System.out.println();

		}
	}
}
