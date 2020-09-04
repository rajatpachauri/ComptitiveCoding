/*
Inversion count in an array

Problem Description

Given an array of integers A. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).


Problem Constraints

1 <= length of the array <= 100000

1 <= A[i] <= 10^9



Input Format

The only argument given is the integer array A.


Output Format

Return the number of inversions of A modulo (109 + 7).


Example Input

Input 1:

A = [3, 2, 1]

Input 2:

A = [1, 2, 3]



Example Output

Output 1:

3

Output 2:

0



Example Explanation

Explanation 1:

 All pairs are inversions.

Explanation 2:

 No inversions.

*/

/*
Solution Approach

Algorithm :
Traverse through the array from start to end
For every element find the count of elements smaller than the current number upto that index using another loop.
Sum up the count of inversion for every index.
Print the count of inversions.
*/

public class Solution {
    
    int count = 0;
    int mod = 1000000007;
    public int solve(int[] A) {
        mergeSort(A, 0, A.length-1);
        // System.out.println(Arrays.toString(A));
        return count;
    }
    
    public void mergeSort(int[] A, int start, int end){
        if(start>=end){
            return;
        }
        int mid = start + (end-start)/2;
        mergeSort(A, start, mid);
        mergeSort(A, mid+1, end);
        merge(A, start, mid, end);
    }
    
    public void merge(int[] A, int start, int mid, int end){
        int[] left = new int[mid-start+1];
        for(int i=start; i<=mid;i++){
            left[i-start] = A[i];
        }
        int i=0, k=start;
        for(int j=mid+1;i<left.length&&j<=end;){
            if(left[i]<=A[j]){
                A[k++] = left[i++];
            }
            else{
                count = (count+(left.length-i))%mod;
                A[k++] = A[j++];
            }
        }
        while(i<left.length){
            A[k++] = left[i++];
        }
    }
    
}

