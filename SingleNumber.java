/*
Single Number

Problem Description

Given an array of integers A, every element appears twice except for one. Find that single one.

NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


Problem Constraints

    2 <= |A| <= 2000000

    0 <= A[i] <= INTMAX 



Input Format

First and only argument of input contains an integer array A.


Output Format

Return a single integer denoting the single element.


Example Input

Input 1:

 A = [1, 2, 2, 3, 1]

Input 2:

 A = [1, 2, 2]



Example Output

Output 1:

 3

Output 2:

 1



Example Explanation

Explanation 1:

3 occurs once.

Explanation 2:

1 occurs once.
*/

/*
Solution Approach

We have noticed that if X has 1 in that position, we will have odd number of 1s in that position.

If X has 0 in that position, we will have odd number of 0 in that position.

If you look at the bit operators, XOR is exactly what we need.

XOR will return 1 only on two different bits. So if two numbers are the same, XOR will return 0.

Finally, there is only one number left.

A ^ A = 0 and A ^ B ^ A = B.

So, all even occurences will cancel out using XOR.
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        int ans = 0;
        for(int i=0;i<A.length;i++){
            ans ^= A[i];
        }
        
        return ans;
    }
}

