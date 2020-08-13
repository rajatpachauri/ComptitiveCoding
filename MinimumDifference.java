/*
Minimum Difference

Problem Description

You are given a 2-D matrix C of size A × B.
You need to build a new 1-D array of size A by taking one element from each row of the 2-D matrix in such a way that the cost of the newly build array is minimized.

Cost of an array is the minimum possible value of the absolute difference between any two adjacent elements of the array.

So if the newly built array is X, element picked from row 1 will become X[1], element picked from row 2 will become X[2], and so on.

Determine the minimum cost of the newly build array.



Problem Constraints

2 <= A <= 1000
2 <= B <= 1000
1 <= C[i][j] <= 106


Input Format

The first argument is an integer A denoting number of rows in the 2-D array.
The second argument is an integer B denoting number of columns in the 2-D array.
The third argument is a 2-D array C of size A x B.


Output Format

Return an integer denoting the minimum cost of the newly build array.


Example Input

Input 1:

 A = 2
 B = 2
 C = [ [8, 4]
      [6, 8] ]

Input 2:

 A = 3
 B = 2
 C = [ [7, 3]
       [2, 1]
       [4, 9] ]



Example Output

Output 1:

 0

Output 2:

 1



Example Explanation

Explanation 1:

 Newly build array : [8, 8]. The minimum cost will be 0 since the absolute difference will be 0(8-8).

Explanation 2:

 Newly build array : [3, 2, 4]. The minimum cost will be 1 since the minimum absolute difference will be 1(3 - 2).

*/

/*
Solution Approach

First in order to the further operations, you need to sort each row of the matrix.
Initialize one variable “ans” as a large value to track the latest minimum difference between two elements.
Starting from first row to second last row of matrix, for each element say A[i][j] of current row in the matrix, find the smallest element in the next row which is greater than or equal to the current element, say it a (lower bound) and the largest element which is smaller than the current element, say it b.
This can be done using Binary search (the reason we sorted each row of matrix) or using in built funtion of lower_bound .

Now, just update ans with min(ans,min(a−A[i][j],A[i][j]−b)).
*/


public class Solution {
    public int solve(int A, int B, int[][] C) {
        for(int i=0;i<A;i++){
            Arrays.sort(C[i]);
            // System.out.println(Arrays.toString(C[i]));
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<A-1;i++){
            for(int j=0;j<B;j++){
                int index = Arrays.binarySearch(C[i+1], C[i][j]);
                if(index>=0){
                    return 0;
                }
                index = Math.abs(index)-1;
                if(index==0){
                    ans = Integer.min(ans, Math.abs(C[i][j]-C[i+1][0]));
                    continue;
                }

                int min = Math.abs(C[i][j]-C[i+1][index-1]);
                
                if(index<B)
                    min = Integer.min(Math.abs(C[i+1][index]-C[i][j]), min);
                ans = Integer.min(min, ans);
            }
        }
        
        return ans;
    }
}

