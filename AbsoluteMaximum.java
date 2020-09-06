/*
Absolute maximum

Problem Description

Given 4 array of integers A, B, C and D of same size, find and return the maximum value of | A [ i ] - A [ j ] | + | B [ i ] - B [ j ] | + | C [ i ] - C [ j ] | + | D [ i ] - D [ j ] | + | i - j| where i != j and |x| denotes the absolute value of x.


Problem Constraints

2 <= length of the array A, B, C, D <= 100000
-106 <= A[i] <= 106


Input Format

The arguments given are the integer arrays A, B, C, D.


Output Format

Return the maximum value of | A [ i ] - A [ j ] | + | B [ i ] - B [ j ] | + | C [ i ] - C [ j ] | + | D [ i ] - D [ j ] | + | i - j|


Example Input

Input 1:

 A = [1, 2, 3, 4]
 B = [-1, 4, 5, 6]
 C = [-10, 5, 3, -8]
 D = [-1, -9, -6, -10]

Input 2:

 A = [1, 2]
 B = [3, 6]
 C = [10, 11]
 D = [1, 6]



Example Output

Output 1:

 30

Output 2:

 11



Example Explanation

Explanation 1:

 Maximum value occurs for i = 0 and j = 1.

Explanation 2:

There is only one possibility for i, j as there are only two elements in the array.
*/


/*
Solution Approach

| a - b| = { a-b if (a>=b)
             b-a  if (b>a)
           }

We can expand the absolute in two ways: a - b or b - a as shown above.

For e.g. a = 5, b = 7. b > a so absolute expansion should be b - a. If we use a - b then it’s value 5 - 7 = -2 which is less than 2 (7 - 5).
So, if we expand the 	  	operator wrong way it can’t attain maximum value.

Similary the given expression can be expanded in 32 different ways(2 ways for each absolute) and if any of the expansion is expanded wrong we can’t achieve maximum value.

Some of the ways are:
-> A[i] - A[j] + B[i] - B[j] + C[i] - C[j] + D[i] - d[j] + i - j.
-> -A[i] + A[j] + B[i] - B[j] + C[i] - C[j] + D[i] - d[j] + i - j.
-> A[i] - A[j] - B[i] + B[j] + C[i] - C[j] + D[i] - d[j] + i - j.

So try to expand the given expression in all possible 32 ways and calculate maximum among these values.

Time Complexity (32 * N) where N is the number of elemnets in all the arrays.

*/


public class Solution {
        public int solve(int[] A, int[] B, int[] C, int[] D) {
        
        int m[] = new int[5];
        int d = 0, val = 0;
        int ans = 0;
        
        // Expand the given expression in 32 diiferent ways
        for(int i = 0; i < 32; i++) {
            
            for(int j = 0; j < 5; j++) {
                m[j] = ((i >> j) & 1);
                if(m[j] == 0)   m[j] = -1;
            }
            
            int Min = Integer.MAX_VALUE;
            int Max = Integer.MIN_VALUE;
            for(int k = 0; k < A.length; k++) {
                val = A[k] * m[0] + B[k] * m[1] + C[k] * m[2] + D[k] * m[3] + k * m[4];
                Max = Math.max(Max, val);
                Min = Math.min(Min, val);
            }
            ans = Math.max(ans, Max - Min);
        }
        
        return ans;
    }
}
