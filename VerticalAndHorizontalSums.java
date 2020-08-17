/*
Vertical and Horizontal Sums

Problem Description

Given a matrix B, of size N x M, you are allowed to do at most A special operations on this grid such that there is no vertical or horizontal contiguous subarray that has a sum greater than C.

A special operation involves multiplying any element by -1 i.e. changing its sign.

Return 1 if it is possible to achieve the answer, otherwise 0.



Problem Constraints

1 <= N, M <= 10

0 <= A <= 5

-105 <= B[i][j], C <= 105



Input Format

The first argument is an integer A, representing the number of special operations allowed.
The second argument has the N x M integer matrix, B.
The third argument is an integer C, as described in the problem statement.


Output Format

Return 1 if it is possible to achieve the answer, otherwise 0.


Example Input

Input 1:

 A = 3
 B = [  
        [1, 1, 1]
        [1, 1, 1]
        [1, 1, 1]
     ]
 C = 2

Input 2:

 A = 1
 B = [
        [1, 1, 1]
        [1, 1, 1]
        [1, 1, 1]
     ]
 C = 2



Example Output

Output 1:

 1

Output 2:

 0



Example Explanation

Explanation 1:

 The given matrix does not satisfy the conditions, but if we apply the special operation to B[0][0], B[1][1], B[2][2],
 then the matrix would satisfy the given conditions i.e. no row or column has a sum greater than 2.

Explanation 2:

 It is not possible to apply the special operation to 1 element to satisfy the conditions.
*/

/*
 Solution Approach

As we can see from the constraints, the problem is about some kind of bruteforce/backtracking.
If we invert each and every element, then the solution would have a huge search space even for these little constraints, so we have to limit the search space as much as possible.

For this, we notice that we don’t need to invert an element in a row or column if it is never a part of a subrow or subcolumn that has a sum greater than C.
This greatly reduces the number of elements that we’ll invert.

So overall, we’ll initially call backtrack(A), if we find a subrow or subcolumn that has sum greater than C, then we can invert each and every element in the subrow or subcolumn and call for backtrack(A-1).
If any of the search spaces gives true then we will return 1.
Else we will return 0.
*/

public class Solution {
    public int solve(int A, int[][] B, int C) {
        if(isValid(B, A, C, 0)){
            return 1;
        }
        return 0;
    }
    
    public boolean isValid(int[][] B, int A, int C, int index){
        if(index==B.length*B[0].length || A==0){
            return isLess(B, C);
        }
        boolean left = isValid(B, A, C, index+1);
        B[index/B[0].length][index%B[0].length] = -B[index/B[0].length][index%B[0].length];
        boolean right = isValid(B, A-1, C, index+1);
        B[index/B[0].length][index%B[0].length] = -B[index/B[0].length][index%B[0].length];
        return left||right;
    }
    
    public boolean isLess(int[][] B, int limit){
        int max = 0;
        for(int i=0;i<B.length;i++){
            max = Integer.max(max, getRowKadanes(B[i]));
            if(max>limit){
                return false;
            }
        }
        for(int i=0;i<B[0].length;i++){
            max = Integer.max(max, getColKadanes(B, i));
            if(max>limit){
                return false;
            }
        }
        
        return max<=limit;
    }
    
    public int getRowKadanes(int[] arr){
        int max = Integer.MIN_VALUE, sum=0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            max = Integer.max(sum, max);
            if(sum<0){
                sum = 0;
            }
        }
        
        return max;
    }
    
    public int getColKadanes(int[][] arr, int index){
        int max = Integer.MIN_VALUE, sum=0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i][index];
            max = Integer.max(sum, max);
            if(sum<0){
                sum=0;
            }
        }
        
        return max;
    }
    
}

