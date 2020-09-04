/*
Sum the Difference

Problem Description
Given an integer array A of size N.

You have to find all possible non-empty subsequence of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence Then add up all the differences to get the number.

As the number may be large, output the number modulo 1e9 + 7 (1000000007).

NOTE: Subsequence can be non-contiguous.



Problem Constraints

1 <= N <= 10000

1<= A[i] <=1000



Input Format

First argument is an integer array A.


Output Format

Return an integer denoting the output.


Example Input

Input 1:

A = [1, 2]

Input 2:

A = [1]



Example Output

Output 1:

 1

Output 2:

 0



Example Explanation

Explanation 1:

All possible non-empty subsets are:
[1]    largest-smallest = 1 - 1 = 0
[2]    largest-smallest = 2 - 2 = 0
[1 2]  largest-smallest = 2 - 1 = 1
Sum of the differences = 0 + 0 + 1 = 1
So, the resultant number is 1

Explanation 2:

 Only 1 subsequence of 1 element is formed.

*/

/*
Solution Approach

It can be seen that if elements are sorted then taking any two indexes,
there will be fixed number of K elements in between then.
So you can take any number of K elements which are in between those two elemets.
So the difference of the values of those two indexes will contribute 2 to the power of K (subsets) to the answer.
So we will take all possible pairs of elements.

Example:
1 2 3 4
If we take indexes 0 and 3 ie elements 1 and 4. There are 2 elements between them (2, 3).
So 1 and 4 are be in 4 subsets which are
a) 1 4
b) 1 2 4
c) 1 3 4
d) 1 2 3 4
Which is 2 to the power of 2.
The complexity if O(N^2)

If we take close look at the approach above,
we can solve it in O(N) also.
After sorting the array,
Answer is {A[N-1]2^(N-1) +A[N-2]2^(N-2) +…..+A[0]2^0} - {A[0]2^(N-1) + A[1]2^(N-2) +……+ A[0]2^0}
*/

public class Solution {
    public int solve(int[] A) {
        Arrays.sort(A);
        int mod = 1000000007;
        long sum = 0, diff = 0;
        for(int i=0;i<A.length;i++){
            sum = (2*sum + A[A.length-1-i])%mod;
            diff = (2*diff + A[i])%mod;
        }
        
        return (int)(sum-diff+mod)%mod;
    }
}

