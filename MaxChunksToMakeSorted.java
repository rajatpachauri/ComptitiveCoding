/*
Max Chunks To Make Sorted II

Problem Description

Given an array of integers (not necessarily distinct) A, if we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?



Problem Constraints

1 <= N <= 100000
-109 <= A[i] <= 109


Input Format

The only argument given is the integer array A.


Output Format

Return the maximum number of chunks that we could have made.


Example Input

 A = [2, 0, 1, 2]



Example Output

 2



Example Explanation

 We can split the array into two subarray one consisting element [2,0,1] and second one with only element [2].
 Sort them individually and concat them. The result will be sorted.

*/

/*

Solution Approach

We take a aux sorted array to help us and count the contingous subarrays which have same elements in some different order.

One way to do it is using map to keep count of frequency difference of each element in sorted array and given array upto a certain point
and counter to keep record of unequal elements till that point(when counter is 0 increment answer).

*/

public class Solution {
    public int solve(int[] arr) {
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }

        minOfRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) res++;
        }

        return res + 1;
    }
}

