/*
Special Integer

Problem Description

Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with sum of elements greater than B.


Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the maximum value of K (sub array length).


Example Input

Input 1:

A = [1, 2, 3, 4, 5]
B = 10

Input 2:

A = [5, 17, 100, 11]
B = 130



Example Output

Output 1:

 2

Output 2:

 3



Example Explanation

Explanation 1:

Constraints are satisfied for maximal value of 2.

Explanation 2:

Constraints are satisfied for maximal value of 3.
*/

/*
Solution Approach

you need to find the maximal K.
Think of a way to this by binary search.
You can use binary seacrh to find if a certain K is allowed or not.
if it is, you try finding a bigger answer
if not, try finding a smaller answer.
int l = 1, r = a.length;
while(l <= r) {
int m = (l + r) » 1;
if(check(a, b, m)) l = m + 1;
else r = m - 1;
}
return l-1;

*/


public class Solution {
    public int solve(int[] A, int B) {
        int low = 1, high = A.length;
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(check(A, B, mid))    
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low-1;
    }
    
    boolean check(int a[], int b, int m) {
        long s = 0;
        for(int i = 0; i < m; i++)  s += a[i];
        if(s > b)
            return false;
        for(int i = m; i < a.length; i++) {
            s += a[i] - a[i-m];
            if(s > b)
                return false;
        }
        return true;
    }
    
}

