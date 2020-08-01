/*
Find nth Magic Number

Problem Description

Given an integer A, find and return the Ath magic number.

A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5.

First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….



Problem Constraints

1 <= A <= 5000


Input Format

The only argument given is integer A.


Output Format

Return the Ath magic number.


Example Input

Example Input 1:

 A = 3

Example Input 2:

 A = 10



Example Output

Example Output 1:

 30

Example Output 2:

 650



Example Explanation

Explanation 1:

 A in increasing order is [5, 25, 30, 125, 130, ...]
 3rd element in this is 30

Explanation 2:

 In the sequence shown in explanation 1, 10th element will be 650.
*/

/*
Solution Approach

as we know 5n > 51 + 52 + … + 5n-1

So, we can find sum of all subset of first 13 power of 5.
since no element will overlap we will have 2^13 - 1 elements or 8000 elements.

Simply sort them and answer query in O(1).

Time complexity: since we need to find all subset sum of log A size array. Time complexity would be O(A * logA)


---------------------------------


If we notice carefully the magic numbers can be represented as 001, 010, 011, 100, 101, 110 etc, where 001 is 0*pow(5,3) + 0*pow(5,2) + 1*pow(5,1). So basically we need to add powers of 5 for each bit set in given integer n. 

*/

public class Solution {
    public int solve(int n) {
        int elem = 1, res = 0;
        while(n>0){
            elem *= 5;
            if((int)(n&1)==1){
                res += elem;
            }
            n = n>>1;
        }
        
        return res;
    }
}
	
