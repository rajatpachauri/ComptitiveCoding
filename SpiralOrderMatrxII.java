/*
Spiral Order Matrix II

Problem Description

Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.


Problem Constraints

1 <= A <= 1000


Input Format

First and only argument is integer A



Output Format

Return a 2-D matrix which consists of the elements in spiral order.


Example Input

Input 1:

1

Input 2:

2



Example Output

Output 1:

[ [1] ]

Output 2:

[ [1, 2], [4, 3] ]



Example Explanation

Explanation 1:

 
Only 1 is to be arranged.

Explanation 2:

1 --> 2
      |
      |
4<--- 3
*/

public class Solution {
    
    public int[][] generateMatrix(int A) {
        int rs = 0, re = A-1, cs = 0, ce = A-1, sum=1;
        int[][] res = new int[A][A];
        while(sum<=A*A){
            for(int i=cs;i<=ce;i++){
                res[rs][i] = sum++;
            }
            rs++;
            for(int i=rs;i<=re;i++){
                res[i][ce] = sum++;
            }
            ce--;
            for(int i=ce;i>=cs;i--){
                res[re][i] = sum++;
            }
            re--;
            for(int i=re;i>=rs;i--){
                res[i][cs] = sum++;
            }
            cs++;
        }
        return res;
    }
}

