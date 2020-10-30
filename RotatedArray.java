/*
Rotated Arrays

Given two arrays of integers A and B, of same size, check and return whether B is rotated form of A or not. Both left and right rotations are possible.


Input Format

The first argument given is the integer array A.
The second argument given is the integer array B.

Output Format

Return 1 if B is rotated form of A else return 0.

Constraints

1 <= length of both arrays <= 100000
-10^9 <= A[i], B[i] <= 10^9 

For Example

Input 1:
    A = [1, 2, 3, 4, 5]
    B = [3, 4, 5, 1, 2]
Output 1:
    1

Input 2:
    A = [5, 17, 100, 11]
    B = [5, 100, 17, 11]
Output 2:
    0
*/

public class Solution {
    public int solve(int[] A, int[] B) {
        if(A.length!=B.length){
            return 0;
        }
        int[] arr = new int[B.length];
        int j=0;
        for(int i=1;i<B.length;){
            if(B[j]==B[i]){
                arr[i] = j+1;
                i++;
                j++;
            } else if(j!=0){
                j = arr[j-1];
            } else{
                i++;
            }
        }
        
        j = 0;
        for(int i=0;i<2*A.length;){
            int index = i%A.length;
            if(A[index]==B[j]){
                j++;
                i++;
            } else if(j==0){
                i++;
            } else{
                j = arr[j-1];
            }
            
            if(j==A.length){
                return 1;
            }
        }
        
        return 0;
        
    }
}
