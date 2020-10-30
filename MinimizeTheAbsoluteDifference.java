/*
Minimize the absolute difference

Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]

Output:

1

Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
*/

/*
Solution Approach

Start with the largest elements in each of the arrays A,B & C. Maintain a variable to update the answer during each of the steps to be followed.
In every step, the only possible way to decrease the difference is to decrease the maximum element out of the three elements.
So traverse to the next largest element in the array containing the maximum element for this step and update the answer variable.
Repeat this step until the array containing the maximum element ends.

For the given sample example,
initially, the triplets are { 10, 15, 6} and difference is (15 - 6) = 9 and answer is 9
in the next step, { 10, 9, 6 }, diff is (10 - 6) = 4 and answer is updated to 4
next step, { 8, 9, 6 } and diff is 3
next step, { 8, 6, 6 } and diff is 2
next step, {5, 6, 6 } and diff is 1
finally after next two steps we reach { 5, 6, 3 } and cannot continue since array B has ended. Thus the answer is 1.
Note: you can also start with min element triplet and increment the smallest element at every step.
*/

public class Solution {
    public int solve(int[] A, int[] B, int[] C) {
        int ans = Integer.MAX_VALUE;
        int i=0, j=0, k=0;
        while(i<A.length && j<B.length && k<C.length){
            ans = Integer.min(ans, max(A[i],B[j],C[k])-min(A[i],B[j],C[k]));
            int min = min(A[i], B[j], C[k]);
            if(min==A[i]){
                i++;
            }
            else if(min==B[j]){
                j++;
            }
            else{
                k++;
            }
        }
        
        return ans;
    }
    
    public int max(int a, int b, int c){
        return Integer.max(a, Integer.max(b, c));
    }
    
    public int min(int a, int b, int c){
        return Integer.min(a, Integer.min(b, c));
    }
}
