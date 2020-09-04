/*
Reverse pairs

Problem Description
Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].

Return the number of important reverse pairs in the given array A.



Problem Constraints

1 <= length of the array <= 100000

1 <= A[i] <= 10^9



Input Format

The only argument given is the integer array A.


Output Format

Return the number of important reverse pairs in the given array A.


Example Input

Input 1:

 A = [1, 3, 2, 3, 1]

Input 2:

 A = [4, 1, 2]



Example Output

Output 1:

 2

Output 2:

 1



Example Explanation

Explanation 1:

 There are two pairs which are important reverse i.e (3, 1) and (3, 1).

Explanation 2:

 There is only one pair i.e (4, 1).
*/

/*
Solution Approach

We can use two loops and calculate the number of pairs that satisfies the condition but the time complexity for this will be O(N^2) and this will not work in worst case.

So we can think of better solution i.e using merge sort.
We will do a usual merge sort but before calling the merge function we will calculate the number of pairs by using two pointers considering that the two array are sorted individually.

Likewise we will do this till the our mergesort ends i.e the array becomes sorted.

*/

public class Solution {
    
    int res = 0;
    public int solve(int[] A) {
        // System.out.println(Arrays.binarySearch(A, 4));
        // System.out.println(Arrays.binarySearch(A, 9));
        // System.out.println(Arrays.binarySearch(A, 5));
        // System.out.println(Arrays.toString(A));
        mergeSort(A, 0, A.length-1);
        // System.out.println(Arrays.toString(A));
        return res;
    }
    
    public void mergeSort(int[] A, int start, int end){
        if(start>=end){
            return;
        }
        int mid = start+(end-start+1)/2;
        mergeSort(A, start, mid-1);
        mergeSort(A, mid, end);
        int count = 0;
        for(int i=start, j=mid;i<mid;){
            if(j>end || A[i]<=2*A[j]){
                i++;
                res += count;
            }
            else{
                j++;
                count++;
            }
        }
        merge(A, start, mid, end);
    }
    
    public void merge(int[] A, int start, int mid, int end){
        int[] left = new int[mid-start];
        for(int i=0;i<left.length;i++){
            left[i] = A[i+start];
        }
        int i=0, j=mid, k =start;
        while(i<left.length && j<=end){
            if(left[i]<=A[j]){
                A[k++] = left[i++];
            }
            else{
                A[k++] = A[j++];
            }
        }
        while(i<left.length){
            A[k++] = left[i++];
        }
    }
    
}

