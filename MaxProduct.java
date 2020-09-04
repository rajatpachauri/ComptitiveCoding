/*
Maximum product

Given an array of integers A of size N and an integar B.

Divide all elements of A in 2 groups such that (sum of all elements in group 1)X(sum of all elements in group 2) is maximum.

Return the maximum value of (sum of all elements in group 1)X(sum of all elements in group 2).


Input Format

The first and only argument given is the integer array A.

Output Format

Return the maximum value of (sum of all elements in group 1)X(sum of all elements in group 2).

Constraints

1 <= N <= 10^2
1 <= A[i] <= 10^3

For Example

Example Input 1:
    A = [1, 3, 7, 1]
Example Output 1:
    35
Example Explanation 1:
for maximum answer:
 group 1 = [1, 3, 1]
 group 2 = [7]
 ans = 5*7  = 35

Input 2:
    A = [1, 1, 2, 2]
Output 2:
    9

*/

/*
Solution Approach:-

Observation 1:- Maximum sum of all array would be always <= 100000.

Observation 2:- Now, if we have all possible sums , our answer would be maximum of ((sums) * (total sum of array - sums)) where sum iterates over all possible sums.

To calculate all possible sums :-
To check whether a sum can be obtained by taking a subset of an array is nothing but subset sum problem and can be solved by dynamic programming , idea is :-

So it can be solved by taking a 10^5  boolean array dp. Here 10^5 is used for the sum of the elements of the array.

where dp[i] denotes whether sum i is possible or not. Initialize dp[i] for all i to be false/0. Base Case: dp[0] = 1. Recurrence is : dp[i] = dp[i-A[j]], where j goes from 1 to N and i goes from 10^5 to A[j]t

*/

public class Solution {
    public int solve(int[] A) {
        int sum = 0;
        for(int i=0;i<A.length;i++){
            sum += A[i];
        }
        
        boolean[][] strg = new boolean[A.length+1][(sum+1)/2 + 1];
        strg[0][0] = true;
        int max = 0;
        for(int i=1;i<strg.length;i++){
            for(int j=0;j<strg[0].length;j++){
                if(j==0)
                    strg[i][j] = true;
                else{
                    strg[i][j] = strg[i-1][j-1];
                    if(j-A[i-1]>=0 && strg[i-1][j-A[i-1]]){
                        strg[i][j] = true;
                    }
                }
                if(strg[i][j])
                    max = Integer.max(max, j);
            }
        }
        
        return (max)*(sum-max);
    }
}

