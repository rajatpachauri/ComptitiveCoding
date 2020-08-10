/*
Single Element in a Sorted Array

Problem Description

Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 10^9



Input Format

The only argument given is the integer array A.


Output Format

Return the single element that appears only once.


Example Input

Input 1:

A = [1, 1, 7]

Input 2:

A = [2, 3, 3]



Example Output

Output 1:

 7

Output 2:

 2



Example Explanation

Explanation 1:

 7 appears once

Explanation 2:

 2 appears once
*/

/*
Solution Approach

You need to return the index of 1 time occuring element >= x.
You can do this by binary search.
Note that this is classic binary search. Instead of looking for the element x,
you are looking for the least elements >= x.
You can do this by binary search.
Look for its implementation. There are multiple ways to do this.
Remember that index starts from 0.
*/

public class Solution {
    public int solve(int[] A) {
        return getElem(A, 0, A.length-1);
    }
    
    public int getElem(int[] arr, int start, int end){
        int mid = start + (end-start)/2;
        if((mid==0 && arr[mid]!=arr[mid+1]) || (mid==arr.length-1 && arr[mid-1]!=arr[mid]) || (mid>0 && arr[mid-1]!=arr[mid] && arr[mid]!=arr[mid+1]))
            return arr[mid];
            
        if(mid>0 && arr[mid-1]==arr[mid])
            mid--;
            
        if(mid%2==0){
            return getElem(arr, mid+2, end);
        }
        
        else{
            return getElem(arr, start, mid-1);
        }
    }
}

