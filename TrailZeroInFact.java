/*
Trailing Zeros in Factorial

Problem Description

Given an integer A, return the number of trailing zeroes in A! i.e. factorial of A.

Note: Your solution should run in logarithmic time complexity.



Problem Constraints

1 <= A <= 109


Input Format

First and only argument is a single integer A.


Output Format

Return a single integer denoting number of zeroes.


Example Input

Input 1

 A = 5

Input 2:

 A = 6



Example Output

Output 1:

 1

Output 2:

 1



Example Explanation

Explanation 1:

 A! = 120.
 Number of trailing zeros = 1. So, return 1.

Explanation 2:

 A! = 720 
 Number of trailing zeros = 1. So, return 1.
*/

/*
 Solution Approach

The idea is:

The ZERO comes from 10.

The 10 comes from 2 x 5

And we need to account for all the products of 5 and 2, like 4×5 = 20 …

So, if we take all the numbers with 5 as a factor, we will have plenty of even numbers to pair with them to get factors of 10

Example 1:

How many multiples of 5 are there between 1 and 23?

These are 5, 10, 15, and 20, for four multiples of 5. Paired with 2s from the even factors, this makes for four factors of 10, so: 23! has 4 zeros.

Example 2:

How many multiples of 5 are there in the numbers from 1 to 100?

Because 100 ÷ 5 = 20, so, there are twenty multiples of 5 between 1 and 100.

But wait, actually 25 is 5×5, so each multiple of 25 has an extra factor of 5, e.g. 25 × 4 = 100，which introduces an extra of zero.

So, we need to know how many multiples of 25 are there between 1 and 100? Since 100 ÷ 25 = 4, there are four multiples of 25 between 1 and 100.

Finally, we get 20 + 4 = 24 trailing zeroes in 100!

The above examples tell us that we need to care about 5, 5×5, 5×5×5, 5×5×5×5 …

Example 3:

For given number 4617.

5^1 : 4617 ÷ 5 = 923.4, so we get 923 factors of 5

5^2 : 4617 ÷ 25 = 184.68, so we get 184 additional factors of 5

5^3 : 4617 ÷ 125 = 36.936, so we get 36 additional factors of 5

5^4 : 4617 ÷ 625 = 7.3872, so we get 7 additional factors of 5

5^5 : 4617 ÷ 3125 = 1.47744, so we get 1 more factor of 5

5^6 : 4617 ÷ 15625 = 0.295488, which is less than 1, so stop here.

Therefore, 4617! has 923 + 184 + 36 + 7 + 1 = 1151 trailing zeroes.
*/

public class Solution {
    public int trailingZeroes(int A) {
        int count = 0, div = 5;
        while(A/div>0){
            count += A/div;
            div *= 5;
        }
        return count;
    }
}

