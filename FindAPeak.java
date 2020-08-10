/*
Find a peak element

Problem Description

Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.


Output Format

Return the peak element.


Example Input

Input 1:

A = [1, 2, 3, 4, 5]

Input 2:

A = [5, 17, 100, 11]



Example Output

Output 1:

 5

Output 2:

 100



Example Explanation

Explanation 1:

 5 is the peak.

Explanation 2:

 100 is the peak.
*/

/*
Solution Approach

You need to return the index of peak element.
You can do this by binary search.
Note that this is classic binary search. Instead of looking for the element x,
you are looking for the least elements >= x.
You can do this by binary search.
Look for its implementation. There are multiple ways to do this.
Remember that index starts from 0.
*/

public class Solution {
    public int solve(int[] A) {
        return getPeak(A, 0, A.length-1);
    }
    
    public int getPeak(int[] arr, int start, int end){
        int mid = start + (end-start)/2;
        if(mid==0 || mid==arr.length-1)
            return arr[mid];
            
        if(arr[mid-1]<=arr[mid] && arr[mid]>=arr[mid+1]){
            return arr[mid];
        }
        else if(arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1]){
            return getPeak(arr, mid+1, end);
        }
        else if(arr[mid-1]>arr[mid] && arr[mid]>arr[mid+1]){
            return getPeak(arr, start, mid-1);
        }
        else{
            return getPeak(arr, start, mid-1);
        }
    }
    
}

