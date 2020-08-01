/*
Grid Unique Paths

Problem Description

A robot is located at the top-left corner of an A x B grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?



Problem Constraints

A and B will be such that the resulting answer fits in a 32 bit signed integer.


Input Format

First argument of input will be single integer A.
Second argument of input will be single integer B.


Output Format

Return a single integer denoting the number of unique paths.


Example Input

 A = 2, B = 2



Example Output

 2



Example Explanation

 2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
              OR  : (0, 0) -> (1, 0) -> (1, 1)

*/

/*
Solution Approach

There is a mathematical approach to solving this problem.

Note that you have to take m + n - 2 steps in total. You have to take (m - 1) steps going down and (n-1) steps going right.

Let 0 denote a down step and 1 denote a right step.

So we need to find out the number of strings of length m + n - 2 which have exactly m - 1 zeroes and n - 1 ones.

Essentially we need to choose the positions of ‘1s’, and then ‘0s’ fall into the remaining positions.

So, the answer becomes Choose(m+n-2, n - 1).
*/

public class Solution {
    public int uniquePaths(int A, int B) {
        A--;B--;
        // int ans = 1;
        // int div = 1;
        int[][] dp = new int[A+B+1][B+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=Integer.min(i,B);j++){
                if(j==0 || j==i)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
            }
        }
        
        return dp[A+B][B];
    }
}

