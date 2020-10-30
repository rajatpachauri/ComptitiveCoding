/*
Sub-array with given sum

Problem Description

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".


Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5

Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110



Example Output

Output 1:

 [2, 3]

Output 2:

 -1



Example Explanation

Explanation 1:

 [2, 3] sums up to 5.

Explanation 2:

 No subarray sums up to required number.
*/

/*
Solution Approach

We can use 2 pointer technique to solve this problem efficiently.
WE can keep pointers left and right.
we move right if our sum is < target.
we move left when sum > target. using left and right, we get our subarray.
*/

public class Solution {
    public int[] solve(int[] arr, int B) {
        int[] A = new int[arr.length+1];
        for(int i=1;i<A.length;i++){
            A[i] = A[i-1]+arr[i-1];
        }
        int i=0;
        for(int j=1;j<A.length;j++){
            while(A[j]-A[i]>B){
                i++;
            }
            if(A[j]-A[i]==B){
                int[] res = Arrays.copyOfRange(arr,i,j);
                return res;
            }
        }
        return new int[]{-1};
    }
}
