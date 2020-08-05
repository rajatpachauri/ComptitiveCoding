/*
Xor queries

Problem Description
You are given an array A (containing only 0 and 1) as element of N length.

Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array.


Problem Constraints

1<=N,Q<=100000
1<=L<=R<=N



Input Format

First argument contains the array of size N containing 0 and 1 only. 
Second argument contains a 2D array with Q rows and 2 columns, each row represent a query with 2 columns representing L and R.



Output Format

Return an 2D array of Q rows and 2 columns i.e the xor value and number of unset bits in that range respectively for each query.



Example Input

A=[1,0,0,0,1]
B=[ [2,4],
    [1,5],
    [3,5] ]



Example Output

[[0 3]
[0 3]
[1 2]]



Example Explanation

In the given case the bit sequence is of length 5 and the sequence is 1 0 0 0 1. 
For query 1 the range is (2,4), and the answer is (array[2] xor array[3] xor array[4]) = 0, and number of zeroes are 3, so output is 0 3. 
Similarly for other queries.
*/

/*
Solution Approach

We know x^x=0 and x^0=x where ‘^’ is the symbol for xor operation.

You should store the cumulative xor value for index i in array A i.e. A[i] will have the xor value of all the elements from 1 to i (boundary included).

You should also store the total number of ones or zeroes scanned till now, in another array say B i.e. B[i] will tell the total number of ones/zeroes from 1 to i(both inclusive).

Therefore now, xor value from L to R is A[R]^A[L-1] because, A[R] has xor values of elements from 1 to R which includes xor of 1 to L-1 and L-1 to R.

Therefore, if we take xor of A[L-1] with A[R] then, we will nullify the affect of all elements from 1 to L-1, resulting in the output of xor values from L to R.

For total number of ones/zeroes.you simply do B[R]-B[L-1].
*/

public class Solution {
    public int[][] solve(int[] A, int[][] B) {
        int[] xor = new int[A.length];
        int[] unset = new int[A.length];
        int xsf = 0;
        for(int i=0;i<xor.length;i++){
            xsf ^= A[i];
            xor[i] = xsf;
            if(i>0){
                unset[i] = unset[i-1];
            }
            if(A[i]==0)
                unset[i]++;
        }
        int res[][] = new int[B.length][2];
        for(int i=0;i<B.length;i++){
            int left = B[i][0]-1;
            int right = B[i][1]-1;
            res[i][0] = xor[right];
            res[i][1] = unset[right];
            if(left>0){
                res[i][0] ^= xor[left-1];
                res[i][1] -= unset[left-1];
            }
        }
        
        return res;
    }
}

