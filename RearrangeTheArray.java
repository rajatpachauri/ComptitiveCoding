/*
Rearrange the array

Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].

Rearrange the array such that A[i] = j is changed to A[j] = i for all i and j form 0 to N-1.

Note: Try solving this with O(1) extra space.


Input Format

The only argument given is the integer array A.

Output Format

Return the rearranged array A.

Constraints

1 <= N <= 100000
0 <= A[i] < N

For Example

Input 1:
    A = [1, 2, 3, 4, 0]
Output 1:
    [4, 0, 1, 2, 3]

Input 2:
    A = [2, 0, 1, 3]
Output 2:
    [1, 2, 0, 3]

*/

/*
Solution Approach

Above solution uses extra space but we can solve this problem without using any extra space by taking advantage of the fact
that array elements lies in the range 0 to n-1.
For each element A[i], we increment value present at index (A[i]%n) by i*n.
Finally, traverse the modified array and set A[i] = A[i]/n.

*/

public class Solution {
    public int[] solve(int[] A) {
        for(int i=0;i<A.length;i++){
            // System.out.println(i+","+A[i]);
            if(i==A[i]){
                // System.out.println("HI"+i);
                A[i] = -A[i]-1;
            }
            else if(A[i]>=0){
                // A[i]++;
                int curr = A[i]+1, preval = i+1;
                while(curr>0 && A[curr-1]>=0){
                    // System.out.println("--> "+(curr-1)+","+A[curr-1]);
                    A[curr-1]++;
                    int temp = A[curr-1];
                    A[curr-1] = -preval;
                    preval = curr;
                    curr = temp;
                }
            }
        }
        for(int i=0;i<A.length;i++){
            A[i] = -(A[i]+1);
        }
        
        return A;
    }
}

